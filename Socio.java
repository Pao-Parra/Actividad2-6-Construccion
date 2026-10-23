package biblioteca;

// EXTRACT CLASS se creo la clase de Telefono


// MOVE FIELD para Socio el dato de diasPrestamo se cambio a la clase Prestamo ya que tiene más sentido ahi
public class Socio {
    private String nombre;
    private String ciudad;
    private Telefono telefono; 

    

    public Socio(String nombre, String ciudad, Telefono telefono) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.telefono = telefono;
    }

    public String getNombre() { return nombre; }
    public String getCiudad() { return ciudad; }
    public String obtenerTelefonoCompleto() { return telefono.obtenerTelefonoCompleto(); }
    public boolean esTelefonoLocal() { return telefono.esTelefonoLocal(); }

}
