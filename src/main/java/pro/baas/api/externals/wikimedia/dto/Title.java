package pro.baas.api.externals.wikimedia.dto;

import lombok.Data;

@Data
public class Title {
    private String canonical;
    private String normalized;
    private String display;
}
