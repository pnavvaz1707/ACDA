package Trimestre1.ExamenesAntiguos.ExamenACDA2122;

import java.io.Serializable;

public class Hermandades implements Serializable {
    private int codigo;
    private String nombre;
    private String vulgo;
    private String casahermandad;
    private String hermanomayor;
    private int cuotahermano;
    private int fundacion;
    private String diaprocesion;
    private int sedecanonica;
    private String barrio;

    public Hermandades(int codigo, String nombre, String vulgo, String casahermandad, String hermanomayor, int cuotahermano, int fundacion, String diaprocesion, int sedecanonica, String barrio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.vulgo = vulgo;
        this.casahermandad = casahermandad;
        this.hermanomayor = hermanomayor;
        this.cuotahermano = cuotahermano;
        this.fundacion = fundacion;
        this.diaprocesion = diaprocesion;
        this.sedecanonica = sedecanonica;
        this.barrio = barrio;
    }
}
