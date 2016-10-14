package com.Taller;

public class MainVehiculos {
    public static void main(String[] args) {
        Coche Jaguar = new Coche("1234ENG", "Jaguar", "TheRoadIsYours", 200000.0);
        Coche BMW = new Coche("9065AME", "BMW", "LoveAtFirstDrive", 60000.0);
        Coche Lexus = new Coche("5638DDD", "Lexus", "FastAndGlorious", 120000.0);
        Coche Austin = new Coche("3564GER", "Austin", "BelikeBond", 150000.0);
        Coche RomeoAlfaJulietta = new Coche("4749JAV", "RomeoAlfaJulietta", "DramaMasterpiece", 12000.0);

        RegistroVehiculos registro = new RegistroVehiculos();
        registro.registrarVehiculo(Jaguar);
        registro.registrarVehiculo(BMW);
        registro.registrarVehiculo(Lexus);
        registro.registrarVehiculo(Austin);
        registro.registrarVehiculo(RomeoAlfaJulietta);
        // Debes comprobar que el HashSet no permite duplicados
        registro.registrarVehiculo(RomeoAlfaJulietta);

        System.out.println(registro.obtenerTodos());

        registro.obtenerVehiculo("4749JAV")
                .ifPresent(
                        coche -> System.out.println("com.Coche con matricula 4749JAV:" + coche)
                );

        registro.obtenerVehiculoMarca("Lexus")
                // esto es un bucle tradicional expresado con Java 8
                .forEach(
                        coche -> System.out.println(coche)
                );

        registro.obtenerVehiculoPrecioMax()
                // esta expresión es equivalente a verificar diferente de null con Java 8
                .ifPresent(
                        coche -> System.out.println("com.Coche Max precio:" + coche)
                );

        System.out.println("Elimninando coche con matricula 1234ENG");
        registro.eliminarVehiculo("1234ENG");

        System.out.println(registro.obtenerTodos());

    }
}
