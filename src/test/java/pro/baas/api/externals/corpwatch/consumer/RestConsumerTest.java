package pro.baas.api.externals.corpwatch.consumer;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import pro.baas.api.common.APIClient;
import pro.baas.api.common.SearchCriteria;
import pro.baas.api.externals.ApiConsumer;
import pro.baas.api.models.CompanyInfoDTO;
import pro.baas.api.models.SearchResult;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RestConsumerTest {

    @Mock
    private APIClient<String, List<CompanyInfoDTO>> apiClient;

    @Mock
    private RequestPathBuilder pathBuilder;

    @InjectMocks
    private ApiConsumer restConsumer = new RestConsumer(pathBuilder, apiClient);

    private SearchResult searchResult;

    @Before
    public void setUp() {
        searchResult = new SearchResult();
    }

    @Test
    public void shouldAccept() {
        //given
        String companyName = "Google";
        String url = "url";
        SearchCriteria criteria = new SearchCriteria().addNameParam(companyName);
        when(pathBuilder.buildPath(any())).thenReturn(url);
        when(apiClient.find(url)).thenReturn(Collections.emptyList());

        //when
        restConsumer.accept(criteria, searchResult);

        //then
        verify(apiClient, times(2)).find(any());
        verify(pathBuilder, times(2)).buildPath(any());
    }
}