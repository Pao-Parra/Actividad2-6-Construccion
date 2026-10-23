package biblioteca;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



//se crea la nueva clase FechaBiblioteca por el  metodo de INTRODUCE LOCAL EXTENSION
public class FechaBiblioteca extends Date{//extiende de Date 

    public  FechaBiblioteca(Date fecha) {
      super(fecha.getTime());
        }
   

    //Metodos colocados  se cambia la forma de como usarlos
    //Sumar dias se vuelve mi metodo foraneo.
    public FechaBiblioteca  sumarDias(int dias){
        return new FechaBiblioteca(new Date(getTime() + dias * 24L * 60 * 60 * 1000));
    }

    public int diasEntre ( Date hasta) {
        double milisPorDia = 24.0 * 60 * 60 * 1000;
        return (int) Math.round((hasta.getTime() - getTime()) / milisPorDia);
    }

     public String formatear() {
        return new SimpleDateFormat("dd/MM/yyyy").format(this);
    }
   public boolean esFinDeSemana() {
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(this);
        int dia = calendario.get(Calendar.DAY_OF_WEEK);
        return dia == Calendar.SATURDAY || dia == Calendar.SUNDAY;
    }

   
   
  
}
