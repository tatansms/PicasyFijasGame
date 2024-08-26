public class Resultado {
    private int picas;
    private int fijas;

    //este es el constructor de la clase Resultado, su porposito es inicializar los atributos
    public Resultado(int picas, int fijas) {
        this.picas = picas;
        this.fijas = fijas;
    }

    //Hacia abajo estan los metodos getters and setters de los atributos de la clase
    public int getPicas() {
        return picas;
    }

    public int getFijas() {
        return fijas;
    }

    //este metodo muestra el resultado de las picas y fijas
//    public void mostrarResultado() {
//        System.out.println("Picas: " + picas + " Fijas: " + fijas);
//    }

    //este metodo regresa un boleano dependiendo del caso, si las fijas son 4 es true de lo contrario false
    public boolean esGanador() {
        return fijas == 4;
    }
}
