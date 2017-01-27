import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;
import java.util.Map;

public interface AtletaService {
    @GET("/atleta")
    Call<List<Atleta>> getAllAtletas();

    @GET("/nacionalidad/{nacionalidad}")
    Call<List<Atleta>> getAtletasByNacionalidad(@Path("nacionalidad") String nacionalidad);

    @GET("/nacimientoBefore/{fecha}")
    Call<List<Atleta>> atletasBeforeFecha(@Path("fecha")String fecha);

    @GET("/atletasByNacionalidad")
    Call<Map<String, List<Atleta>>> groupByNacionalidad();

    @GET("/atletasByTipoMedalla")
    Call<Map<TipoMedalla, List<Atleta>>> groupByTipoMedalla();
}
