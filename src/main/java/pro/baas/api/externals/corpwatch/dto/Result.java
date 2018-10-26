package pro.baas.api.externals.corpwatch.dto;

import lombok.Data;

import java.util.Map;

@Data
public class Result {
    Map<String, Company> companies;
}
