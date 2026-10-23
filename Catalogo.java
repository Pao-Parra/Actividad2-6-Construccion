package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Catalogo {
    private List<Libro> libros = new ArrayList<>();

    public void agregar(Libro libro) {
        libros.add(libro);
    }

    public Libro buscarPorTitulo(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null;
    }

    public int total() {
        return libros.size();
    }

     public void registrarLibro(Libro libro) {
        agregar(libro);
    }

    public Libro consultarLibro(String titulo) {
        return buscarPorTitulo(titulo);
    }

    public int totalLibros() {
        return total();
    }

}
