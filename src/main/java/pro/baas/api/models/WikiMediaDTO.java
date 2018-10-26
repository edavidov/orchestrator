package pro.baas.api.models;

import lombok.Data;

@Data
public class WikiMediaDTO {
    private String title;
    private String displayTitle;
    private String description;
    private String text;
    private String textHtml;
    private String page;
}
