import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;


public class RestSync {
    private static Retrofit retrofit;

    public static void main(String[] args) throws IOException {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8484")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AtletaService atletaService = retrofit.create(AtletaService.class);

        Call<List<Atleta>> callAllAtletas = atletaService.getAllAtletas();
        Response<List<Atleta>> response = callAllAtletas.execute();
        if (response.isSuccessful()) {
            List<Atleta> atletas = response.body();
            System.out.println("STATUS CODE: " + response.code() + System.lineSeparator() +
                    "Todos los atletas: " + atletas);
        } else {
            System.out.println("STATUS CODE: " + response.code() + ": " + response.errorBody());
        }

        Call<List<Atleta>> callUrlError = atletaService.getError();
        response = callUrlError.execute();
        if (!response.isSuccessful()) {
            System.out.println("STATUS CODE: "+response.code() + ": "+response.raw());
        }

        Call<Atleta> callAtleta = atletaService.getAtleta(3L);
        Response<Atleta> response2 = callAtleta.execute();

        if (response2.isSuccessful()) {
            System.out.println("STATUS CODE: " + response2.code()+ " Atleta: " + response2.body());
        } else {
            System.out.println("STATUS CODE: " + response2.code() + ": " + response2.errorBody());
        }
    }
}
