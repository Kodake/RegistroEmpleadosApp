import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class RegistroEmpleadosApp {

    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        List<Persona> personas = new ArrayList<>();

        var salir = false;

        while (!salir) {
            mostrarMenu();
            try {
                salir = ejecutarOperacion(consola, personas);

            } catch (Exception ex) {
                System.out.println("Ocurrió un error: " + ex.getMessage());
            }
            System.out.println();
        }
    }

    private static void mostrarMenu() {
        System.out.println("""
                ***** Listado de Personas
                1. Agregar
                2. Listar
                3. Salir
                """);
        System.out.print("Opción proporcionada: ");
    }

    public static boolean ejecutarOperacion(Scanner consola, List<Persona> personas) {
        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;
        switch (opcion) {
            case 1 -> {
                var nombre = pedirNombre(consola);
                if (nombre == null) {
                    break;
                }

                var cedula = pedirCedula(consola);
                if (cedula == null) {
                    break;
                }

                var telefono = pedirTelefono(consola);
                if (telefono == null) {
                    break;
                }

                var persona = new Persona(nombre, telefono, cedula);
                personas.add(persona);
                System.out.println("La lista tiene: " + personas.size() + " personas");
            }
            case 2 -> {
                System.out.println("Listado de Personas: ");
                personas.forEach(System.out::println);
            }
            case 3 -> {
                System.out.println("Hasta pronto...");
                salir = true;
            }
            default -> System.out.println("Opción errónea: " + opcion);
        }
        return salir;
    }

    public static String pedirNombre(Scanner consola) {
        while (true) {
            System.out.print("Proporciona el Nombre: ");
            var nombre = consola.nextLine();
            if (validarNombre(nombre)) {
                return nombre;
            }
            System.out.println("Nombre inválido. No puede tener espacios en blanco.");
        }
    }

    public static String pedirCedula(Scanner consola) {
        while (true) {
            System.out.print("Proporciona la Cédula: ");
            var cedula = consola.nextLine();
            if (validarCedula(cedula)) {
                return cedula;
            }
            System.out.println("Cédula inválida. Debe tener 11 dígitos numéricos.");
        }
    }

    public static String pedirTelefono(Scanner consola) {
        while (true) {
            System.out.print("Proporciona el Teléfono: ");
            var telefono = consola.nextLine();
            if (validarTelefono(telefono)) {
                return telefono;
            }
            System.out.println("Teléfono inválido. Debe tener 10 dígitos numéricos.");
        }
    }

    public static boolean validarNombre(String nombre) {
        String nombrePattern = "\\S+";
        return nombre.matches(nombrePattern);
    }

    public static boolean validarCedula(String cedula) {
        String cedulaPattern = "\\d{11}";
        return cedula.matches(cedulaPattern);
    }

    public static boolean validarTelefono(String telefono) {
        String telefonoPattern = "\\d{10}";
        return telefono.matches(telefonoPattern);
    }

    static class Persona {
        private String nombre;
        private String telefono;
        private String cedula;

        public Persona(String nombre, String telefono, String cedula) {
            this.nombre = nombre;
            this.telefono = telefono;
            this.cedula = cedula;
        }

        @Override
        public String toString() {
            return "Persona{" +
                    "nombre='" + nombre + '\'' +
                    ", telefono='" + telefono + '\'' +
                    ", cedula='" + cedula + '\'' +
                    '}';
        }
    }
}
