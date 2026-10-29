package com.vjimmes2003.metodos;

import java.util.Random;
import java.util.Scanner;

public class RetoMetodosTres {

    public static void main(String[] args) {
        String menu = """
                1. Mostrar todos los números
                2. Mostrar el mínimo y el máximo
                3. Calcular la media de los números
                4. Mostrar los números primos
                5. Ordenar los números de menor a mayor
                6. Buscar un número introducido por el usuario
                7. Regenerar los 10 números aleatorios
                8. Mostrar el número que más veces aparece
                0. Salir
                """;

        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int[] aleatorios = OperacionesNumeros.generarAleatorios(random);
        int opcionValidada = -1;

        do {
            System.out.printf("%n%s%nIngrese la opción a probar:%n", menu);
            String opcion = sc.nextLine();
            opcionValidada = -1;

            if (OperacionesNumeros.esOpcionUnNumero(opcion)) {
                opcionValidada = Integer.parseInt(opcion);
            } else {
                System.out.printf("%nDebes introducir una opción numérica válida.%n");
            }

            switch (opcionValidada) {
                case 1 -> {
                    System.out.printf("%n======================%n");
                    OperacionesNumeros.mostrarTodos(aleatorios, true);
                    System.out.printf("======================%n");
                }
                case 2 -> {
                    int[] resultado = OperacionesNumeros.mostrarMinimoMaximo(aleatorios);
                    System.out.printf("%nNúmeros: %s%n", OperacionesNumeros.mostrarTodos(aleatorios, false));
                    System.out.printf("Mínimo: %d%n", resultado[0]);
                    System.out.printf("Máximo: %d%n", resultado[1]);
                }
                case 3 -> {
                    double media = OperacionesNumeros.calcularMedia(aleatorios);
                    System.out.printf("%nNúmeros: %s%n", OperacionesNumeros.mostrarTodos(aleatorios, false));
                    System.out.printf("La media es: %.2f%n", media);
                }
                case 4 -> {
                    System.out.printf("%n%s%n", OperacionesNumeros.mostrarNumerosPrimos(aleatorios));
                }
                case 5 -> {
                    int[] ordenados = OperacionesNumeros.ordenarMenorMayor(aleatorios);
                    System.out.printf("%nOriginales: %s%n", OperacionesNumeros.mostrarTodos(aleatorios, false));
                    System.out.printf("Ordenados: %s%n", OperacionesNumeros.mostrarTodos(ordenados, false));
                }
                case 6 -> {
                    System.out.printf("%n%s%n", OperacionesNumeros.encontrarNumero(aleatorios, sc));
                }
                case 7 -> {
                    aleatorios = OperacionesNumeros.generarAleatorios(random);
                    System.out.printf("%nNúmeros regenerados correctamente.%n");
                }
                case 8 -> {
                    String resultado = OperacionesNumeros.buscarMasAparecido(aleatorios);
                    System.out.printf("%n%s%n", resultado);
                }
                case 0 -> {
                    System.out.printf("%nSaliendo del programa.%n");
                }
                default -> {
                    if (opcionValidada != -1) {
                        System.out.printf("%nLa opción elegida no existe en el menú.%n");
                    }
                }
            }
        } while (opcionValidada != 0);

        sc.close();
    }
}
