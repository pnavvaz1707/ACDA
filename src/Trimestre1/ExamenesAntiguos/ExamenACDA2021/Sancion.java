package Trimestre1.ExamenesAntiguos.ExamenACDA2021;

public class Sancion {
    String nombreLibro;
    String nombreUsuario;
    String apellidoUsuario;
    int numDiasRetraso;

    public Sancion(String nombreLibro, String nombreUsuario, String apellidoUsuario, int numDiasRetraso) {
        this.nombreLibro = nombreLibro;
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.numDiasRetraso = numDiasRetraso;
    }
}
