package pro.baas.api.externals.dbpedia.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import pro.baas.api.common.APIClient;
import pro.baas.api.externals.dbpedia.dto.WikiData;

import java.io.UnsupportedEncodingException;

@Component
@Slf4j
public class DBPediaApiClient implements APIClient<String, WikiData> {


    @Autowired
    private RequestUrlBuilder requestUrlBuilder;

    private final RestTemplate restTemplate;

    @Autowired
    public DBPediaApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public WikiData find(String query) {
        try {
            ResponseEntity<WikiData> responseEntity = restTemplate.getForEntity(requestUrlBuilder.buildUrl(query),
                                                                                WikiData.class);
            if (responseEntity.getStatusCode().equals(HttpStatus.OK)) {
                return responseEntity.getBody();
            }
        } catch (RestClientException | UnsupportedEncodingException ex) {
            log.warn(ex.getMessage() + ":" + query);
        }
        return null;
    }
}
