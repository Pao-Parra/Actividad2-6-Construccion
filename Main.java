package biblioteca;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        Catalogo catalogo = new Catalogo();
        Recepcion recepcion = new Recepcion(catalogo);
        //se aplica el remove middle man en esta parte se llama directo a catalogo
        recepcion.getCatalogo().agregar(new Libro("Java Basico", "R. Perez", "978-1-11111-111-1", "NOVEDAD", 5, 300));
        recepcion.getCatalogo().agregar(new Libro("Estructuras de Datos", "M. Diaz", "978-2-22222-222-2", "NORMAL", 3, 400));
        System.out.println("Libros registrados: " + recepcion.getCatalogo().total());

        Libro libro = recepcion.getCatalogo().buscarPorTitulo("java basico");
        Socio socio = new Socio("Ana Lopez", "Merida", new Telefono("999", "1234567"));

        Date fechaPrestamo = new GregorianCalendar(2026, Calendar.OCTOBER, 1).getTime();
        Date fechaDevolucion = new GregorianCalendar(2026, Calendar.OCTOBER, 22).getTime();
        Prestamo prestamo = new Prestamo(libro, socio, fechaPrestamo, fechaDevolucion,14);

        System.out.println("-----------------------------");
        prestamo.imprimirResumen();
        System.out.println("-----------------------------");

        // HIDE DELEGATE  se le pregunta directo a prestamo 
        System.out.println("Ciudad del socio: " + prestamo.getSocioCiudad());
        System.out.println("Telefono del socio: " + prestamo.getSocioTelefono());
        System.out.println("Autor del libro: " + prestamo.getLibroAutor());

        int retraso = prestamo.calcularDiasRetraso();
        System.out.println("Dias de retraso: " + retraso);
        System.out.println("Multa: $" + libro.calcularMulta(retraso));
        System.out.println("ISBN: " + libro.getIsbn());
        System.out.println("Telefono local: " + socio.esTelefonoLocal());
    }
}

