package pro.baas.api.externals.wikimedia;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.junit.Test;
import pro.baas.api.externals.wikimedia.dto.WikiMedia;

import java.io.File;
import java.io.IOException;

public class WikiMediaMapperTest {

    private ObjectMapper mapper = new ObjectMapper().setPropertyNamingStrategy
            (PropertyNamingStrategy.SNAKE_CASE);

    @Test
    public void testWikiMediaMapper() throws IOException {
        File file = new File(this.getClass().getResource("/wikimedia/wikimedia.json").getFile());
        mapper.readValue(file, WikiMedia.class);
    }
}
