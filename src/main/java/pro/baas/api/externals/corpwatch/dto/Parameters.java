package pro.baas.api.externals.corpwatch.dto;

import lombok.Data;

@Data
public class Parameters {
    private String limit;
    private String index;
    private String year;
    private String companyName;
    private String industryName;
    private String subdivCode;
    private String countryCode;
    private String rawAddress;
}
