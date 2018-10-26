package pro.baas.api.common;

public interface APIClient<R, T> {

    T find(R query);

}
