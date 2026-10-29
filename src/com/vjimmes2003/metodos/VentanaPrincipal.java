package com.vjimmes2003.metodos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class VentanaPrincipal extends JFrame {

    private int[] numeros;
    private Random random;
    private JLabel numerosLabel;
    private JTextArea resultado;
    private JTextField campoBuscar;

    private final Color fondo = new Color(18, 24, 37);
    private final Color panel = new Color(29, 38, 56);
    private final Color texto = new Color(235, 241, 250);
    private final Color acento = new Color(111, 163, 250);

    public VentanaPrincipal() {
        random = new Random();
        numeros = OperacionesNumeros.generarAleatorios(random);

        setTitle("Analizador de números | Hecho con IA");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(760, 540);
        setMinimumSize(new Dimension(690, 500));
        setLocationRelativeTo(null);

        JPanel contenido = new JPanel(new BorderLayout(14, 14));
        contenido.setBackground(fondo);
        contenido.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setContentPane(contenido);

        JPanel cabecera = new JPanel(new BorderLayout(8, 10));
        cabecera.setOpaque(false);

        JLabel titulo = new JLabel("ANALIZADOR DE NÚMEROS");
        titulo.setForeground(texto);
        titulo.setFont(new Font("SansSerif", Font.BOLD, 24));
        cabecera.add(titulo, BorderLayout.NORTH);

        numerosLabel = new JLabel();
        numerosLabel.setForeground(acento);
        numerosLabel.setFont(new Font("Monospaced", Font.BOLD, 17));
        actualizarNumeros();
        cabecera.add(numerosLabel, BorderLayout.CENTER);
        contenido.add(cabecera, BorderLayout.NORTH);

        JPanel opciones = new JPanel(new GridLayout(4, 2, 10, 10));
        opciones.setOpaque(false);

        agregarBoton(opciones, "1. Mostrar números", 1);
        agregarBoton(opciones, "2. Mínimo y máximo", 2);
        agregarBoton(opciones, "3. Calcular media", 3);
        agregarBoton(opciones, "4. Números primos", 4);
        agregarBoton(opciones, "5. Ordenar ascendente", 5);
        agregarBoton(opciones, "6. Buscar número", 6);
        agregarBoton(opciones, "7. Regenerar números", 7);
        agregarBoton(opciones, "8. Más repetido", 8);

        JPanel centro = new JPanel(new BorderLayout(10, 10));
        centro.setOpaque(false);
        centro.add(opciones, BorderLayout.NORTH);

        JPanel busqueda = new JPanel(new BorderLayout(10, 0));
        busqueda.setOpaque(false);
        JLabel etiqueta = new JLabel("Número a buscar (1-100):");
        etiqueta.setForeground(texto);
        busqueda.add(etiqueta, BorderLayout.WEST);
        campoBuscar = new JTextField();
        campoBuscar.setBackground(panel);
        campoBuscar.setForeground(texto);
        campoBuscar.setCaretColor(texto);
        busqueda.add(campoBuscar, BorderLayout.CENTER);

        JButton botonBuscar = new JButton("Buscar");
        botonBuscar.setBackground(acento);
        botonBuscar.setForeground(new Color(18, 24, 37));
        botonBuscar.setFocusPainted(false);
        botonBuscar.addActionListener(evento -> ejecutarOpcion(6));
        busqueda.add(botonBuscar, BorderLayout.EAST);

        // Pulsar Enter dentro del campo equivale a pulsar Buscar.
        campoBuscar.addActionListener(evento -> ejecutarOpcion(6));
        centro.add(busqueda, BorderLayout.CENTER);

        resultado = new JTextArea("Selecciona una operación del menú.");
        resultado.setEditable(false);
        resultado.setLineWrap(true);
        resultado.setWrapStyleWord(true);
        resultado.setFont(new Font("Monospaced", Font.PLAIN, 14));
        resultado.setForeground(texto);
        resultado.setBackground(panel);
        resultado.setMargin(new Insets(12, 12, 12, 12));
        JScrollPane scroll = new JScrollPane(resultado);
        scroll.setBorder(BorderFactory.createLineBorder(new Color(61, 76, 101)));
        centro.add(scroll, BorderLayout.SOUTH);
        scroll.setPreferredSize(new Dimension(600, 145));
        contenido.add(centro, BorderLayout.CENTER);

        JPanel pie = new JPanel(new BorderLayout());
        pie.setOpaque(false);
        JLabel marca = new JLabel("Interfaz gráfica hecha con IA · Métodos del reto de programación");
        marca.setForeground(new Color(171, 182, 201));
        marca.setFont(new Font("SansSerif", Font.PLAIN, 12));
        pie.add(marca, BorderLayout.WEST);
        JButton salir = new JButton("Salir");
        salir.addActionListener(evento -> dispose());
        pie.add(salir, BorderLayout.EAST);
        contenido.add(pie, BorderLayout.SOUTH);
    }

    private void agregarBoton(JPanel contenedor, String nombre, int opcion) {
        JButton boton = new JButton(nombre);
        boton.setBackground(panel);
        boton.setForeground(texto);
        boton.setFocusPainted(false);
        boton.setFont(new Font("SansSerif", Font.PLAIN, 13));
        boton.setBorder(BorderFactory.createLineBorder(new Color(61, 76, 101), 1));
        boton.addActionListener(evento -> ejecutarOpcion(opcion));
        contenedor.add(boton);
    }

    private void actualizarNumeros() {
        numerosLabel.setText("Números: " + OperacionesNumeros.mostrarTodos(numeros, false));
    }

    private void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> {
                resultado.setText("Números actuales: " + OperacionesNumeros.mostrarTodos(numeros, false));
            }
            case 2 -> {
                int[] minimoMaximo = OperacionesNumeros.mostrarMinimoMaximo(numeros);
                resultado.setText(String.format("Mínimo: %d%nMáximo: %d", minimoMaximo[0], minimoMaximo[1]));
            }
            case 3 -> {
                double media = OperacionesNumeros.calcularMedia(numeros);
                resultado.setText(String.format("Media de los diez números: %.2f", media));
            }
            case 4 -> {
                resultado.setText(OperacionesNumeros.mostrarNumerosPrimos(numeros));
            }
            case 5 -> {
                int[] ordenados = OperacionesNumeros.ordenarMenorMayor(numeros);
                resultado.setText("De menor a mayor: " + OperacionesNumeros.mostrarTodos(ordenados, false));
            }
            case 6 -> {
                String entrada = campoBuscar.getText().trim();
                if (!entrada.matches("[0-9]{1,3}")) {
                    resultado.setText("Introduce un número válido entre 1 y 100.");
                } else {
                    int buscado = Integer.parseInt(entrada);
                    if (buscado < 1 || buscado > 100) {
                        resultado.setText("El número debe estar entre 1 y 100.");
                    } else {
                        String posiciones = "";
                        for (int i = 0; i < numeros.length; i++) {
                            if (numeros[i] == buscado) {
                                posiciones += i + " ";
                            }
                        }
                        if (posiciones.isEmpty()) {
                            resultado.setText("El número " + buscado + " no aparece.");
                        } else {
                            resultado.setText("El número " + buscado + " aparece en las posiciones (desde 0): " + posiciones);
                        }
                    }
                }
            }
            case 7 -> {
                numeros = OperacionesNumeros.generarAleatorios(random);
                actualizarNumeros();
                resultado.setText("Se han generado diez números nuevos.");
            }
            case 8 -> {
                resultado.setText(OperacionesNumeros.buscarMasAparecido(numeros));
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaPrincipal ventana = new VentanaPrincipal();
            ventana.setVisible(true);
        });
    }
}
