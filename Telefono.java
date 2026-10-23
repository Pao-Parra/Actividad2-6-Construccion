package biblioteca;
//Extract class se aplico , clase con una sola responsabilidad
public class Telefono {
    private String codigoArea;
    private String numero;
    
    
    public Telefono(String codigoArea, String numero) {
        this.codigoArea = codigoArea;
        this.numero =numero;
    }

    public String obtenerTelefonoCompleto() {
        return "(" + codigoArea + ") " + numero;
    }

    public boolean esTelefonoLocal() {
        return codigoArea.equals("999");
    }
}