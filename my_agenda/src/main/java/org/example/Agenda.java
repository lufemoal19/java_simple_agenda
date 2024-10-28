package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Agenda {
    private String nombreArchivo;

    public Agenda(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public boolean guardarArchivo(Contacto contacto){
        if (contacto != null){
            try{
                BufferedWriter escribir = new BufferedWriter(new FileWriter(getNombreArchivo(), true));
                escribir.write(contacto.toString());
                escribir.close();
                return true;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }

    public ArrayList<Contacto> leerArchivo(){
        ArrayList<Contacto> listaContactos = new ArrayList<>();
        String text = "";
        String[] contactoStr;
        Contacto contacto;
        try {
            File archivo = new File(getNombreArchivo());
            Scanner leer = new Scanner(archivo);
            while (leer.hasNextLine()){
                text = leer.nextLine();
                contactoStr = text.split(",");
                if (contactoStr.length == 5) {
                    contacto = new Contacto(Integer.parseInt(contactoStr[0]), contactoStr[1], contactoStr[2], contactoStr[3], contactoStr[4]);
                    listaContactos.add(contacto);
                }
            }
        } catch (IOException e){
            throw new RuntimeException(e);
        }
        return listaContactos;
    }
}