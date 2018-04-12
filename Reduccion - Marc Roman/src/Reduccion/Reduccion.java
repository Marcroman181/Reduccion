package Reduccion;

import java.util.Scanner;

public class Reduccion {

    private Matriz m;

    public Reduccion() {
    }

    public boolean crearMatriz() {
        Scanner sc = new Scanner(System.in);
        int rows;
        int cols;

        System.out.println("Introduce el número de filas (tiene que ser par).");
        rows = pedirValor();

        System.out.println("Introduce el número de columnas (tiene que ser par).");
        cols = pedirValor();

        try {
            this.m = new Matriz(rows, cols);
        } catch (Exception e) {
            System.out.println(e.getMessage()+"\n");
            return false;   //Matriz impar  ===================================>
        }
        return true;
    }

    public void iniciarReduccion() {

        while (!crearMatriz()) {
        };

        this.m.rellenarRandom();
        this.m.imprimirMatriz();

        while (this.m.getRowsLength() % 2 == 0 && this.m.getColsLength() % 2 == 0) {

            m = new Matriz(this.m.getMatrizReducida());

            this.m.imprimirMatriz();
        }
    }

    public int pedirValor() {
        
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                return sc.nextInt();
            } catch (Exception e) {
                sc.next();
                System.out.println("Error, inserte un número");
            }
        }
    }

    public static void main(String[] args) {
        Reduccion r;
        r = new Reduccion();

        r.iniciarReduccion();
    }
}
