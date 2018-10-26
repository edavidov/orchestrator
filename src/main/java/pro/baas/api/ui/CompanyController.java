package pro.baas.api.ui;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.baas.api.common.SearchCriteria;
import pro.baas.api.models.SearchResult;
import pro.baas.api.services.SearchService;

import java.io.IOException;

@RestController
@RequestMapping("/api/")
@Slf4j
public class CompanyController {

    @Autowired
    SearchService searchService;

    @ApiOperation(
            value = "Finds Company by name",
            response = SearchResult.class)
    @GetMapping(value = "companies.json")
    public ResponseEntity<SearchResult> getByName(
            @ApiParam(value = "Company Name that need to be find") @RequestParam(name = "company_name", required = false) String name,
            @ApiParam(value = "Company Country that need to be find") @RequestParam(name = "country", required = false) String country,
            @ApiParam(value = "Company State that need to be find") @RequestParam(name = "state", required = false) String state,
            @ApiParam(value = "Company Address that need to be find") @RequestParam(name = "address", required = false) String address,
            @ApiParam(value = "Company Industry that need to be find") @RequestParam(name = "industry", required = false) String industry
    ) throws IOException {
        try {

            SearchCriteria criteria = new SearchCriteria()
                    .addNameParam(name)
                    .addCountryParam(country)
                    .addAddressParam(address)
                    .addIndustryParam(industry)
                    .addStateParam(state);

            return ResponseEntity.ok(searchService.find(criteria));
        } catch (Exception e) {
           // log.warn(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

}
