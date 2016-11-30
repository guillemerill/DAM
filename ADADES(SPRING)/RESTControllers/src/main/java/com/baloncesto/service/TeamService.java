package com.baloncesto.service;

import com.baloncesto.domain.Team;
import com.baloncesto.repository.TeamRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public void testTeams(){
        Team team1 = new Team(1,"Cavaliers","Cleveland", LocalDate.of(1970,10,12));
        teamRepository.save(team1);

        Team team2 = new Team(2,"Warriors","Oakland", LocalDate.of(1946,4,25));
        teamRepository.save(team2);

        Team team3 = new Team(3,"Pelicans","New Orleans", LocalDate.of(2013,1,4));
        teamRepository.save(team3);

        Team team4 = new Team(4,"Rockets","Houston", LocalDate.of(1967,10,30));
        teamRepository.save(team4);

        Team team5 = new Team(5,"Tunder","Oklahoma", LocalDate.of(1979,6,7));
        teamRepository.save(team5);

        Team team6 = new Team(6,"Clippers","Los Angeles",LocalDate.of(1970,7,19));
        teamRepository.save(team6);

        Team team7 = new Team(7,"Lakers","Los Angeles",LocalDate.of(1946,8,19));
        teamRepository.save(team7);

        /*System.out.println(teamRepository.findOne(1L));
        System.out.println(teamRepository.findByNameLike("Cavaliers"));*/
        System.out.println("");
        System.out.println("Teams location on Los Angeles");
        System.out.println(teamRepository.findByLocation("Los Angeles"));
    }

}