package Reduccion;

import java.util.EmptyStackException;

public class Matriz {

    private int matriz[][];

    public Matriz(int rows, int cols) throws Exception{
        if(rows%2!=0 || cols%2!=0){
            throw new Exception("ERROR: Las dimensiones deben ser numeros pares.");
        }
        if(rows<1 || cols<1){
            throw new Exception("ERROR: Las dimensiones deben ser mayor que 0");
        }
        this.matriz = new int[rows][cols];
    }

    public Matriz(int nueva[][]) {
        
        this.matriz = new int[nueva.length][nueva[0].length];
        for (int i = 0; i < this.matriz.length; i++) {
            for (int j = 0; j < this.matriz[0].length; j++) {
                this.matriz[i][j] = nueva[i][j];
            }
        }

    }

    private void copiarMatriz(int[][] m) {

        this.matriz = new int[m.length][m[0].length];
        for (int i = 0; i < this.matriz.length; i++) {
            for (int j = 0; j < this.matriz[0].length; j++) {
                this.matriz[i][j] = m[i][j];
            }
        }
    }

    public int getColsLength() {
        return this.matriz[0].length;
    }

    public int[][] getMatrizReducida() {

        int[][] reducida;
        reducida = new int[matriz.length / 2][matriz[0].length / 2];

        //poner valores a la reducida
       for (int i = 0; i < reducida.length; i++) {
            for (int j = 0; j < reducida[0].length; j++) {
                reducida[i][j]
                        = matriz[i * 2][j * 2]
                        * matriz[i * 2][j * 2 + 1]
                        * matriz[i * 2 + 1][j * 2]
                        * matriz[i * 2 + 1][j * 2 + 1];
            }
        } 

        return reducida;
    }

    public int getRowsLength() {
        return this.matriz.length;
    }
    
    public int getValorMatriz(int row, int col) {
        return this.matriz[row][col];
    }
    
    public void imprimirMatriz() {
        System.out.println();
        for (int i = 0; i < this.matriz.length; i++) {
            for (int j = 0; j < this.matriz[0].length; j++) {
                System.out.print(this.matriz[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public void rellenarRandom() {

        for (int i = 0; i < this.matriz.length; i++) {
            for (int j = 0; j < this.matriz[0].length; j++) {
                this.matriz[i][j] = (int) (Math.random() * 11);
            }
        }
    }

    public void setValorMatriz(int valor, int row, int col) {
        this.matriz[row][col] = valor;
    }
}
