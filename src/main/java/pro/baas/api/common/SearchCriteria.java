package pro.baas.api.common;

import lombok.Getter;
import lombok.ToString;
import org.springframework.util.StringUtils;

import java.util.LinkedHashMap;
import java.util.Map;

@ToString
public class SearchCriteria {

    @Getter
    private Map<SearchKeyEnum, String> filterMap = new LinkedHashMap<>();

    public boolean isEmpty() {
        return filterMap.isEmpty();
    }

    public SearchCriteria addNameParam(String companyName) {
        addKeyValue(SearchKeyEnum.BY_COMPANY_NAME, companyName);
        return this;
    }

    public SearchCriteria addCountryParam(final String country) {
        addKeyValue(SearchKeyEnum.BY_COUNTRY, country);
        return this;
    }

    public SearchCriteria addStateParam(final String state) {
        addKeyValue(SearchKeyEnum.BY_STATE, state);
        return this;
    }

    public SearchCriteria addAddressParam(final String address) {
        addKeyValue(SearchKeyEnum.BY_ADDRESS, address);
        return this;
    }

    public SearchCriteria addIndustryParam(final String industry) {
        addKeyValue(SearchKeyEnum.BY_INDUSTRY, industry);
        return this;
    }

    private void addKeyValue(SearchKeyEnum key, String value) {
        if(!StringUtils.isEmpty(value)) {
            this.filterMap.put(key, value);
        }
    }



}
