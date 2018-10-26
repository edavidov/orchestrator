package pro.baas.api.externals.corpwatch;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pro.baas.api.common.ResponseBuilder;
import pro.baas.api.externals.corpwatch.dto.Company;
import pro.baas.api.externals.corpwatch.dto.CorpWatchInfo;
import pro.baas.api.externals.corpwatch.dto.CorpWatchInfoMapper;
import pro.baas.api.models.CompanyInfoDTO;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

@Component
public class CorpResponseBuilder implements ResponseBuilder<CorpWatchInfo> {


    private final CorpWatchInfoMapper mapper;

    public CorpResponseBuilder(@Autowired CorpWatchInfoMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<CompanyInfoDTO> build(CorpWatchInfo model) {
        Map<String, Company> companyMap = model.getResult().getCompanies();
        if (ofNullable(companyMap).isPresent()) {
            return companyMap.values().parallelStream().map(this::mapCompany).collect(Collectors.toList());
        } else return Collections.emptyList();
    }


    private CompanyInfoDTO mapCompany(Company company) {
        return mapper.toDTO(company);
    }
}
