package pro.baas.api.externals.dbpedia.consumer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pro.baas.api.common.SearchCriteria;
import pro.baas.api.models.CompanyInfoDTO;
import pro.baas.api.models.SearchResult;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DBPediaConsumerTest {

    @Autowired
    private DBPediaConsumer consumer;

    @Test
    public void accept() throws Exception {
        //given
        SearchResult searchResult = new SearchResult();
        SearchCriteria criteria = new SearchCriteria().addNameParam("Google");

        //when
        consumer.accept(criteria, searchResult);

        //then
        assertThat(searchResult.getWikiData()).isNotNull();

    }

}