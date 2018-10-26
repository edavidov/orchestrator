package pro.baas.api.externals.wikimedia.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import pro.baas.api.common.APIClient;
import pro.baas.api.externals.wikimedia.WikiMediaResponseBuilder;
import pro.baas.api.externals.wikimedia.dto.WikiMedia;
import pro.baas.api.models.WikiMediaDTO;

@Component
@Slf4j
public class WikiMediaApiClient implements APIClient<String, WikiMediaDTO> {
    private final WikiMediaResponseBuilder responseBuilder;
    private final RestTemplate restTemplate;

    @Autowired
    public WikiMediaApiClient(WikiMediaResponseBuilder responseBuilder, RestTemplate restTemplate) {
        this.responseBuilder = responseBuilder;
        this.restTemplate = restTemplate;
    }

    @Override
    public WikiMediaDTO find(String query) {
        try {
            ResponseEntity<WikiMedia> responseEntity = restTemplate.getForEntity(query, WikiMedia.class);
            if (responseEntity.getStatusCode().equals(HttpStatus.OK)) {
                return responseBuilder.build(responseEntity.getBody());
            }
        } catch (RestClientException ex) {
            log.warn(ex.getMessage() + ":" + query);
        }
        return null;
    }

}
