/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.bingo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author thiago
 */
public class GeradorNumero {

    private int min;
    private int max;
    private static List<Integer> numSorteado;
    private static Random numAleatorio;

    public GeradorNumero() {
        numAleatorio = new Random();
        numSorteado = new ArrayList<>();
    }

    public int aleatorio(int min, int max) {
        this.min = min;
        this.max = max;
        int val = numAleatorio.nextInt(this.min, this.max);

        if (numSorteado.contains(val)) {
            return aleatorio(this.min, this.max);
        }
        numSorteado.add(val);
        return val;
    }

}
