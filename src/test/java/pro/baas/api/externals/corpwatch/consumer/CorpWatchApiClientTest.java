package pro.baas.api.externals.corpwatch.consumer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import pro.baas.api.common.APIClient;
import pro.baas.api.common.ResponseBuilder;
import pro.baas.api.exceptions.RemoteCallException;
import pro.baas.api.externals.corpwatch.dto.CorpWatchInfo;
import pro.baas.api.models.CompanyInfoDTO;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.endsWith;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CorpWatchApiClientTest {

    private RestTemplate restTemplate = mock(RestTemplate.class);
    private ResponseBuilder<CorpWatchInfo> responseBuilder = mock(ResponseBuilder.class);

    @InjectMocks
    private APIClient<String, List<CompanyInfoDTO>> corpWatchApiClient = new CorpWatchApiClient(restTemplate, responseBuilder);

    @Test
    public void find() throws Exception {
        //given
        String query = "test";

        when(restTemplate.getForEntity(endsWith(query), eq(CorpWatchInfo.class)))
                .thenReturn(ResponseEntity.ok(mock(CorpWatchInfo.class)));

        //when
        List<CompanyInfoDTO> result = corpWatchApiClient.find(query);

        //then
        verify(restTemplate).getForEntity(endsWith(query), eq(CorpWatchInfo.class));
        assertThat(result).isNotNull();
    }

    @Test(expected = RemoteCallException.class)
    public void findShouldThrowRemoteException() throws Exception {
        //given
        String query = "test";

        when(restTemplate.getForEntity(endsWith(query), eq(CorpWatchInfo.class)))
                .thenReturn(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
        //when
        corpWatchApiClient.find(query);
    }


}