package pro.baas.api.externals.wikimedia.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import pro.baas.api.models.WikiMediaDTO;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface WikiMediaMapper {
    @Mappings({
            @Mapping(target = "title", source = "wikiMedia.title"),
            @Mapping(target = "displayTitle", source = "wikiMedia.displaytitle"),
            @Mapping(target = "description", source = "wikiMedia.description"),
            @Mapping(target = "text", source = "wikiMedia.extract"),
            @Mapping(target = "textHtml", source = "wikiMedia.extractHtml")
//            @Mapping(target = "page", source = "wikiMedia.contentUrls.desktop.page"),
    })
    WikiMediaDTO toDTO(WikiMedia wikiMedia);
}