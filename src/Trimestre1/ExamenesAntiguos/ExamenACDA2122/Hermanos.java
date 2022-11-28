package Trimestre1.ExamenesAntiguos.ExamenACDA2122;

import java.io.Serializable;

public class Hermanos implements Serializable {
    private String dni;
    private String nombre;
    private String apellidos;
    private String direccion;
    private int antiguedad;
    private int hermandad;

    public Hermanos(String dni, String nombre, String apellidos, String direccion, int antiguedad, int hermandad) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.antiguedad = antiguedad;
        this.hermandad = hermandad;
    }
}
