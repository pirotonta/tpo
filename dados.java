import java.util.Scanner;

public class dados{

    // modulos
    public static boolean validarEntero(int entero){
        boolean valido;

        valido = false;
        if (entero <= 6 && entero >= 1){
            valido = true;
        }

        return valido;
    }

    public static int calcularPuntaje(int dado1, int dado2){
        int puntaje;
        puntaje = 0;
        
        if (validarEntero(dado1) && validarEntero(dado2)){
            if (esPar(dado1) && esPar(dado2)){
                puntaje = dado1 * dado2;
            } else puntaje = dado1 + dado2;
        }
        
        return puntaje;
    }

    public static boolean esPar(int entero){
        boolean par;

        par = false;
        if (entero%2==0){
            par = true;
        }

        return par;
    }

    // principal
    public static void main(String[] args){
        String jugador1, jugador2;
        int dado1, dado2, dado3, dado4, puntaje1, puntaje2;

        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el nombre del primer jugador: ");
        jugador1 = sc.next();
        System.out.println("Ingrese la tirada del primer jugador, separando los números por un espacio: ");
        dado1 = sc.nextInt();
        dado2 = sc.nextInt();
        puntaje1 = calcularPuntaje(dado1, dado2);

        System.out.println("Ingrese el nombre del segundo jugador: ");
        jugador2 = sc.next();
        System.out.println("Ingrese la tirada del segundo jugador, separando los números por un espacio: ");
        dado3 = sc.nextInt();
        dado4 = sc.nextInt();
        puntaje2 = calcularPuntaje(dado3, dado4);

        System.out.println("El puntaje de " + jugador1 + " es de: " + puntaje1 +
        "\nEl puntaje de " + jugador2 + " es de: " + puntaje2);

        if (puntaje1 > puntaje2){
            System.out.println("El ganador es " + jugador1 + "!");
        } else if (puntaje1 < puntaje2){
            System.out.println("El ganador es " + jugador2 + "!");
        } else System.out.println("Empate!");
        
    }

}
