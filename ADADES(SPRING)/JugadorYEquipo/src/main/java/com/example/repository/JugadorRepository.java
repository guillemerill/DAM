    package com.example.repository;

    import com.example.domain.Jugador;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.data.jpa.repository.Query;
    import org.springframework.data.repository.query.Param;

    import java.util.List;

    public interface JugadorRepository extends JpaRepository<Jugador, Long> {
        //Spring Data Queries
        // a. Buscar jugadores por nombre, de manera que no sea necesario introducir el nombre completo.
        List<Jugador> findBynombreContaining(String nombre);

        // b. Buscar jugadores que hayan conseguido un número mayor o igual a un número de canastas especificado como parámetro.
        List<Jugador> findBynCanastasGreaterThanEqual(int nCanastas);

        // c. Buscar jugadores que hayan efectuado un número de asistencias dentro de un rango especificado como parámetro.
        List<Jugador> findBynAsistenciasBetween(int nAsmin, int nAsmax);

        // d. Buscar jugadores que pertenezcan a una posición específica, por ejemplo: base
        List<Jugador> findByposicionIgnoreCase(String posicion);

        // e. Buscar jugadores que hayan nacido en una fecha anterior a una fecha especificada como parámetro.
        List<Jugador> findBynacimBefore(String nacim);


        //JPQL Queries
        // f. Agrupar los jugadores por la posición del campo y devolver para cada grupo la siguiente información: la media de canastas, asistencias y rebotes.
        @Query("SELECT jug.posicion, AVG(jug.nCanastas), AVG(jug.nAsistencias), AVG(jug.nRebotes) " +
                "FROM Jugador jug " +
                "GROUP BY jug.posicion ")
        List<Object[]> AvgnCanastasAndnAsistenciasAndnRebotesPerposicion();

        //  g. Lo mismo que el punto anterior pero devolviendo la media, el máximo y el mínimo de canastas, asistencias y rebotes.
        @Query("SELECT jug.posicion, AVG(jug.nCanastas), MAX(jug.nCanastas), MIN(jug.nCanastas), AVG(jug.nAsistencias), MAX(jug.nAsistencias), MIN(jug.nAsistencias), AVG(jug.nRebotes), MAX(jug.nRebotes), MIN(jug.nRebotes)   " +
                "FROM Jugador jug " +
                "GROUP BY jug.posicion ")
        List<Object[]> AvgAndMaxAndMinnCanastasAndnAsistenciasAndnRebotesPerposicion();

        // b. Devuelve todos los jugadores de un equipo, a partir del nombre completo del equipo.
        List<Jugador> findByEquipoNombre(String nombre);


    }
