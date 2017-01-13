import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface AtletaService {
    @GET("/atleta")
    Call<List<Atleta>> getAllAtletas();

    @GET("/atleta/{id}")
    Call<Atleta> getAtleta(@Path("id") Long id);

    @GET("/atletasError")
    Call<List<Atleta>> getError();

    @POST("/atleta")
    Call<Atleta> creaAtleta(@Body Atleta atleta);

    @PUT("/atleta")
    Call<Atleta> updateAtleta(@Body Atleta atleta);

    @DELETE("/atleta/{id}")
    Call<Void> deleteAtleta(@Path("id") Long id);
}
