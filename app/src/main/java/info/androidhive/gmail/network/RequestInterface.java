package info.androidhive.gmail.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Streaming;

public interface RequestInterface {

    @GET("/diag.json")
    Call<JSONResponse> getJSON();
}
