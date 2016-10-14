package com.PruebaNivel;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            List<Disco> discos = new ArrayList<>();

            int opc;
            boolean salir = false;
            do {
                System.out.println("Menu");
                System.out.println("1. Añadir disco a colección");
                System.out.println("2. Modificar disco");
                System.out.println("3. Eliminar disco");
                System.out.println("4. Mostrar disco");
                System.out.println("5. Salir");

                opc = Integer.parseInt(br.readLine());

                switch (opc) {
                    case 1:
                        nuevoDisco(discos);

                        break;
                    case 2:
                        System.out.println("Qué disco deseas modificar?");
                        showDiscos(discos);
                        int ver = Integer.parseInt(br.readLine());
                        if (ver > 0) {
                            ver(discos, ver - 1);
                            discos.remove(ver - 1);
                            nuevoDisco(discos);
                        }

                        break;
                    case 3:
                        System.out.println("Qué disco deseas eliminar?");
                        showDiscos(discos);

                        int eliminar = Integer.parseInt(br.readLine());
                        if (eliminar > 0) {
                            discos.remove(eliminar - 1);
                        }
                        break;
                    case 4:
                        System.out.println("Qué disco deseas ver?");
                        showDiscos(discos);
                        ver = Integer.parseInt(br.readLine());
                        if (ver > 0) {
                            ver(discos, ver - 1);
                        }
                        break;
                    case 5:
                        salir = true;
                        break;
                    default:
                        break;
                }
            } while (!salir);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void showDiscos(List<Disco> discos) {
        for (int i = 0; i < discos.size(); i++) {
            System.out.println((i+1) + ". " + discos.get(i).getTitulo());
        }
        System.out.println("0. Salir");
    }

    private static void nuevoDisco(List<Disco> discos) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Titulo del disco:");
            String nombre = br.readLine();
            System.out.println("Grupo:");
            String grupo = br.readLine();
            System.out.println("Número de temas");
            int ntemas = Integer.parseInt(br.readLine());
            System.out.println("Duración");
            Double duracion = Double.parseDouble(br.readLine());

            Disco disco = new Disco(nombre, grupo, ntemas, duracion);
            discos.add(disco);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void ver(List<Disco> discos, int ver) {
        System.out.println("Titulo: " + discos.get(ver).getTitulo());
        System.out.println("Grupo: " + discos.get(ver).getGrupo());
        System.out.println("Número de temas: " + discos.get(ver).getNtemas());
        System.out.println("Duracion: " + discos.get(ver).getDuracion());
    }
}
