package pro.baas.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.baas.api.common.SearchCriteria;
import pro.baas.api.data.DataProvider;
import pro.baas.api.exceptions.EmptyCriteriaException;
import pro.baas.api.models.SearchResult;

import java.util.function.Function;

import static java.util.Optional.ofNullable;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private DataProvider dataProvider;

    @Override
    public SearchResult find(SearchCriteria query) {

        return ofNullable(query).map(getCompanyInfoList()).orElseThrow(EmptyCriteriaException::new);
    }

    private Function<SearchCriteria, SearchResult> getCompanyInfoList() {
        return criteria -> dataProvider.get(criteria);
    }
}
