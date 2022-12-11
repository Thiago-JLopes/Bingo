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
    DecimalFormat nf = new DecimalFormat("00");//formatar números da cartela

    public Cartela(int numJogadores, String modoJogo) {
        listaCartelas = new ArrayList<>();
        Cartela.numJogadores = numJogadores;
        Cartela.modoJogo = modoJogo.trim();
    }

    public void criarCartelas() {

        for (int n = 0; n < numJogadores; n++) {//cria n cartelas e adicona na lista de cartelas

            String cartela[][] = new String[6][5];
            PreecherCartelas newCartela = new PreecherCartelas();

            //Cria vetores para armazenar os números sem repetição.
            int colunaB[] = new int[5];
            int colunaI[] = new int[5];
            int colunaN[] = new int[5];
            int colunaG[] = new int[5];
            int colunaO[] = new int[5];

            //Chama método para preencher os vetores e ordenar.
            newCartela.preencherColuna(colunaB, 1, 16);
            newCartela.preencherColuna(colunaI, 16, 31);
            newCartela.preencherColuna(colunaN, 31, 46);
            newCartela.preencherColuna(colunaG, 46, 61);
            newCartela.preencherColuna(colunaO, 61, 76);

            //Define a primeira linha da matriz cartela.
            cartela[0][0] = " B   ";
            cartela[0][1] = " I   ";
            cartela[0][2] = " N   ";
            cartela[0][3] = " G   ";
            cartela[0][4] = " O   ";

            //Preecher a cartela com o vetor já ordenado.
            for (int j = 0; j < 5; j++) {
                for (int i = 1; i < 6; i++) {

                    if (i == 3 && j == 2) {
                        cartela[i][j] = "     ";
                    } else {
                        switch (j) {
                            case 0:
                                cartela[i][j] = "[ ]" + nf.format(colunaB[i - 1]);
                                break;
                            case 1:
                                cartela[i][j] = "[ ]" + colunaI[i - 1];
                                break;
                            case 2:
                                cartela[i][j] = "[ ]" + colunaN[i - 1];
                                break;
                            case 3:
                                cartela[i][j] = "[ ]" + colunaG[i - 1];
                                break;
                            case 4:
                                cartela[i][j] = "[ ]" + colunaO[i - 1];
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

    public void imprime(List marcadores, int sorteado) {
        int n = 1;
        
        System.out.println("O número sorteado foi: " + sorteado + "\n");
        if(marcadores.isEmpty()) {
            System.out.println("Ninguém marcou nesta rodada");
        } else {
            for (int i = 0; i < marcadores.size(); i++) {
                System.out.println("O jogador " + marcadores.get(i)+ " marcou.");
            }
        }
        for (String[][] leCartela : listaCartelas) {
            System.out.println("\nCartela " + n);
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

    public void marcaCartelas(int sorteado) {
        int numSorteado = sorteado;
        List<Integer> marcadores = new ArrayList<>(); // Lista para guardar os jogadores que marcaram na rodada.
        int n = 0;
        while (n < numJogadores) {
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 5; j++) {
                    if (listaCartelas.get(n)[i][j].equals("[ ]" + nf.format(numSorteado))) {
                        listaCartelas.get(n)[i][j] = "[x]" + nf.format(numSorteado);
                        marcadores.add(n+1);
                    }
                }
            }
            n++;
        }
        
        imprime(marcadores, numSorteado);
    }

    /*public void ganhador(int sorteado) {
        int n = 0;
        while (n < numJogadores) {
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 5; j++) {
                    if (listaCartelas.get(n)[i][j].equals("[ ]" + nf.format(sorteado))) {
                    }
                }
            }
            n++;
        }
    }*/
}
