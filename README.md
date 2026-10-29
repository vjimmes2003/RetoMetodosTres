# RetoMetodosTres — Analizador de Números

![Java](https://img.shields.io/badge/Java-25-orange?logo=openjdk)
![VS Code](https://img.shields.io/badge/IDE-VS_Code-blue?logo=visualstudiocode)
![Swing](https://img.shields.io/badge/GUI-Java_Swing-purple)
![Estado](https://img.shields.io/badge/Estado-Funcional-brightgreen)

Aplicación desarrollada en **Java** que genera diez números aleatorios entre 1 y 100 y permite realizar diferentes operaciones matemáticas sobre ellos.

El proyecto comenzó como un reto de Programación para practicar métodos, bucles, condicionales y arrays, y posteriormente se amplió con una interfaz gráfica utilizando **Java Swing** y ayuda de inteligencia artificial.

## Funcionalidades

El programa incluye las siguientes operaciones:

1. Mostrar los diez números generados.
2. Calcular el mínimo y el máximo.
3. Calcular la media aritmética.
4. Identificar los números primos.
5. Ordenar los números de menor a mayor.
6. Buscar un número e indicar sus posiciones.
7. Regenerar los diez números aleatorios.
8. Encontrar los números que más veces aparecen.

Si varios números comparten la frecuencia máxima, se muestran todos los empatados. Si ninguno se repite, el programa también lo indica.

### Características de la implementación

- Operaciones organizadas mediante métodos propios.
- Uso de bucles `for`, condicionales y estructuras `switch`.
- Ordenación manual sin `Arrays.sort()` ni `Collections`.
- Validación de entradas en el menú de consola.
- Separación entre la lógica del programa y su presentación.
- Dos modos de ejecución: consola e interfaz gráfica.

## Estructura del proyecto

```text
RetoMetodosTres/
├── src/
│   └── com/
│       └── vjimmes2003/
│           └── metodos/
│               ├── RetoMetodosTres.java
│               ├── OperacionesNumeros.java
│               └── VentanaPrincipal.java
├── out/
│   └── classes/
└── dist/
```

### Clases principales

| Clase | Función |
|---|---|
| `RetoMetodosTres.java` | Contiene el menú de consola y el punto de entrada original. |
| `OperacionesNumeros.java` | Contiene los métodos encargados de realizar las operaciones. |
| `VentanaPrincipal.java` | Implementa la interfaz gráfica con Java Swing. |

Todas las clases pertenecen al paquete `com.2003.metodos`.

## Requisitos

- Java JDK 25, utilizado para la compilación del proyecto.
- Visual Studio Code o cualquier editor compatible con Java.
- Terminal para utilizar `javac`, `jar` y `java`.

No se necesitan dependencias externas.

## Compilación y ejecución

Los siguientes comandos deben ejecutarse desde la carpeta raíz del proyecto.

### 1. Compilar el código

```powershell
javac -encoding UTF-8 -d out/classes src/com/vjimmes2003/metodos/*.java
```

El parámetro `-d` indica dónde se guardarán los archivos `.class`, respetando la estructura de paquetes.

### 2. Generar el JAR de consola

```powershell
jar cvfe dist/RetoMetodosTres.jar com.vjimmes2003.metodos.RetoMetodosTres -C out/classes .
```

Ejecutar:

```powershell
java -jar dist/RetoMetodosTres.jar
```

### 3. Generar el JAR gráfico

```powershell
jar cvfe dist/AnalizadorVisual.jar com.vjimmes2003.metodos.VentanaPrincipal -C out/classes .
```

Ejecutar:

```powershell
java -jar dist/AnalizadorVisual.jar
```

Ambos JAR utilizan las mismas clases compiladas, pero tienen distintos puntos de entrada.

## Interfaz gráfica

Como ampliación del proyecto original se desarrolló una interfaz gráfica utilizando **Java Swing**, con un diseño oscuro.

Esta versión permite realizar las operaciones mediante botones, visualizar los números generados y consultar los resultados sin utilizar el menú de consola.

El campo de búsqueda permite introducir un número y ejecutar la operación pulsando Enter o el botón correspondiente.

La interfaz incluye una marca visible que indica su desarrollo con ayuda de IA.

## Uso de inteligencia artificial

El programa original fue desarrollado como ejercicio de Programación, utilizando los conocimientos adquiridos sobre métodos, bucles, condicionales y arrays.

Posteriormente se utilizó inteligencia artificial como herramienta de apoyo para:

- Adaptar el proyecto a una estructura con paquetes y clases.
- Revisar errores y casos especiales de algunos métodos.
- Desarrollar la interfaz gráfica en Java Swing.
- Mejorar la presentación de los resultados.

La interfaz gráfica se considera una ampliación del proyecto original y reutiliza sus operaciones matemáticas.

## Contexto académico

Proyecto realizado durante el curso **2026/2027**, en el primer curso de Desarrollo de Aplicaciones Multiplataforma (DAM).

También se ha utilizado para practicar la compilación y generación de archivos JAR desde la terminal en la asignatura de Entornos de Desarrollo.

## Autor

**Víctor Hugo Jiménez Meseguer**

GitHub: [@vjimmes2003](https://github.com/vjimmes2003)

Proyecto académico desarrollado en Java con una ampliación gráfica asistida por inteligencia artificial.