import java.util.ArrayList;
import java.util.List;

public class Persona {
    String nombre;
    String apellido;
    int edad;
    String documento;
    List<Perro> perrosAdoptados = new ArrayList<>();

    public Persona(String nombre, String apellido, int edad, String documento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.documento = documento;
    }

    public boolean adoptar(Perro perro) {
        if (perrosAdoptados.size() < 3) {
            perrosAdoptados.add(perro);
            return true;
        }
        return false;
    }

    public Perro perroMasGrande() {
        if (perrosAdoptados.isEmpty()) return null;
        Perro mayor = perrosAdoptados.get(0);
        for (Perro p : perrosAdoptados) {
            if (p.getEdad() > mayor.getEdad()) mayor = p;
        }
        return mayor;
    }

    public String getDocumento() {
        return documento;
    }

    @Override
    public String toString() {
        String texto = nombre + " " + apellido + " (" + documento + ") - Edad: " + edad;
        if (perrosAdoptados.isEmpty()) return texto + "\n  Sin perros adoptados.";
        for (Perro p : perrosAdoptados) texto += "\n  - " + p;
        return texto;
    }
}
