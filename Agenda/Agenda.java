package Agenda;

import java.io.*;
import java.util.Scanner;

public class Agenda{
    private String nombreArchivo;

    public Agenda(String nombreArchivo){
        this.nombreArchivo = nombreArchivo;
    }

    public String guardarContacto(String nombre, String apellido, String telefono, String email){
        return "Nombre: " + nombre + " " + apellido + "\tTelefono: " + telefono + "\t" + email + "\n";
    }

    public boolean guardarAgenda(String contacto){
        if (!contacto.isEmpty()){
            try{
                BufferedWriter escribir = new BufferedWriter(new FileWriter(nombreArchivo, true));
                escribir.write(contacto);
                System.out.println("Contacto guardardo correctamente!");
                escribir.close();
            }
            catch (IOException e){
                System.out.println("Error");
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public void mostrarAgenda(){
        try{
            File archivo = new File(nombreArchivo);
            Scanner leer = new Scanner(archivo);
            while (leer.hasNextLine()){
                String contacto = leer.nextLine();
                System.out.println(contacto);
            }
            leer.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        Agenda agenda = new Agenda("./Agenda.txt");
        Scanner inputUsuario = new Scanner(System.in);
        char opcion = 'a';
        // Menu
        do{
            System.out.println("AGENDA");
            System.out.println("[1] GUARDAR CONTACTO");
            System.out.println("[2] LEER AGENDA");
            System.out.println("[0] SALIR");
            System.out.print("OPCION: ");
            String opcionUsuario = inputUsuario.nextLine();
            opcion = opcionUsuario.charAt(0); // Obtener el primer caracter del input del usuario
            switch (opcion) {
                case '0':
                    // Cerrar programa
                    System.out.println("CERRANDO AGENDA...");
                    break;
                case '1':
                    // Guardar contacto nuevo
                    System.out.println("GUARDAR USUARIO...");
                    String nombre, apellido, telefono, email;
                    String contacto;
                    System.out.print("INGRESE EL NOMBRE: ");
                    nombre = inputUsuario.nextLine();
                    System.out.print("INGRESE EL APELLIDO: ");
                    apellido = inputUsuario.nextLine();
                    System.out.print("INGRESE EL TELEFONO: ");
                    telefono = inputUsuario.nextLine();
                    System.out.print("INGRESE EL EMAIL: ");
                    email = inputUsuario.nextLine();

                    contacto = agenda.guardarContacto(nombre, apellido, telefono, email);
                    agenda.guardarAgenda(contacto.toString());
                    break;
                case '2':
                    // Leer Agenda.txt
                    agenda.mostrarAgenda();
                    break;
                default:
                    System.out.println("OPCION NO DISPONIBLE");
                    break;
            }
        }while (opcion != '0');
        inputUsuario.close();
    }
}