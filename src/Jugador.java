import java.util.Scanner;

public class Jugador {
    private String nombre;

    //este es el constructor de la clase jugador, su porposito es inicializar los atributos
    public Jugador(String nombre) {
        this.nombre = nombre;
        ;
    }
    //este metodo permite al usuario ingresar un intento de 4 dígitos únicos y convierte esa entrada en un array de enteros
    public int[] ingresarIntento() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa un número de 4 dígitos únicos:");
        String intento = scanner.nextLine();
        int[] intentoArray = new int[4];

        for (int i = 0; i < 4; i++) {
            intentoArray[i] = Character.getNumericValue(intento.charAt(i));
        }
        return intentoArray;
    }

    //este metodo muestra las cantidades de picas y fijas que tiene el jugador
    public void mostrarResultado(Resultado resultado) {
        System.out.println("Picas: " + resultado.getPicas() + ", Fijas: " + resultado.getFijas());
    }
}
