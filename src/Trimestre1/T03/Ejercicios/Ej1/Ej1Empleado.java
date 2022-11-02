package Trimestre1.T03.Ejercicios.Ej1;

public class Ej1Empleado {
    String nombre;
    int numDpto;

    public Ej1Empleado(String nombre, int numDpto) {
        this.nombre = nombre;
        this.numDpto = numDpto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumDpto() {
        return numDpto;
    }

    public void setNumDpto(int numDpto) {
        this.numDpto = numDpto;
    }
}
