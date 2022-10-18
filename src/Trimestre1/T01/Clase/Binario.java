package Trimestre1.T01.Clase;

import java.io.*;

//Del 5 al 11
public class Binario {
    public static void main(String[] args) throws IOException
    {
        File fichero = new File("src/Trimestre1/T01/Ejercicios/Departamentos.dat");
        FileOutputStream fos = new FileOutputStream(fichero);
        DataOutputStream dos = new DataOutputStream(fos);
        int ids [] = {1,2,3};
        String nombres[] = {"Prueba1", "Prueba2", "Prueba3"};
        int salarios[] = {300,200,500};

        for (int i = 0; i < salarios.length; i++)
        {
            dos.writeInt(ids[i]);
            dos.writeUTF(nombres[i]);
            dos.writeInt(salarios[i]);
        }
        dos.close();
    }
}
