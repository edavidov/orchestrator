package pro.baas.api.externals.dbpedia.dto;

import lombok.Data;

import java.util.List;

@Data
public class Header {
    private List<String> link;
    private List<String> vars;
}
