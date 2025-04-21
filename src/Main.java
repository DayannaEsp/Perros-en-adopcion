import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Persona> personas = new ArrayList<>();
        List<Perro> perros = new ArrayList<>();
        int opcion, edad;
        String nombre, tamanio, raza, apellido, placa, doc;

        do {
            System.out.println("\n1. Registrar persona");
            System.out.println("2. Registrar perro");
            System.out.println("3. Ver personas");
            System.out.println("4. Ver perros");
            System.out.println("5. Adoptar perro");
            System.out.println("6. Perro más viejo adoptado");
            System.out.println("7. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            if (opcion == 1) {
                System.out.print("Nombre: ");
                nombre = sc.nextLine();
                System.out.print("Apellido: ");
                apellido = sc.nextLine();
                System.out.print("Edad: ");
                edad = sc.nextInt(); sc.nextLine();
                System.out.print("Documento: ");
                doc = sc.nextLine();
                personas.add(new Persona(nombre, apellido, edad, doc));
                System.out.println("Persona registrada.");

            } else if (opcion == 2) {
                System.out.print("Placa: ");
                placa = sc.nextLine();
                System.out.print("Nombre: ");
                nombre = sc.nextLine();
                System.out.print("Raza: ");
                raza = sc.nextLine();
                System.out.print("Edad: ");
                edad = sc.nextInt(); sc.nextLine();
                System.out.print("Tamaño: ");
                tamanio = sc.nextLine();
                perros.add(new Perro(placa, nombre, raza, edad, tamanio));
                System.out.println("Perro registrado.");

            } else if (opcion == 3) {
                for (Persona p : personas) System.out.println(p);

            } else if (opcion == 4) {
                for (Perro p : perros) System.out.println(p);

            } else if (opcion == 5) {
                System.out.print("Documento de la persona: ");
                doc = sc.nextLine();
                Persona persona = null;
                for (Persona p : personas) {
                    if (p.getDocumento().equals(doc)) {
                        persona = p;
                        break;
                    }
                }
                if (persona == null) {
                    System.out.println("Persona no encontrada.");
                    continue;
                }

                System.out.print("Placa del perro: ");
                placa = sc.nextLine();
                Perro perro = null;
                for (Perro p : perros) {
                    if (p.getPlaca().equals(placa)) {
                        perro = p;
                        break;
                    }
                }
                if (perro == null) {
                    System.out.println("Perro no encontrado.");
                    continue;
                }

                if (persona.adoptar(perro)) {
                    perros.remove(perro);
                    System.out.println("Adopción exitosa.");
                } else {
                    System.out.println("Ya adoptó 3 perros.");
                }

            } else if (opcion == 6) {
                System.out.print("Documento de la persona: ");
                doc = sc.nextLine();
                Persona persona = null;
                for (Persona p : personas) {
                    if (p.getDocumento().equals(doc)) {
                        persona = p;
                        break;
                    }
                }
                if (persona == null) {
                    System.out.println("Persona no encontrada.");
                    continue;
                }

                Perro mayor = persona.perroMasGrande();
                if (mayor == null) {
                    System.out.println("No ha adoptado perros.");
                } else {
                    System.out.println("Perro más viejo adoptado: " + mayor);
                }
            }

        } while (opcion != 7);
    }
}