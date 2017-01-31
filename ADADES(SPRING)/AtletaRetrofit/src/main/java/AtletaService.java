import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;
import java.util.Map;

public interface AtletaService {

    @GET("/atleta")
    Call<List<Atleta>> getAllAtletas();

    @GET("/atleta/{id}")
    Call<Atleta> getAtleta(@Path("id") Long id);

    @POST("/atleta")
    Call<Atleta> createAtleta(@Body Atleta athlete);

    @PUT("/atleta")
    Call<Atleta> updateAtleta(@Body Atleta athlete);

    @DELETE("/atleta/{id}")
    Call<Void> deleteAtleta(@Path("id") Long id);
}
