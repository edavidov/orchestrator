package pro.baas.api.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyInfoDTO {
    private String id;
    private String name;
    private String irsNumber;
    private String industry;
    private String sector;
    private String address;
    private String country;
    private String subdiv;
}
