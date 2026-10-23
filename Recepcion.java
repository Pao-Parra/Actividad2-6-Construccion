package biblioteca;

// se aplica el REMOVE MIDDLE MAN
public class Recepcion {
    private Catalogo catalogo;

    public Recepcion(Catalogo catalogo) {
        this.catalogo = catalogo;
    }
//se eliminan los metodos 
    /*public void registrarLibro(Libro libro) {
        catalogo.agregar(libro);
    }

    public Libro consultarLibro(String titulo) {
        return catalogo.buscarPorTitulo(titulo);
    }

    public int totalLibros() {
        return catalogo.total();
    }*/
//se creo el metodo getCatalogo
    public Catalogo getCatalogo(){
        return catalogo;
    }


}
