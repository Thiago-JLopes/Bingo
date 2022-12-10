/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.bingo;

/**
 *
 * @author thiago
 */
import java.text.DecimalFormat;
import java.util.*;

public class Cartela {

    private static int numJogadores;
    private static String modoJogo;
    private static List<String[][]> listaCartelas;
    DecimalFormat nf = new DecimalFormat("00");

    public Cartela(int numJogadores, String modoJogo) {
        listaCartelas = new ArrayList<>();
        Cartela.numJogadores = numJogadores;
        Cartela.modoJogo = modoJogo.trim();
    }

    public void preecherCartela() {
        for (int n = 0; n < numJogadores; n++) {
            GeradorNumero numAleatorio = new GeradorNumero();
            String cartela[][] = new String[6][5];

            cartela[0][0] = " B   ";
            cartela[0][1] = " I   ";
            cartela[0][2] = " N   ";
            cartela[0][3] = " G   ";
            cartela[0][4] = " O   ";

            for (int i = 1; i < 6; i++) {
                for (int j = 0; j < 5; j++) {

                    if (i == 3 && j == 2) {
                        cartela[i][j] = "     ";
                    } else {

                        switch (j) {
                            case 0:
                                cartela[i][j] = "[ ]" + nf.format(numAleatorio.aleatorio(1, 16));
                                break;
                            case 1:
                                cartela[i][j] = "[ ]" + nf.format(numAleatorio.aleatorio(16, 31));
                                break;
                            case 2:
                                cartela[i][j] = "[ ]" + nf.format(numAleatorio.aleatorio(31, 46));
                                break;
                            case 3:
                                cartela[i][j] = "[ ]" + nf.format(numAleatorio.aleatorio(46, 61));
                                break;
                            case 4:
                                cartela[i][j] = "[ ]" + nf.format(numAleatorio.aleatorio(61, 76));
                                break;
                            default:
                                break;
                        }
                    }
                }
            }

            listaCartelas.add(cartela);
        }
    }

    public void imprime() {
        int n = 1;
        for (String[][] leCartela : listaCartelas) {
            System.out.println("Cartela " + n);
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 5; j++) {
                    System.out.print(leCartela[i][j] + "   ");
                }
                System.out.println("");
            }
            System.out.println("\n");
            n++;
        }
    }

    public void ganhador(int sorteado) {
        int n = 0;
        while (n < numJogadores) {
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 5; j++) {
                    if (listaCartelas.get(n)[i][j].equals("[ ]" + nf.format(sorteado))) {
                        listaCartelas.get(n)[i][j] = "[x]" + nf.format(sorteado);
                    }
                }
            }
            n++;
        }
    }

}
