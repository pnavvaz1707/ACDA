package Trimestre1.T03.Ejercicios.Neodatis.Ej2.Clases;

import Trimestre1.T03.Ejercicios.Db4o.Ej2.Ej2PaisD;

public class Ej2Jugador {
    private String nombre;
    private String deporte;
    private String ciudad;
    private int edad;

    private Ej2PaisD pais;

    public Ej2Jugador(String nombre, String deporte, String ciudad, int edad, Ej2PaisD pais) {
        this.nombre = nombre;
        this.deporte = deporte;
        this.ciudad = ciudad;
        this.edad = edad;
        this.pais = pais;
    }

    // getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Ej2PaisD getPais() {
        return pais;
    }

    public void setPais(Ej2PaisD pais) {
        this.pais = pais;
    }

}