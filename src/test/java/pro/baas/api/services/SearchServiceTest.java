package pro.baas.api.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import pro.baas.api.common.SearchCriteria;
import pro.baas.api.data.DataProvider;
import pro.baas.api.exceptions.EmptyCriteriaException;
import pro.baas.api.models.SearchResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SearchServiceTest {

    @Mock
    private DataProvider dataProvider;

    @InjectMocks
    private SearchService searchService = new SearchServiceImpl();

    @Test
    public void find() {
        //given
        SearchCriteria criteria = new SearchCriteria();
        when(dataProvider.get(criteria)).thenReturn(mock(SearchResult.class));

        //when
        SearchResult result = searchService.find(criteria);

        //then
        verify(dataProvider).get(criteria);
        assertThat(result).isNotNull();

    }

    @Test(expected = EmptyCriteriaException.class)
    public void findShouldNotBeExecutedOnNullCriteria() {

        //when
        searchService.find(null);

        //then
        verifyZeroInteractions(dataProvider);
    }

}