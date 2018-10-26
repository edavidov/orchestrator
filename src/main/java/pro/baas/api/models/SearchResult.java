package pro.baas.api.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pro.baas.api.common.SearchCriteria;
import pro.baas.api.externals.dbpedia.dto.WikiData;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchResult {
    private SearchCriteria searchCriteria;
    private List<CompanyInfoDTO> companyInfos;
    private WikiMediaDTO wikiMediaDTO;
    private WikiData wikiData;
}
