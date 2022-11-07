package Trimestre1.T03.Ejercicios.Neodatis.Ej2.Clases;

public class Ej2Pais {
    private int id;
    private String nombrepais;

    public Ej2Pais(int id, String nombrepais) {
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
