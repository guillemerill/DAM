package com.JugadorYEquipoJDBC.Model;

public class RankingDTO {
    private int ranking;
    private String name;
    private int nbaskets;

    public RankingDTO() {
    }
    public RankingDTO(int ranking, String name, int nbaskets) {
        this.ranking = ranking;
        this.name = name;
        this.nbaskets = nbaskets;
    }

    public int getRanking() {
        return ranking;
    }
    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getNbaskets() {
        return nbaskets;
    }
    public void setNbaskets(int nbaskets) {
        this.nbaskets = nbaskets;
    }

    @Override
    public String toString() {
        return ranking + " " + name + " " + nbaskets + "\n";
    }
}
