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


@RestController
@RequestMapping("/atleta")
public class AtletaController {
    @Autowired
    private AtletaRepository atletaRepository;

    @Autowired
    private MedallaRepository medallaRepository;


    @GetMapping
    public List<Atleta> findAllAtletas() {
        return atletaRepository.findAll();
    }


    // 1. Retornar todos los atletas agrupados por nacionalidad mediante un Map<String, List <Atleta>>;
    @GetMapping("/atletasByNacionalidad")
    public Map<String, List<Atleta>> groupByNacionalidad(){
        // return atletaRepository.findAll().parallelStream().collect(Collectors.groupingBy(Atleta::getNacionalidad));
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

        return atletaRepository.findAll().parallelStream().collect(Collectors.groupingBy(Atleta::getNacionalidad));


        List<TipoMedalla> tipomedallas = medallaRepository.getAllTipoMedallas();
        // List<Medalla> medallas = findAllMedallas();
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
