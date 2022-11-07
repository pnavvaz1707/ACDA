package Trimestre1.T03.Ejercicios.Db4o.Ej2;

public class Ej2PaisD {
    private int id;
    private String nombrepais;

    public Ej2PaisD(int id, String nombrepais) {
        this.id = id;
        this.nombrepais = nombrepais;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombrepais() {
        return nombrepais;
    }

    public void setNombrepais(String nombrepais) {
        this.nombrepais = nombrepais;
    }

    @Override
    public String toString() {
        return nombrepais;
    }
}
