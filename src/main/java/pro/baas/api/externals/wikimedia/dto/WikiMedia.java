package pro.baas.api.externals.wikimedia.dto;

import lombok.Data;

import java.util.Map;

@Data
public class WikiMedia {

    private String type;
    private String title;
    private String displaytitle;
    private Namespace namespace;
    private Title titles;
    private String pageid;
    private Image thumbnail;
    private Image originalimage;
    private String lang;
    private String dir;
    private String revision;
    private String tid;
    private String timestamp;
    private String description;
    private Map<String, Url> contentUrls;
    private ApiUrl apiUrls;
    private String extract;
    private String extractHtml;

}
