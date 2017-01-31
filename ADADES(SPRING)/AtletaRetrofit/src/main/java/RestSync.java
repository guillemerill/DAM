import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;


public class RestSync {
    private static Retrofit retrofit;

    public static void main(String[] args) throws IOException {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8484")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        AtletaService atletaService = retrofit.create(AtletaService.class);

        // CRUD
        Atleta atleta = new Atleta("Guillem", "Erill", "España", LocalDate.of(1996, 11, 24));
        Response<Atleta> postAthletes = atletaService.createAtleta(atleta).execute();

        if (postAthletes.isSuccessful()) {
            Atleta a = postAthletes.body();
            System.out.println("STATUS: " + postAthletes.code() + System.lineSeparator() +
                    "Atleta: " + a);


            a.setApellidos("Erill Soto");
            Response<Atleta> updateAtleta = atletaService.updateAtleta(a).execute();

            if (updateAtleta.isSuccessful()) {
                System.out.println("Status code: " + updateAtleta.code() + System.lineSeparator() +
                        "PUT player: " + updateAtleta.body());
            } else {
                System.out.println("Status code: " + updateAtleta.code() + "Message error: " + updateAtleta.errorBody());
            }

            // Eliminar athleta
            Response<Void> deleteAtleta = atletaService.deleteAtleta(a.getId()).execute();
            System.out.println("DELETE status code: " + deleteAtleta.code());


            // Mostrar todos los atletas
            System.out.println("Mostrando todos los atletas: ");
            Response<List<Atleta>> response = atletaService.getAllAtletas().execute();

            if (response.isSuccessful()) {
                List<Atleta> JugadorList = response.body();
                System.out.println(System.lineSeparator() + JugadorList);
            } else {
                System.out.println("ERROR " + response.code() + ": " + response.errorBody());
            }
        }
    }
}
