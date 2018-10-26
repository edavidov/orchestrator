package pro.baas.api.externals.wikimedia.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pro.baas.api.common.APIClient;
import pro.baas.api.common.SearchCriteria;
import pro.baas.api.common.SearchKeyEnum;
import pro.baas.api.externals.ApiConsumer;
import pro.baas.api.models.SearchResult;
import pro.baas.api.models.WikiMediaDTO;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Optional;

import static java.util.Optional.ofNullable;

@Component
@Slf4j
public class WikiConsumer implements ApiConsumer {

    private static final String PAGE_PATH = "page/summary/";

    @Value("${wikimedia.api.url}")
    private String hostUrl;

    @Autowired
    private APIClient<String, WikiMediaDTO> apiClient;

    @Override
    public void accept(SearchCriteria criteria, SearchResult searchResult) {
        buildQueryString(criteria).ifPresent(query -> {
            WikiMediaDTO media = apiClient.find(query);
            searchResult.setWikiMediaDTO(media);
        });
    }

    private Optional<String> buildQueryString(SearchCriteria criteria) {
        return ofNullable(getCompanyName(criteria)).map(this::buildUrl);
    }

    private String buildUrl(String name) {
        try {
            return hostUrl + PAGE_PATH + URLEncoder.encode(name, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    private String getCompanyName(SearchCriteria criteria) {
        return criteria.getFilterMap().computeIfAbsent(SearchKeyEnum.BY_COMPANY_NAME, searchKeyEnum -> null);
    }
}
