package pro.baas.api.externals.corpwatch.dto;

import org.junit.Test;
import org.mapstruct.factory.Mappers;
import pro.baas.api.models.CompanyInfoDTO;

import static org.assertj.core.api.Assertions.assertThat;

public class CorpWatchInfoMapperTest {

    private CorpWatchInfoMapper mapper = Mappers.getMapper(CorpWatchInfoMapper.class);


    @Test
    public void companyToCompanyInfoDTO() throws Exception {
        //given
        Company company = new Company();
        String id = "123";
        String companyName = "Google";
        String countryCode = "USA";
        String industryName = "IT";
        String irsNumber = "irs123";
        String address = "Washington str. 123 NY";
        String subdivCode = "ALABAMA";
        String sector = "sector";

        company.setCwId(id);
        company.setCompanyName(companyName);
        company.setCountryCode(countryCode);
        company.setIndustryName(industryName);
        company.setIrsNumber(irsNumber);
        company.setRawAddress(address);
        company.setSectorName(sector);
        company.setSubdivCode(subdivCode);


        //when
        CompanyInfoDTO companyInfoDTO = mapper.toDTO(company);

        //then
        assertThat(companyInfoDTO)
                .hasFieldOrPropertyWithValue("id", id)
                .hasFieldOrPropertyWithValue("name", companyName)
                .hasFieldOrPropertyWithValue("industry", industryName)
                .hasFieldOrPropertyWithValue("country", countryCode)
                .hasFieldOrPropertyWithValue("irsNumber", irsNumber)
                .hasFieldOrPropertyWithValue("address", address)
                .hasFieldOrPropertyWithValue("sector", sector)
                .hasFieldOrPropertyWithValue("subdiv", subdivCode);

    }

}