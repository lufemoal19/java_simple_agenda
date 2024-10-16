package Agenda;

public class Contacto{
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