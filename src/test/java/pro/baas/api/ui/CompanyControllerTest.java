package pro.baas.api.ui;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import pro.baas.api.configuration.OrchestratorConfiguration;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.not;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ComponentScan(basePackages = "pro.baas.api")
@WebMvcTest(CompanyController.class)
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = OrchestratorConfiguration.class)
@AutoConfigureWebClient
public class CompanyControllerTest {

    private static final String COMPANY_CONTROLLER_URL = "/api/";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getByName() throws Exception {
        //when
        mockMvc.perform(buildGetRequest("companies.json").param("country", "US")
                                                         .param("state", "IL")
                                                         .param("industry", "Pharmaceutica"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$", not(empty())));

    }

    private MockHttpServletRequestBuilder buildGetRequest(final String url) {
        return get(COMPANY_CONTROLLER_URL + url).contentType(MediaType.APPLICATION_JSON);
    }

}