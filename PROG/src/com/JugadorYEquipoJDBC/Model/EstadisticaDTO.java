package com.JugadorYEquipoJDBC.Model;

public class EstadisticaDTO {
    private String position;
    private int avg1;
    private int max1;
    private int min1;
    private int avg2;
    private int max2;
    private int min2;
    private int avg3;
    private int max3;
    private int min3;

    public EstadisticaDTO() {
    }
    public EstadisticaDTO(String position, int avg1, int max1, int min1, int avg2, int max2, int min2, int avg3, int max3, int min3) {
        this.position = position;
        this.avg1 = avg1;
        this.max1 = max1;
        this.min1 = min1;
        this.avg2 = avg2;
        this.max2 = max2;
        this.min2 = min2;
        this.avg3 = avg3;
        this.max3 = max3;
        this.min3 = min3;
    }

    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }

    public int getAvg1() {
        return avg1;
    }
    public void setAvg1(int avg1) {
        this.avg1 = avg1;
    }

    public int getMax1() {
        return max1;
    }
    public void setMax1(int max1) {
        this.max1 = max1;
    }

    public int getMin1() {
        return min1;
    }
    public void setMin1(int min1) {
        this.min1 = min1;
    }

    public int getAvg2() {
        return avg2;
    }
    public void setAvg2(int avg2) {
        this.avg2 = avg2;
    }

    public int getMax2() {
        return max2;
    }
    public void setMax2(int max2) {
        this.max2 = max2;
    }

    public int getMin2() {
        return min2;
    }
    public void setMin2(int min2) {
        this.min2 = min2;
    }

    public int getAvg3() {
        return avg3;
    }
    public void setAvg3(int avg3) {
        this.avg3 = avg3;
    }

    public int getMax3() {
        return max3;
    }
    public void setMax3(int max3) {
        this.max3 = max3;
    }

    public int getMin3() {
        return min3;
    }
    public void setMin3(int min3) {
        this.min3 = min3;
    }

    @Override
    public String toString() {
        return position + "\n" +
                "Media canastas: " + avg1 + "\n" +
                "Máximo canastas: " + max1 + "\n" +
                "Mínimo canastas: " + min1 + "\n" +
                "Media asistencias: " + avg2 + "\n" +
                "Máximo asistencias: " + max2 + "\n" +
                "Mínimo asistencias: " + min2 + "\n" +
                "Media rebotes: " + avg3 + "\n" +
                "Máximo rebotes: " + max3 + "\n" +
                "Mínimo rebotes: " + min3 + "\n";
    }
}
