import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
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


        // Mostrar todos los atletas
        System.out.println("Mostrando todos los atletas: ");
        Response<List<Atleta>> response = atletaService.getAllAtletas().execute();

        if(response.isSuccessful()) {
            List<Atleta> JugadorList = response.body();
            System.out.println(System.lineSeparator()+ JugadorList);
        }else{
            System.out.println("ERROR " + response.code() +  ": " + response.errorBody());
        }

        // 1. Devolver todos los Atletas de una nacionalidad determinada
        System.out.println("Mostrando los atletas de Kenia: ");
        Response<List<Atleta>> response2 = atletaService.getAtletasByNacionalidad("Kenia").execute();
        if(response2.isSuccessful()) {
            List<Atleta> JugadorList = response2.body();
            System.out.println(System.lineSeparator()+  JugadorList);
        }else{
            System.out.println("ERROR " + response2.code() +  ": " + response2.errorBody());
        }

        // 2. Devolver todos los atletas que hayan nacido en una fecha anterior a una fecha determinada.
        System.out.println("Mostrando los atletas nacidos antes del 01-01-1990: ");
        Response<List<Atleta>> response3 = atletaService.atletasBeforeFecha("01-01-1990").execute();
        if(response3.isSuccessful()) {
            List<Atleta> JugadorList = response3.body();
            System.out.println(System.lineSeparator()+ JugadorList);
        }else{
            System.out.println("ERROR " + response3.code() +  ": " + response3.errorBody());
        }

        // 3. Retornar todos los atletas agrupados por nacionalidad mediante un Map<String, List <Atleta>>;
        System.out.println("Mostrando atletas agrupados por nacionalidad: ");
        Response<Map<String, List<Atleta>>> response4 = atletaService.groupByNacionalidad().execute();
        if (response4.isSuccessful()){
            Map<String, List<Atleta>> atletasList = response4.body();
            System.out.println(System.lineSeparator() + atletasList);
        }else{
            System.out.println("ERROR " + response4.code() +  ": " + response4.errorBody());
        }

        // 4. Retornar todos los atletas agrupados por tipo de medalla mediante un Map<TipoMedalla, List<Atleta>>;
        System.out.println("Mostrando atletas agrupados por medallas: ");
        Call<Map<TipoMedalla, List<Atleta>>> call5 = atletaService.groupByTipoMedalla();
        Response<Map<TipoMedalla, List<Atleta>>> response5= call5.execute();
        if (response5.isSuccessful()){
            Map<TipoMedalla, List<Atleta>> atletasList = response5.body();
            System.out.println(System.lineSeparator() + atletasList);
        }else{
            System.out.println("ERROR " + response5.code() +  ": " + response5.errorBody());
        }
    }
}
