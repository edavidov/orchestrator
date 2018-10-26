package pro.baas.api.externals.corpwatch.consumer;

import org.springframework.stereotype.Component;
import pro.baas.api.common.SearchCriteria;
import pro.baas.api.common.SearchKeyEnum;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class RequestPathBuilder {

    private static final String PATH_PREFIX = "/companies.json?";
    private static final String DELIMITER = "&";
    private static final String SPACE_CHARACTER = "+";

    public String buildPath(SearchCriteria searchCriteria) {

        Set<SearchKeyEnum> keys = searchCriteria.getFilterMap().keySet();

        return PATH_PREFIX + keys.stream()
                .map(key -> buildParam(searchCriteria, key))
                .collect(Collectors.joining(DELIMITER));
    }

    private String buildParam(final SearchCriteria searchCriteria, final SearchKeyEnum key) {
        return key.toString() + "=" + replaceUnderscores(searchCriteria.getFilterMap().get(key));
    }

    private String replaceUnderscores(String data) {
        return data.trim().replaceAll(" ", SPACE_CHARACTER);
    }

}
