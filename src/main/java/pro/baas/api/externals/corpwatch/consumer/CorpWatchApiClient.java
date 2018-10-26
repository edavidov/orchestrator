package pro.baas.api.externals.corpwatch.consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pro.baas.api.common.APIClient;
import pro.baas.api.common.ResponseBuilder;
import pro.baas.api.exceptions.RemoteCallException;
import pro.baas.api.externals.corpwatch.dto.CorpWatchInfo;
import pro.baas.api.models.CompanyInfoDTO;

import java.util.List;

@Component
public class CorpWatchApiClient implements APIClient<String, List<CompanyInfoDTO>> {

    @Value("${corpwatch.api.url}")
    private String SERVICE_URL;

    private final RestTemplate restTemplate;
    private final ResponseBuilder<CorpWatchInfo> responseBuilder;

    public CorpWatchApiClient(RestTemplate restTemplate, ResponseBuilder<CorpWatchInfo> responseBuilder) {
        this.restTemplate = restTemplate;
        this.responseBuilder = responseBuilder;
    }

    @Override
    public List<CompanyInfoDTO> find(final String query) {
        ResponseEntity<CorpWatchInfo> responseEntity = restTemplate.getForEntity(SERVICE_URL + query,
                                                                                 CorpWatchInfo.class);
        if (responseEntity.getStatusCode().equals(HttpStatus.OK)) {
            return responseBuilder.build(responseEntity.getBody());
        } else {
            throw new RemoteCallException(String.format("Remote call exception: %d", responseEntity
                    .getStatusCodeValue()));
        }
    }
}
