/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcularraizcuadrada;

import java.util.Scanner;

/**
 *
 * @author QDEVP1
 */
public class Calcularraizcuadrada {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Calcular una raíz no cuadrada.\nBase:");
        double numero = sc.nextDouble();
        System.out.println("Exponente:");
        double exponente=sc.nextDouble();
        System.out.println("Resultado:" + raizEnesimas(numero, exponente));
        /*
        System.out.println("Calculo de logaritmo: dime la base y el numero a obtener");
        System.out.println("Base:");
        int base=sc.nextInt();
        System.out.println("Numero a obtener:");
        int numeroObtener=sc.nextInt();
        double baseElevadaACeroPuntoCinco=raizCuadrada(base);
        if(baseElevadaACeroPuntoCinco>numeroObtener){
            
        }else{
            
        }
         */
    }

    public static double raizCuadrada(int numero) {
        int cont = 0;
        while (cont * cont < numero) {
            cont++;
        }
        cont--;
        double numerocalcular;
        double numerocalcularaux = cont;
        do {
            numerocalcular = numerocalcularaux;
            numerocalcularaux = ((numero / numerocalcular) + numerocalcular) / 2;
            System.out.println(numerocalcularaux);
        } while (numerocalcularaux != numerocalcular);
        return numerocalcularaux;
    }

    public static double exponentesEnteros(double base, int exponente) {
        if (exponente == 0) {
            return 1;
        }
        double resultado = 1;
        for (int i = 0; i < exponente; i++) {
            resultado = base * resultado;
        }
        return resultado;
    }

    public static long calcularFactorial(int numero) {
        long resultado = 1;
        for (int i = numero; i != 1; i--) {
            resultado *= i;
        }
        return resultado;
    }

    public static double funcionExponencial(double numero) {
        int cont = 0;
        double resultadoTotal = 1;
        double operacion = resultadoTotal;
        cont++;
        while (operacion > 0.0001) {
            operacion = operacion * numero / cont;
            resultadoTotal += operacion;
            cont++;
        }
        return resultadoTotal;
    }

    public static double calcularLogaritmosNeperianos(double numero) {
        if (numero <= 0) {
            return 0; 
        }

        double resultado = (double) numero / 3.0;
        double derivada;

        do {
            derivada = funcionExponencial(resultado);
            resultado = resultado + (numero - derivada) / derivada;
        } while (Math.abs(derivada - numero) > 0.0001);
        
        return resultado;
    }
    
    public static double calcularPotenciasGenerales(double base, double exponente){
        double lnBase=calcularLogaritmosNeperianos(base);
        double exponenteExponencial=exponente*lnBase;
        return funcionExponencial(exponenteExponencial);
    }
    
    public static double raizEnesimas(double numero, double expRaiz){
        double lnExp=calcularLogaritmosNeperianos(numero);
        double num=lnExp/expRaiz;
        return funcionExponencial(num);
    }
}
