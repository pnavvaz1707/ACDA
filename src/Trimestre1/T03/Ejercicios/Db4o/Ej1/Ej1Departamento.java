package Trimestre1.T03.Ejercicios.Db4o.Ej1;

public class Ej1Departamento {
    private int num;
    private String nombre;

    public Ej1Departamento(int num, String nombre) {
        this.num = num;
        this.nombre = nombre;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
