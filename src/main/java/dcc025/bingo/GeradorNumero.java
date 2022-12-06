/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.bingo;

import java.util.Random;

/**
 *
 * @author thiago
 */
public class GeradorNumero {

    private static int min;
    private static int max;
    private static Random numAleatorio;

    public GeradorNumero() {
        numAleatorio = new Random();
    }

    public int aleatorio(int min, int max) {
        this.min = min;
        this.max = max;

        return numAleatorio.nextInt(this.min, this.max);
    }

}
