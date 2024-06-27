import java.util.Scanner;

public class elGranJuego{

    // modulos
    public static boolean validarEntero(int entero){
        // verifica que el numero ingresado sea una tirada válida de dados (1-6)
        boolean valido;

        valido = false;
        if (entero <= 6 && entero >= 1){
            valido = true;
        }

        return valido;
    }

    public static int calcularPuntaje(int dado1, int dado2){
        // calcula el puntaje según los enteros ingresados
        int puntaje;
        
        puntaje = 0;

        if (validarDado(dado1) || validarDado(dado2)){
            if (validarDado(dado1) && validarDado(dado2)){
                if (esPar(dado1) && esPar(dado2)){
                    puntaje = dado1 * dado2;
                } else puntaje = dado1 + dado2;
            } else{
                if (!validarDado(dado1)){
                    puntaje = dado2;
                } else puntaje = dado1;
            }
        }
        
        return puntaje;
    }

    public static boolean esPar(int entero){
        // verifica que el número entero ingresado sea par
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
        int dado1, dado2, dado3, dado4, puntaje1, puntaje2, puntajeRonda; 
        int rondaMayorPuntaje1, rondaMayorPuntaje2, mayorPuntaje1, mayorPuntaje2, i, j;

        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el nombre del primer jugador: ");
        jugador1 = sc.next();
        System.out.println("Ingrese el nombre del segundo jugador: ");
        jugador2 = sc.next();
        puntaje1 = 0;
        puntaje2 = 0;
        rondaMayorPuntaje1 = 0;
        rondaMayorPuntaje2 = 0;
        mayorPuntaje1 = 0;
        mayorPuntaje2 = 0;
        i = 0;
        j = 0;

        do{
            do {
                System.out.println("Ingrese las tiradas del primer jugador, separando los números por un espacio: ");
                dado1 = sc.nextInt();
                dado2 = sc.nextInt();
                puntajeRonda = calcularPuntaje(validarDado(dado1), validarDado(dado2));
                puntaje1 += puntajeRonda;
                System.out.println("Puntaje actual: " + puntaje1);
                i++;
                if (puntajeRonda > mayorPuntaje1) {
                    mayorPuntaje1 = puntajeRonda;
                    rondaMayorPuntaje1 = i;
                }
            } while (puntaje1 < 50 && !sonIguales(dado1, dado2));

        
            do{
                System.out.println("Ingrese la tirada del segundo jugador, separando los números por un espacio: ");
                dado3 = sc.nextInt();
                dado4 = sc.nextInt();
                puntajeRonda = calcularPuntaje(validarDado(dado3), validarDado(dado4));
                puntaje2 += puntajeRonda;
                System.out.println("Puntaje actual: " + puntaje2);
                j++;
                if (puntajeRonda > mayorPuntaje2){
                    mayorPuntaje2 = puntaje2;
                    rondaMayorPuntaje2 = j;
                }
            } while (puntaje2 < 50 && !sonIguales(dado3, dado4));
            
        } while (puntaje1 < 50 && puntaje2 < 50);

    if (puntaje1 == puntaje2){
            System.out.println("Empate! El puntaje final de ambos jugadores es de " + puntaje1);
        } else{
            if (puntaje1 > puntaje2){
                System.out.println("El ganador es " + jugador1 + "! Su puntaje acumulado es de " + puntaje1 + " puntos.");
            } else System.out.println("El ganador es " + jugador2 + "! Su puntaje acumulado es de " + puntaje2 + " puntos.");
        }

        System.out.println(
            "El mayor puntaje de " + jugador1 + " fue de " + mayorPuntaje1 + " en la ronda " + rondaMayorPuntaje1 + "!"
        );

        System.out.println(
            "El mayor puntaje de " + jugador2 + " fue de " + mayorPuntaje2 + " en la ronda " + rondaMayorPuntaje2 + "!"
        );
        
    }

}
