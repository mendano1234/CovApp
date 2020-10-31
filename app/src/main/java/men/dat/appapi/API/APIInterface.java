package men.dat.appapi.API;

import men.dat.appapi.Model.Mundial;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {
    @GET("all")
    Call<Mundial> getInfoMundial();
}
