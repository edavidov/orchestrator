package pro.baas.api.data;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import pro.baas.api.common.SearchCriteria;
import pro.baas.api.exceptions.EmptyCriteriaException;
import pro.baas.api.externals.ApiConsumer;
import pro.baas.api.models.SearchResult;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class DataProviderTest {

    private ApiConsumer apiConsumer = mock(ApiConsumer.class);

    private DataProvider dataProvider = new DataProviderImpl(Collections.singletonList(apiConsumer));

    @Test(expected = EmptyCriteriaException.class)
    public void get() {
        //when
        dataProvider.get(new SearchCriteria());
    }

    @Test
    public void getCompaniesByName() {
        //given
        SearchCriteria criteria = new SearchCriteria();
        criteria.addNameParam("companyName");

        //when
        SearchResult infos = dataProvider.get(criteria);

        //then
        assertThat(infos).isNotNull();
        verify(apiConsumer).accept(eq(criteria), any());
    }

}