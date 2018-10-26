package pro.baas.api.externals.dbpedia.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pro.baas.api.common.APIClient;
import pro.baas.api.common.SearchCriteria;
import pro.baas.api.common.SearchKeyEnum;
import pro.baas.api.externals.ApiConsumer;
import pro.baas.api.externals.dbpedia.dto.WikiData;
import pro.baas.api.models.SearchResult;

import java.util.Optional;

@Component
public class DBPediaConsumer implements ApiConsumer {

    @Autowired
    private APIClient<String, WikiData> apiClient;

    @Override
    public void accept(SearchCriteria criteria, SearchResult searchResult) {
        getCompanyName(criteria).ifPresent(name -> {
            WikiData wikiData = apiClient.find(name);
            searchResult.setWikiData(wikiData);
        });
    }

    private Optional<String> getCompanyName(SearchCriteria criteria) {
        if (criteria.getFilterMap().containsKey(SearchKeyEnum.BY_COMPANY_NAME)) {
            return Optional.of(criteria.getFilterMap().get(SearchKeyEnum.BY_COMPANY_NAME));
        } else return Optional.empty();
    }
}
