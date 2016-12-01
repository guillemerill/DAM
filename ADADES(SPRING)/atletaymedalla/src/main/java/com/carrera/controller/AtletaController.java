package com.carrera.controller;

import com.carrera.domain.Atleta;
import com.carrera.domain.Medalla;
import com.carrera.domain.TipoMedalla;
import com.carrera.repository.AtletaRepository;
import com.carrera.repository.MedallaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;

@RestController
@RequestMapping("/atleta")
public class AtletaController {
    @Autowired
    private AtletaRepository atletaRepository;
    @Autowired
    private MedallaRepository medallaRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Atleta createAtleta(@RequestBody Atleta atleta) {
        return atletaRepository.save(atleta);
    }

    @PutMapping
    public Atleta updatePlayer(@RequestBody Atleta atleta) {
        return atletaRepository.save(atleta);
    }

    @GetMapping
    public List<Atleta> findAllAtletas() {
        return atletaRepository.findAll();
    }

    @GetMapping
    public List<Medalla> findAllMedallas() {
        return medallaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Atleta findById(@PathVariable Long id) {
        Atleta atleta = atletaRepository.findOne(id);
        return atleta;
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable Long id) {
        atletaRepository.delete(id);
    }


    // 1. Retornar todos los atletas agrupados por nacionalidad mediante un Map<String, List <Atleta>>;
    @GetMapping("/atletasByNacionalidad")
    public Map<String, List<Atleta>> groupByNacionalidad(){
        List<String> nacionalidades = atletaRepository.getAllNacionalidades();
        List<Atleta> atletas = findAllAtletas();
        List<Atleta> atletasPorNacionalidad = new ArrayList<>();
        Map<String, List<Atleta>> atletasNacionalidad = new HashMap<>();

        for(String nac : nacionalidades){
            atletasPorNacionalidad.clear();
            for (Atleta a : atletas) {
                if (nac.equals(a.getNacionalidad())) {
                    atletasPorNacionalidad.add(a);
                }
            }
            atletasNacionalidad.put(nac, atletasPorNacionalidad);
        }

        return atletasNacionalidad;
    }

    // 2. Retornar todos los atletas agrupados por tipo de medalla mediante un Map<TipoMedalla, List<Atleta>>;
    @GetMapping("/atletasByTipoMedalla")
    public Map<TipoMedalla, List<Atleta>> groupByTipoMedalla(){
        List<TipoMedalla> tipomedallas = medallaRepository.getAllTipoMedallas();
        List<Medalla> medallas = findAllMedallas();
        List<Atleta> atletasPorTipoMedalla = new ArrayList<>();
        Map<TipoMedalla, List<Atleta>> atletasTipoMedalla = new HashMap<>();

        for(TipoMedalla tmed : tipomedallas){
            atletasPorTipoMedalla.clear();
            for (Medalla m : medallas) {
                if (tmed.equals(m.getTipoMedalla())) {
                    atletasPorTipoMedalla.add(m.getAtleta());
                }
            }
            atletasTipoMedalla.put(tmed, atletasPorTipoMedalla);
        }

        return atletasTipoMedalla;
    }

}
