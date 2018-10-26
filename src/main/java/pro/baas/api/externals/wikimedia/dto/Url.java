package pro.baas.api.externals.wikimedia.dto;

import lombok.Data;

@Data
public class Url {
    private String page;
    private String revisions;
    private String edit;
    private String talk;
}
