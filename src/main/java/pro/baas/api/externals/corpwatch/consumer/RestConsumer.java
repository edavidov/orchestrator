package pro.baas.api.externals.corpwatch.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pro.baas.api.common.APIClient;
import pro.baas.api.common.SearchCriteria;
import pro.baas.api.common.SearchKeyEnum;
import pro.baas.api.externals.ApiConsumer;
import pro.baas.api.models.CompanyInfoDTO;
import pro.baas.api.models.SearchResult;

import java.util.List;

@Component
@Slf4j
public class RestConsumer implements ApiConsumer {

    private APIClient<String, List<CompanyInfoDTO>> apiClient;
    private RequestPathBuilder pathBuilder;

    public RestConsumer(RequestPathBuilder pathBuilder, APIClient<String, List<CompanyInfoDTO>> apiClient) {
        this.apiClient = apiClient;
        this.pathBuilder = pathBuilder;
    }

    @Override
    public void accept(SearchCriteria criteria, SearchResult searchResult) {
        log.info("Executed CorpWatch consumer with criteria" + criteria.toString());

        if (!criteria.isEmpty()) {
            searchResult.setCompanyInfos(retrieveWithRetrieve(criteria));
        }
    }

    private List<CompanyInfoDTO> retrieveWithRetrieve(SearchCriteria criteria) {
        List<CompanyInfoDTO> result = getCompanyInfos(criteria);
        if (result.isEmpty()) {
            criteria = new SearchCriteria().addNameParam(criteria.getFilterMap().get(SearchKeyEnum.BY_COMPANY_NAME));
            result = getCompanyInfos(criteria);
        }
        return result;
    }

    private List<CompanyInfoDTO> getCompanyInfos(SearchCriteria criteria) {
        return apiClient.find(pathBuilder.buildPath(criteria));
    }
}
