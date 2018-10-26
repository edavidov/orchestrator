package pro.baas.api.externals.dbpedia.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class Binding {
    private String type;
    private String value;
    @JsonAlias(value = "xml:lang")
    private String xmlLang;
    private String datatype;
}
