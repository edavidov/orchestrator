package pro.baas.api.externals.wikimedia.dto;

import lombok.Data;

@Data
public class ApiUrl {
    private String summary;
    private String metadata;
    private String references;
    private String media;
    private String editHtml;
    private String talkPageHtml;
}
