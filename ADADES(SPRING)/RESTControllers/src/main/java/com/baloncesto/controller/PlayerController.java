package com.baloncesto.controller;

import com.baloncesto.domain.Player;
import com.baloncesto.repository.PlayerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.groupingBy;

@RestController
@RequestMapping("/players")
public class PlayerController {
    @Autowired
    private PlayerRepository playerRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Player createPlayer(@RequestBody Player player) {
        return playerRepository.save(player);
    }

    @PutMapping
    public Player updatePlayer(@RequestBody Player player) {
        return playerRepository.save(player);
    }

    @GetMapping
    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Player findById(@PathVariable Long id) {
        Player player = playerRepository.findOne(id);
        return player;
    }


    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable Long id) {
        playerRepository.delete(id);
    }

    // 1. Devolver todos los jugadores ordenados por número de canastas.
    @GetMapping("/orderBynCanastas")
    public List<Player> findAllByOrderBynCanastas() {
        return playerRepository.findAllByOrderBynCanastas();
    }

    // 2. Devolver todos los jugadores que han conseguido un número de canastas igual o superior a un parámetro especificado en la URL.
    @GetMapping("/nCanastasGreaterOrEqual/{nCanastas}")
    public List<Player> findBynCanastasGreaterThan(@PathVariable Integer num) {
        return playerRepository.findBynCanastasGreaterThan(num);
    }

    // 3. Devolver todos los jugadores que han conseguido un número de canastas en un rango determinado (mínimo y máximo).
    @GetMapping("/nCanastasBetween/{min}/{max}")
    public List<Player> findBynCanastasBetween(@PathVariable Integer min, Integer max) {
        return playerRepository.findBynCanastasBetween(min, max);
    }

    // 4. Devolver los jugadores agrupados por posición mediante un Map.
    @GetMapping("/posicion")
    public Map<Posicion, Collection<Player>> findByPosicion() {

//
//       ArrayList<Jugador> jugadores = new ArrayList<>();
//
//       Map<String,List<Jugador>> posicionJugador = new HashMap<>();
//
//       posicionJugadores.
//       forEach(posicionJugadore -> {
//           posicionJugador.put(posicionJugadores.get(0),(List<Jugador>) posicionJugadores.get(1));
//       });
//        return posicionJugador;

        List<Jugador> posicionJugadores = jugadorRepository.findAll();

        ListMultimap<Posicion, Jugador> posiciones = ArrayListMultimap.create();

        for (Jugador p : posicionJugadores) {
            posiciones.put(p.getPosicion(), p);
        }
        posicionJugadores.forEach(jugador ->
                posiciones.put(jugador.getPosicion(), jugador));

        System.out.println();

        return posiciones.asMap();
    }
    @GetMapping("/GroupByPosition")
    public Map<Posicion, List<Jugador>> getJugadoresGroupByPosicion() {
        return playerRepository.findAll().parallelStream().collect(groupingBy(Player::getPosicion));
    }

}
