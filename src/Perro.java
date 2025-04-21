public class Perro {
    private String placa;
    private String nombre;
    private String raza;
    private int edad;
    private String tamanio;

    public Perro(String placa, String nombre, String raza, int edad, String tamanio) {
        this.placa = placa;
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.tamanio = tamanio;
    }

    public String getPlaca() { return placa; }
    public int getEdad() { return edad; }

    @Override
    public String toString() {
        return "Placa: " + placa + ", Nombre: " + nombre + ", Raza: " + raza + ", Edad: " + edad + ", Tamaño: " + tamanio;
    }
}