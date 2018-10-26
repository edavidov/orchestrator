package pro.baas.api.services;

import pro.baas.api.common.SearchCriteria;
import pro.baas.api.models.SearchResult;

public interface SearchService {
    SearchResult find(SearchCriteria query);
}
