package pro.baas.api.externals.corpwatch.consumer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pro.baas.api.common.SearchCriteria;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class RequestPathBuilderTest {

    @Parameterized.Parameter()
    public SearchCriteria searchCriteria;

    @Parameterized.Parameter(value = 1)
    public String expectedPath;
    private RequestPathBuilder pathBuilder = new RequestPathBuilder();

    @Parameterized.Parameters(name = "{index}: Param({0})={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { new SearchCriteria().addNameParam("Safeway Inc"), "/companies.json?company_name=Safeway+Inc" },
                { new SearchCriteria().addNameParam("Google"), "/companies.json?company_name=Google" },
                { new SearchCriteria().addCountryParam("IE"), "/companies.json?country_code=IE" },
                { new SearchCriteria().addStateParam("AR"), "/companies.json?subdiv_code=AR" },
                { new SearchCriteria().addAddressParam("empire"), "/companies.json?raw_address=empire" },
                { new SearchCriteria().addIndustryParam("Banking"), "/companies.json?industry_name=Banking" },

                { new SearchCriteria()
                        .addNameParam("Google")
                        .addCountryParam("IE")
                        .addStateParam("AR")
                        .addIndustryParam("Banking")
                        .addAddressParam("empire"),
                        "/companies.json?company_name=Google&country_code=IE&subdiv_code=AR&industry_name=Banking&raw_address=empire" },

        });
    }

    @Test
    public void shouldBuildPathToSearchByCompanyName() {
        //when
        String path = pathBuilder.buildPath(searchCriteria);

        //then
        assertThat(expectedPath).isEqualTo(path);
    }
}