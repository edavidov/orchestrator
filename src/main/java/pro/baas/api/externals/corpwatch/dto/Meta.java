package pro.baas.api.externals.corpwatch.dto;

import lombok.Data;

@Data
public class Meta {
    private String success;
    private String status;
    private String statusString;
    private String totalResults;
    private String resultsComplete;
    private String apiVersion;
    private Parameters parameters;
}
