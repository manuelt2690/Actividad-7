
import java.util.Scanner;

class CalculadoraGeometrica {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        mostrarMenuFiguras();
        int figura = obtenerOpcion(input, 1, 5);

        mostrarMenuOperaciones();
        int operacion = obtenerOpcion(input, 1, 3);

        procesarOperacion(input, figura, operacion);

        input.close();
    }

    // Métodos para mostrar menús
    public static void mostrarMenuFiguras() {
        System.out.println("CALCULADORA GEOMÉTRICA");
        System.out.println("Figuras disponibles:");
        System.out.println("1. Círculo");
        System.out.println("2. Cuadrado");
        System.out.println("3. Triángulo");
        System.out.println("4. Rectángulo");
        System.out.println("5. Pentágono");
        System.out.print("Elija una figura (1-5): ");
    }

    public static void mostrarMenuOperaciones() {
        System.out.println("\nOperaciones:");
        System.out.println("1. Calcular área");
        System.out.println("2. Calcular perímetro");
        System.out.println("3. Calcular potencia");
        System.out.print("Elija operación (1-3): ");
    }

    // Método para validar opciones
    public static int obtenerOpcion(Scanner input, int min, int max) {
        int opcion;
        while (true) {
            try {
                opcion = input.nextInt();
                if (opcion >= min && opcion <= max) {
                    return opcion;
                } else {
                    System.out.printf("Opción no válida. Debe ser entre %d y %d: ", min, max);
                }
            } catch (Exception e) {
                System.out.print("Entrada inválida. Ingrese un número: ");
                input.next(); // Limpiar el buffer
            }
        }
    }

    // Método principal para procesar operaciones
    public static void procesarOperacion(Scanner input, int figura, int operacion) {
        double resultado = 0;
        String nombreFigura = "";
        String tipoCalculo = "";

        switch (figura) {
            case 1: // Círculo
                nombreFigura = "círculo";
                resultado = procesarCirculo(input, operacion);
                break;
            case 2: // Cuadrado
                nombreFigura = "cuadrado";
                resultado = procesarCuadrado(input, operacion);
                break;
            case 3: // Triángulo
                nombreFigura = "triángulo";
                resultado = procesarTriangulo(input, operacion);
                break;
            case 4: // Rectángulo
                nombreFigura = "rectángulo";
                resultado = procesarRectangulo(input, operacion);
                break;
            case 5: // Pentágono
                nombreFigura = "pentágono";
                resultado = procesarPentagono(input, operacion);
                break;
        }

        // Determinar el tipo de cálculo para el mensaje final
        switch (operacion) {
            case 1: tipoCalculo = "Área"; break;
            case 2: tipoCalculo = "Perímetro"; break;
            case 3: tipoCalculo = "Potencia"; break;
        }

        if (resultado != Double.MIN_VALUE) {
            System.out.printf("%s del %s: %.2f%n", tipoCalculo, nombreFigura, resultado);
        }
    }

    // Métodos para procesar cada figura
    public static double procesarCirculo(Scanner input, int operacion) {
        System.out.print("Ingrese el radio: ");
        double radio = input.nextDouble();
        if (radio <= 0) {
            System.out.println("El radio debe ser positivo.");
            return Double.MIN_VALUE;
        }

        switch (operacion) {
            case 1: return Math.PI * radio * radio;
            case 2: return 2 * Math.PI * radio;
            case 3:
                System.out.print("Ingrese el exponente: ");
                int exponente = input.nextInt();
                return calcularPotencia(radio, exponente);
            default: return Double.MIN_VALUE;
        }
    }

    public static double procesarCuadrado(Scanner input, int operacion) {
        System.out.print("Ingrese el lado: ");
        double lado = input.nextDouble();
        if (lado <= 0) {
            System.out.println("El lado debe ser positivo.");
            return Double.MIN_VALUE;
        }

        switch (operacion) {
            case 1: return lado * lado;
            case 2: return 4 * lado;
            case 3:
                System.out.print("Ingrese el exponente: ");
                int exponente = input.nextInt();
                return calcularPotencia(lado, exponente);
            default: return Double.MIN_VALUE;
        }
    }

    public static double procesarTriangulo(Scanner input, int operacion) {
        switch (operacion) {
            case 1:
                System.out.print("Ingrese la base: ");
                double base = input.nextDouble();
                System.out.print("Ingrese la altura: ");
                double altura = input.nextDouble();
                if (base <= 0 || altura <= 0) {
                    System.out.println("Base y altura deben ser positivas.");
                    return Double.MIN_VALUE;
                }
                return (base * altura) / 2;
            case 2:
                System.out.print("Ingrese los 3 lados (separados por espacio): ");
                double l1 = input.nextDouble();
                double l2 = input.nextDouble();
                double l3 = input.nextDouble();
                if (l1 <= 0 || l2 <= 0 || l3 <= 0) {
                    System.out.println("Todos los lados deben ser positivos.");
                    return Double.MIN_VALUE;
                }
                return l1 + l2 + l3;
            case 3:
                System.out.print("Ingrese un lado para calcular la potencia: ");
                double lado = input.nextDouble();
                System.out.print("Ingrese el exponente: ");
                int exponente = input.nextInt();
                return calcularPotencia(lado, exponente);
            default: return Double.MIN_VALUE;
        }
    }

    public static double procesarRectangulo(Scanner input, int operacion) {
        System.out.print("Ingrese la base: ");
        double base = input.nextDouble();
        System.out.print("Ingrese la altura: ");
        double altura = input.nextDouble();
        if (base <= 0 || altura <= 0) {
            System.out.println("Base y altura deben ser positivas.");
            return Double.MIN_VALUE;
        }

        switch (operacion) {
            case 1: return base * altura;
            case 2: return 2 * (base + altura);
            case 3:
                System.out.print("Ingrese el exponente: ");
                int exponente = input.nextInt();
                return calcularPotencia(base, exponente);
            default: return Double.MIN_VALUE;
        }
    }

    public static double procesarPentagono(Scanner input, int operacion) {
        System.out.print("Ingrese el lado: ");
        double lado = input.nextDouble();
        if (lado <= 0) {
            System.out.println("El lado debe ser positivo.");
            return Double.MIN_VALUE;
        }

        switch (operacion) {
            case 1:
                System.out.print("Ingrese la apotema: ");
                double apotema = input.nextDouble();
                if (apotema <= 0) {
                    System.out.println("La apotema debe ser positiva.");
                    return Double.MIN_VALUE;
                }
                return (5 * lado * apotema) / 2;
            case 2: return 5 * lado;
            case 3:
                System.out.print("Ingrese el exponente: ");
                int exponente = input.nextInt();
                return calcularPotencia(lado, exponente);
            default: return Double.MIN_VALUE;
        }
    }

    // Método recursivo para calcular potencia
    public static double calcularPotencia(double base, int exponente) {
        if (exponente == 0) {
            return 1;
        } else if (exponente > 0) {
            return base * calcularPotencia(base, exponente - 1);
        } else {
            return 1 / calcularPotencia(base, -exponente);
        }
    }
}