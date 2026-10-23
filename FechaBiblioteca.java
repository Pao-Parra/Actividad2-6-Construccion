package biblioteca;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



//se crea la nueva clase FechaBiblioteca por el  metodo de INTRODUCE LOCAL EXTENSION
public class FechaBiblioteca extends Prestamo{

   
    public  FechaBiblioteca(Libro libro, Socio socio, Date fechaPrestamo, Date fechaDevolucion) {
      super(libro, socio,  fechaPrestamo, fechaDevolucion);
        }

    //Metodos colocados 

    public static  int diasEntre (Date desde, Date hasta) {
        double milisPorDia = 24.0 * 60 * 60 * 1000;
        return (int) Math.round((hasta.getTime() - desde.getTime()) / milisPorDia);
    }

    public String formatearFecha(Date fecha) {
        return new SimpleDateFormat("dd/MM/yyyy").format(fecha);
    }

    public static  boolean esFinDeSemana(Date fecha) {
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(fecha);
        int dia = calendario.get(Calendar.DAY_OF_WEEK);
        return dia == Calendar.SATURDAY || dia == Calendar.SUNDAY;
    }

   
    public void imprimirFechas(){
        super.imprimirResumen();
        System.out.println("Prestado: " + formatearFecha(fechaPrestamo));
        System.out.println("Vence: " + formatearFecha(calcularFechaVencimiento()));
        System.out.println("Vence en fin de semana: " + esFinDeSemana(calcularFechaVencimiento()));
        System.out.println("Devuelto: " + formatearFecha(fechaDevolucion));
    }
  
}
