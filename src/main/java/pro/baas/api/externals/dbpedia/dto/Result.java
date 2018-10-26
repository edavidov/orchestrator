package pro.baas.api.externals.dbpedia.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Result {
    private boolean distinct;
    private boolean ordered;
    private List<Map<String, Binding>> bindings;

}
