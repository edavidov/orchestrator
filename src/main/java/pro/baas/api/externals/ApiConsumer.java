package pro.baas.api.externals;

import pro.baas.api.common.SearchCriteria;
import pro.baas.api.models.SearchResult;

import java.util.function.BiConsumer;

public interface ApiConsumer extends BiConsumer<SearchCriteria, SearchResult> {

}
