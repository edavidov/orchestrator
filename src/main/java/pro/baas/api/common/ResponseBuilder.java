package pro.baas.api.common;

import pro.baas.api.models.CompanyInfoDTO;

import java.util.List;

public interface ResponseBuilder<T> {

    List<CompanyInfoDTO> build(T model);

}
