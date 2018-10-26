package pro.baas.api.externals.wikimedia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pro.baas.api.externals.wikimedia.dto.WikiMedia;
import pro.baas.api.externals.wikimedia.dto.WikiMediaMapper;
import pro.baas.api.models.WikiMediaDTO;

@Component
public class WikiMediaResponseBuilder {

    private final WikiMediaMapper mapper;

    public WikiMediaResponseBuilder(@Autowired WikiMediaMapper mapper) {
        this.mapper = mapper;
    }

    public WikiMediaDTO build(WikiMedia model) {
        return mapper.toDTO(model);
    }
}
