package pro.baas.api.externals.corpwatch;

import org.junit.Test;
import org.mapstruct.factory.Mappers;
import pro.baas.api.common.ResponseBuilder;
import pro.baas.api.externals.corpwatch.dto.Company;
import pro.baas.api.externals.corpwatch.dto.CorpWatchInfo;
import pro.baas.api.externals.corpwatch.dto.CorpWatchInfoMapper;
import pro.baas.api.externals.corpwatch.dto.Result;
import pro.baas.api.models.CompanyInfoDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class CorpResponseBuilderTest {

    private CorpWatchInfoMapper mapper = Mappers.getMapper(CorpWatchInfoMapper.class);

    private ResponseBuilder<CorpWatchInfo> responseBuilder = new CorpResponseBuilder(mapper);


    @Test
    public void build() throws Exception {
        //given
        CorpWatchInfo corpWatchInfo = buildCorpWatchDTO();

        //when
        List<CompanyInfoDTO> response = responseBuilder.build(corpWatchInfo);

        //then
        assertThat(response).isNotNull();
        assertThat(response).hasSize(2);
    }

    private CorpWatchInfo buildCorpWatchDTO() {
        CorpWatchInfo corpWatchInfo = new CorpWatchInfo();
        Result result = new Result();
        Map<String, Company> companyMap = new HashMap<>();
        companyMap.put("key1", new Company());
        companyMap.put("key2", new Company());

        result.setCompanies(companyMap);

        corpWatchInfo.setResult(result);
        return corpWatchInfo;
    }

}