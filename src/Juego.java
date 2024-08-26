import java.util.*;

public class Juego {
        private int[] numeroSecreto;
        private int intentos;

        //este es el constructor de la clase juego, su porposito es inicializar los atributos
        public Juego() {
            this.numeroSecreto = generarNumeroSecreto();
            this.intentos = 0;
            System.out.println("Número Secreto (para validación): " + Arrays.toString(numeroSecreto)); // para ver los numeros aleatorio
        }

        //metodo para  generar un número secreto de 4 dígitos únicos
        private int[] generarNumeroSecreto() {
            Random rand = new Random();
            Set<Integer> digitosUnicos = new LinkedHashSet<>();//asegura que el número aleatorio de 4 dígitos sean únicos para el juego
            while (digitosUnicos.size() < 4) {
                digitosUnicos.add(rand.nextInt(10));
            }
            return digitosUnicos.stream().mapToInt(Integer::intValue).toArray();

        }
        //este metodo se encarga de comparar el intento del jugador con el número secreto y calcular cuántas picas y fijas ha obtenido
        public Resultado verificarIntento(int[] intento) {
            int picas = 0;
            int fijas = 0;

            for (int i = 0; i < 4; i++) {
                if (intento[i] == numeroSecreto[i]) {
                    fijas++;
                } else if (contains(numeroSecreto, intento[i])) {
                    picas++;
                }
            }
            intentos++;
            return new Resultado(picas, fijas);
        }
        //este metodo verifica si un valor específico (key) existe en el array dado (arr) y devuelve true si lo encuentra o false si no.
        private boolean contains(int[] arr, int key) {
            for (int n : arr) {
                if (n == key) return true;
            }
            return false;
        }
        //este metodo "jugar" gestiona el flujo del juego, permitiendo al jugador realizar intentos y
        // proporcionando retroalimentación hasta que adivine correctamente.
        public void jugar() {
            Jugador jugador = new Jugador("Jugador 1");
            boolean ganador = false;

            while (!ganador) {
                int[] intento = jugador.ingresarIntento();
                Resultado resultado = verificarIntento(intento);
                jugador.mostrarResultado(resultado);
                ganador = resultado.esGanador();
            }
            System.out.println("Has adivinado el número en " + intentos + " intentos.");
        }
}



