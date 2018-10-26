package pro.baas.api.common;

public enum SearchKeyEnum {
    BY_COMPANY_NAME("company_name"),
    BY_STATE("subdiv_code"),
    BY_COUNTRY("country_code"),
    BY_ADDRESS("raw_address"),
    BY_INDUSTRY("industry_name");

    private String value;

    SearchKeyEnum(String data) {
        this.value = data;
    }

    @Override
    public String toString() {
        return value;
    }
}
