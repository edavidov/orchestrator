package pro.baas.api.externals.corpwatch;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pro.baas.api.externals.corpwatch.dto.CorpWatchInfo;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class CorpWatchMapperTest {

    private ObjectMapper mapper = new ObjectMapper().setPropertyNamingStrategy
            (PropertyNamingStrategy.SNAKE_CASE);

    @Parameterized.Parameter()
    public String filePath;


    @Parameterized.Parameters(name = "filePath: {0}")
    public static Collection<String> data() {
        return Arrays.asList(
                "/corpwatch/company_response_by_id.json",
                "/corpwatch/33.json");
    }


    @Test
    public void testMapper() throws IOException {
        File file = new File(this.getClass().getResource(filePath).getFile());
        CorpWatchInfo model = mapper.readValue(file, CorpWatchInfo.class);
        assertThat(model).isNotNull();
    }

}