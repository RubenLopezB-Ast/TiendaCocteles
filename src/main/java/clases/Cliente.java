package clases;

/**
 * Creación de los clientes datos, compras, listados, modidificaciones ...
 * @author Rubén López
 * @version 1
 */
public class Cliente {
    private String nombre;
    private String apellidos;
    private String dni;
    private String direccion;
    private String telefono;
    private String email;

    /**
     * Datos perosnales para crear cliente
     * @param nombre
     * @param apellidos
     * @param dni
     * @param direccion
     * @param telefono
     * @param email
     */
    // Construyo clase
    public Cliente(String nombre, String apellidos, String dni, String direccion, String telefono, String email) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    /**
     * Saca el nombre del cliente
     * @return Nombre cliente
     */
    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    /**
     * Pone nombre cliente
     * @param nombre
     */

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Saca apellidos cliente
     * @return apellidos
     */

    public String getApellidos() {
        return apellidos;
    }

    /**
     * Pone apellidos nuevo cliente
     * @param apellidos
     */

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Saca DNI cliente
     * @return DNI
     */
    public String getDni() {
        return dni;
    }

    /**
     * Mete dni nuevo cliente
     * @param dni
     */

    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Saca dirección del cliente
     * @return dirección
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Pone dirección del cliente
     * @param direccion
     */

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Saca el teléfono del cliente
     * @return Teléfono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Pone teléfono del cliente
     * @param telefono
     */

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Saca email del cliente
     * @return email
     */

    public String getEmail() {
        return email;
    }

    /**
     * Pone email del cliente
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Saca ficha del cliente
     * @return ficha del cliente
     */
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


