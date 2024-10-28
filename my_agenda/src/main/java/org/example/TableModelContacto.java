package org.example;

import javax.swing.table.AbstractTableModel;
import java.awt.datatransfer.Clipboard;
import java.util.ArrayList;
import java.util.List;

public class TableModelContacto extends AbstractTableModel {
    final private List<Contacto> filas;
    final private String[] columnas = {"Id","Nombre","Apellido","Telefono","Correo"};;
    public TableModelContacto(List<Contacto> filas){
        this.filas = filas;
    }

    @Override
    public int getRowCount() {
        return filas.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Contacto contacto = filas.get(rowIndex);
        switch (columnIndex){
            case 0 : return contacto.getId();
            case 1: return contacto.getNombre();
            case 2: return contacto.getApellido();
            case 3: return contacto.getTelefono();
            case 4: return contacto.getEmail();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int columnIndex){
        return columnas[columnIndex];
    }
}