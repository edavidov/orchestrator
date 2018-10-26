package pro.baas.api.externals.dbpedia;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.junit.Test;
import pro.baas.api.externals.dbpedia.dto.WikiData;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class WikiDataMapperTest {
    private ObjectMapper mapper = new ObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

    @Test
    public void testWikiMediaMapper() throws IOException {
        File file = new File(this.getClass().getResource("/dbpedia/dbpedia.json").getFile());
        WikiData wikiData = mapper.readValue(file, WikiData.class);

        assertThat(wikiData).isNotNull();
    }
}
