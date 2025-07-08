package clases;

public class Cliente {
    private String nombre;
    private String apellidos;
    private String dni;
    private String direccion;
    private String telefono;
    private String email;

    // Construyo clase
    public Cliente(String nombre, String apellidos, String dni, String direccion, String telefono, String email) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // toString para mostrar información
    // aqui sobresscribo
    public String toString() {
        return "\n=== CLIENTE: " + nombre + "===" +
                "\nBuscado por: " + dni +
                "\nNombre: " + nombre +
                "\nApellidos: " + apellidos +
                "\nDNI: " + dni +
                "\nDirección: " + direccion +
                "\nTeléfono: " + telefono +
                "\nEmail: " + email + "\n";
    }
}


