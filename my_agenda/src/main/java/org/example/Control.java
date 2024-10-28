package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Control {
    Agenda agenda;
    ArrayList<Contacto> listaContacto;
    Contacto contacto;

    int id;

    private Vista vista;
    JTable tableContacto;


    public Control(){
        agenda = new Agenda("Agenda.txt");
        listaContacto = agenda.leerArchivo();
        this.id = listaContacto.get(listaContacto.size()-1).getId();
        awakeWindow();
    }

    public void awakeWindow(){
        vista = new Vista("Agenda");
        vista.addActionListener(new ClientActionHandler());
        cargarTabla(listaContacto);
    }

    public void cargarTabla(ArrayList<Contacto> list){
        tableContacto = new JTable();
        tableContacto.setModel(new TableModelContacto(list));
        JScrollPane scrollPane = new JScrollPane(tableContacto);
        vista.addTable(scrollPane);
    }

    public void cargarLista(){
        listaContacto = agenda.leerArchivo();
    }

    private class ClientActionHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            String option = event.getActionCommand();
            switch (option){
                case "0":
                    // Guardar Contacto
                    // 1. Actualizar Archivo
                    // 2. Leer Archivo
                    // 3. Actualizar Tabla
                    contacto = new Contacto();
                    contacto.setId(++id);
                    contacto.setNombre(vista.getNombre());
                    contacto.setApellido(vista.getApellido());
                    contacto.setTelefono(vista.getTelefono());
                    contacto.setEmail(vista.getEmail());
                    if (agenda.guardarArchivo(contacto)){
                        vista.displayMessage("CONTACTO GUARDADO CORRECTAMENTE");
                        cargarLista();
                        cargarTabla(listaContacto);
                    }else{
                        vista.displayErrorMessage("ERROR AL GUARDAR CONTACTO");
                    }
            }
        }
    }
}