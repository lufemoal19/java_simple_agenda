package Agenda;

import java.io.*;
import java.util.Scanner;

public class Agenda{
    private String nombreArchivo = "./Agenda.txt";

    public Agenda(){}

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

    public static class Contacto{
        private String nombre;
        private String apellido;
        private String telefono;
        private String email;

        public Contacto(){
            this.nombre = "";
            this.apellido = "";
            this.telefono = "";
            this.email = "";
        }

        public Contacto(String nombre, String apellido, String telefono, String email){
            this.nombre = nombre;
            this.apellido = apellido;
            this.telefono = telefono;
            this.email = email;
        }

        public String getNombre(){
            return this.nombre;
        }

        public void setNombre(String nombre){
            this.nombre = nombre;
        }

        public String getApellido(){
            return this.apellido;
        }

        public void setApellido(String apellido){
            this.apellido = apellido;
        }

        public String getTelefono(){
            return this.telefono;
        }

        public void setTelefono(String telefono){
            this.telefono = telefono;
        }

        public String getEmail(){
            return this.email;
        }

        public void setEmail(String email){
            this.email = email;
        }

        public String toString(){
            return "Nombre: " + getNombre() + " " + getApellido() + "\tTelefono: " + getTelefono() + "\t" + getEmail() + "\n";
        }
    }

    public static void main(String[] args){
        Agenda agenda = new Agenda();
        Contacto contacto = new Contacto();        
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

                    System.out.print("INGRESE EL NOMBRE: ");
                    nombre = inputUsuario.nextLine();
                    System.out.print("INGRESE EL APELLIDO: ");
                    apellido = inputUsuario.nextLine();
                    System.out.print("INGRESE EL TELEFONO: ");
                    telefono = inputUsuario.nextLine();
                    System.out.print("INGRESE EL EMAIL: ");
                    email = inputUsuario.nextLine();

                    contacto = new Contacto(nombre, apellido, telefono, email);
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