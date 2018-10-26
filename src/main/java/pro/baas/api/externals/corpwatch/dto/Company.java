package pro.baas.api.externals.corpwatch.dto;

import lombok.Data;

@Data
public class Company {
    private String cwId;
    private String cik;
    private String companyName;
    private String irsNumber;
    private String sicCode;
    private String industryName;
    private String sicSector;
    private String sectorName;
    private String sourceType;
    private String rawAddress;
    private String countryCode;
    private String subdivCode;
    private String topParentId;
    private String numParents;
    private String numChildren;
    private String maxYear;
    private String minYear;
}
