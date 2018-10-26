package pro.baas.api.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pro.baas.api.common.SearchCriteria;
import pro.baas.api.exceptions.EmptyCriteriaException;
import pro.baas.api.externals.ApiConsumer;
import pro.baas.api.models.SearchResult;

import java.util.List;

@Repository
public class DataProviderImpl implements DataProvider {

    private final List<ApiConsumer> consumers;


    public DataProviderImpl(@Autowired List<ApiConsumer> consumers) {
        this.consumers = consumers;
    }

    @Override
    public SearchResult get(SearchCriteria criteria) {
        if (criteria.isEmpty()) {
            throw new EmptyCriteriaException();
        }

        SearchResult searchResult = new SearchResult();

        consumers.parallelStream().
                forEach(detailConsumer -> detailConsumer.accept(criteria, searchResult));
        return searchResult;
    }

}
