package com.vjimmes2003.metodos;

import java.util.Random;
import java.util.Scanner;

public class OperacionesNumeros {

    public static boolean esOpcionUnNumero(String opcion) {
        if (opcion.matches("[0-9]{1,2}")) {
            return true;
        } else {
            return false;
        }
    }

    // 1. Mostrar los números. El booleano permite reutilizar el mismo método.
    public static String mostrarTodos(int[] numeros, boolean imprimir) {
        String resultado = "";

        for (int i = 0; i < numeros.length; i++) {
            resultado += String.format("%4d", numeros[i]);
        }

        if (imprimir) {
            System.out.printf("%n%s%n", resultado);
        }

        return resultado;
    }

    // 2. El resultado contiene primero el mínimo y después el máximo.
    public static int[] mostrarMinimoMaximo(int[] numeros) {
        int minimo = numeros[0];
        int maximo = numeros[0];
        int[] resultado = new int[2];

        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] < minimo) {
                minimo = numeros[i];
            }
            if (numeros[i] > maximo) {
                maximo = numeros[i];
            }
        }

        resultado[0] = minimo;
        resultado[1] = maximo;
        return resultado;
    }

    // 3. Calcular la media.
    public static double calcularMedia(int[] numeros) {
        int suma = 0;

        for (int i = 0; i < numeros.length; i++) {
            suma += numeros[i];
        }

        double media = suma / (numeros.length * 1.0);
        return media;
    }

    // 4. Comprobar los números primos mediante divisiones manuales.
    public static String mostrarNumerosPrimos(int[] numeros) {
        int totalPrimos = 0;
        String primos = "";
        String resultado = "";

        for (int i = 0; i < numeros.length; i++) {
            int num = numeros[i];
            boolean esPrimo = num > 1;

            for (int d = 2; d * d <= num; d++) {
                if (num % d == 0) {
                    esPrimo = false;
                    break;
                }
            }

            if (esPrimo) {
                primos += String.format("%4d", num);
                totalPrimos++;
            }
        }

        if (totalPrimos == 0) {
            resultado = String.format("Números: %s%nNo hay ningún número primo.", mostrarTodos(numeros, false));
        } else {
            resultado = String.format("Números: %s%nPrimos: %s", mostrarTodos(numeros, false), primos);
        }

        return resultado;
    }

    // 5. Ordenación de burbuja: copiamos antes para no cambiar los originales.
    public static int[] ordenarMenorMayor(int[] numeros) {
        int[] ordenados = new int[numeros.length];

        for (int i = 0; i < numeros.length; i++) {
            ordenados[i] = numeros[i];
        }

        for (int i = 0; i < ordenados.length - 1; i++) {
            for (int j = 0; j < ordenados.length - 1 - i; j++) {
                if (ordenados[j] > ordenados[j + 1]) {
                    int temporal = ordenados[j];
                    ordenados[j] = ordenados[j + 1];
                    ordenados[j + 1] = temporal;
                }
            }
        }

        return ordenados;
    }

    // 6. Buscar un valor y devolver las posiciones en las que aparece.
    public static String encontrarNumero(int[] numeros, Scanner sc) {
        String entrada = "";
        int buscado = -1;

        do {
            System.out.printf("Introduce el número a buscar, entre 1 y 100:%n");
            entrada = sc.nextLine();

            if (entrada.matches("[0-9]{1,3}")) {
                buscado = Integer.parseInt(entrada);
                if (buscado >= 1 && buscado <= 100) {
                    break;
                } else {
                    System.out.printf("El número está fuera del rango.%n");
                }
            } else {
                System.out.printf("Introduce un número válido de 1 a 100.%n");
            }
        } while (true);

        String posiciones = "";
        boolean encontrado = false;

        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == buscado) {
                posiciones += i + " ";
                encontrado = true;
            }
        }

        String resultado = "";
        if (encontrado) {
            resultado = String.format("El número %d aparece en las posiciones (desde 0): %s", buscado, posiciones);
        } else {
            resultado = String.format("El número %d no aparece entre los generados.", buscado);
        }

        return resultado;
    }

    // 7. Generar diez números aleatorios.
    public static int[] generarAleatorios(Random random) {
        int[] aleatorios = new int[10];

        for (int i = 0; i < aleatorios.length; i++) {
            aleatorios[i] = random.nextInt(1, 101);
        }

        mostrarTodos(aleatorios, true);
        return aleatorios;
    }

    // 8. Buscar todos los números que comparten la frecuencia máxima.
    public static String buscarMasAparecido(int[] numeros) {
        int vecesMasRepetido = 0;

        for (int i = 0; i < numeros.length; i++) {
            int veces = 0;

            for (int j = 0; j < numeros.length; j++) {
                if (numeros[i] == numeros[j]) {
                    veces++;
                }
            }

            if (veces > vecesMasRepetido) {
                vecesMasRepetido = veces;
            }
        }

        if (vecesMasRepetido == 1) {
            return "Todos los números aparecen una sola vez.";
        }

        String numerosMasRepetidos = "";

        for (int i = 0; i < numeros.length; i++) {
            int veces = 0;
            boolean yaMostrado = false;

            for (int j = 0; j < numeros.length; j++) {
                if (numeros[i] == numeros[j]) {
                    veces++;
                }
            }

            // Si ya apareció antes, no lo añadimos dos veces.
            for (int j = 0; j < i; j++) {
                if (numeros[i] == numeros[j]) {
                    yaMostrado = true;
                }
            }

            if (veces == vecesMasRepetido && !yaMostrado) {
                if (!numerosMasRepetidos.isEmpty()) {
                    numerosMasRepetidos += ", ";
                }

                numerosMasRepetidos += numeros[i];
            }
        }

        return String.format("Número(s) más repetido(s): %s. Apariciones: %d.",
                numerosMasRepetidos, vecesMasRepetido);
    }
}
