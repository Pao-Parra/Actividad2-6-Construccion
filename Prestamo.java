package biblioteca;

import java.util.Date;

public class Prestamo {
    private Libro libro;
    private Socio socio;
    private FechaBiblioteca fechaPrestamo;
    private FechaBiblioteca fechaDevolucion;
    private int diasPlazoPrestamo;
    
    public Prestamo(){

    }

    public Prestamo(Libro libro, Socio socio, Date fechaPrestamo, Date fechaDevolucion, int diasPlazoPrestamo) {
        this.libro = libro;
        this.socio = socio;
        this.fechaPrestamo = new FechaBiblioteca(fechaPrestamo);
        this.fechaDevolucion = new FechaBiblioteca(fechaDevolucion);
        this.diasPlazoPrestamo = diasPlazoPrestamo;
    }

    //Aqui se aplica el Hide delegate  con los metodos get y set para que se llame al main directo desde prestamo
    public String getSocioCiudad() { return socio.getCiudad(); }
    public String getLibroAutor() { return libro.getAutor(); }
    public String getSocioTelefono() { return socio.obtenerTelefonoCompleto(); }


    // INTRODUCE FOREIGN METHOD
    public FechaBiblioteca calcularFechaVencimiento() {
        return fechaPrestamo.sumarDias(diasPlazoPrestamo);
    }
    //se crea el metodo sumarDias se vuelve mi metodo foraneo, este se va a FechaBiblioteca
    /*private static Date sumarDias(Date fecha, int dias){
        return new Date(fecha.getTime() + dias * 24L * 60 * 60 * 1000);
    }*/

    //
    public int calcularDiasRetraso() {
         return calcularFechaVencimiento().diasEntre(fechaDevolucion);
    }


    // MOVE METHOD se translada a otra clase que es Libro ya que usa más cosas de ahi
    /*public double calcularMulta(int diasRetraso) {
        if (diasRetraso <= 0) {
            return 0;
        }
        double multa = diasRetraso * libro.getMultaPorDia();
        if (libro.getCategoria().equals("NOVEDAD")) {
            multa = multa * 2;
        }
        if (multa > libro.getValorReposicion()) {
            multa = libro.getValorReposicion();
        }
        return multa;
    }*/

    // INTRODUCE LOCAL EXTENSION se crea la clase FechaBiblioteca para esta:
    /*private int diasEntre(Date desde, Date hasta) {
        double milisPorDia = 24.0 * 60 * 60 * 1000;
        return (int) Math.round((hasta.getTime() - desde.getTime()) / milisPorDia);
    }

    private String formatearFecha(Date fecha) {
        return new SimpleDateFormat("dd/MM/yyyy").format(fecha);
    }

    private boolean esFinDeSemana(Date fecha) {
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(fecha);
        int dia = calendario.get(Calendar.DAY_OF_WEEK);
        return dia == Calendar.SATURDAY || dia == Calendar.SUNDAY;
    }*/

      public void imprimirResumen() {
        System.out.println("Libro: " + libro.getTitulo());
        System.out.println("Socio: " + socio.getNombre());    
        System.out.println("Prestado: " + fechaPrestamo.formatear());
        System.out.println("Vence: " + calcularFechaVencimiento().formatear());
        System.out.println("Vence en fin de semana: " + calcularFechaVencimiento().esFinDeSemana());
        System.out.println("Devuelto: " + fechaDevolucion.formatear());      
    }
}
