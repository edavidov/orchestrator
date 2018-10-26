package pro.baas.api.data;

import pro.baas.api.common.SearchCriteria;
import pro.baas.api.models.SearchResult;

public interface DataProvider {

    SearchResult get(SearchCriteria criteria);
}
