package men.dat.appapi.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    public static  final String BASE_URL="https://disease.sh/v3/covid-19/";
    public static Retrofit retrofit;
    public static APIClient apiClient;

    private APIClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static synchronized APIClient getInstance(){
        if (apiClient==null){
            apiClient=new APIClient();
        }
        return apiClient;
    }
    public APIInterface getApi(){ return retrofit.create(APIInterface.class);}


}
