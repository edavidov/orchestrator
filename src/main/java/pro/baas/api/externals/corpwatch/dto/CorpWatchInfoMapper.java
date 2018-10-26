package pro.baas.api.externals.corpwatch.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import pro.baas.api.models.CompanyInfoDTO;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CorpWatchInfoMapper {

    @Mappings({
            @Mapping(target = "id", source = "company.cwId"),
            @Mapping(target = "name", source = "company.companyName"),
            @Mapping(target = "irsNumber", source = "company.irsNumber"),
            @Mapping(target = "industry", source = "company.industryName"),
            @Mapping(target = "sector", source = "company.sectorName"),
            @Mapping(target = "address", source = "company.rawAddress"),
            @Mapping(target = "country", source = "company.countryCode"),
            @Mapping(target = "subdiv", source = "company.subdivCode")})
    CompanyInfoDTO toDTO(Company company);
}
