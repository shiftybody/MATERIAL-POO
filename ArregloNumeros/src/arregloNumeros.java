/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

public class arregloNumeros {

    private int [] arreglo;
    private int indice;

    private void ordenar(){
        for (int i = 0; i < indice - 1; i++){
            for (int j = i+1; j < indice; j++){
                if (arreglo[i] > arreglo[j]){
                    int tempo = arreglo[j];
                    arreglo [j] = arreglo[i];
                    arreglo [i] = tempo;
                }
            }
        }
    }

    private void agregarNumero(int valor){
        if (indice == arreglo.length ){
            int [] temporal = new int[arreglo.length + 4];
            for (int i = 0; i < indice; i++){
                temporal[i] = arreglo[i];
            }
            arreglo = temporal;
        }
        arreglo[indice] = valor;
        indice ++;
    }

    public void principal(){
        Scanner in = new Scanner(System.in);
        arreglo = new int[10];
        indice = 0;
        int valor=0;
        do{
            System.out.print("Escribe un numero, \"0\" para salir: > " );
            valor = Integer.parseInt(in.nextLine());
            if (valor != 0){
                agregarNumero(valor);
            }
        }while(valor != 0);
        ordenar();
        for (int i = 0; i < indice; i++){
            System.out.println((i+1) + ".- " + arreglo[i] );
        }

    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        arregloNumeros on = new arregloNumeros();
        on.principal();
    }

}