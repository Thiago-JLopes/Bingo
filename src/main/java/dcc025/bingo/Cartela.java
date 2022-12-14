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
    private static List<String> listaSorteados;
    private static List<Integer> listaMarcaram;
    DecimalFormat nf = new DecimalFormat("00");//formatar números da cartela

    public Cartela(int numJogadores, String modoJogo) {
        listaCartelas = new ArrayList<>();
        listaSorteados = new ArrayList<>();
        Cartela.numJogadores = numJogadores;
        Cartela.modoJogo = modoJogo.trim();
    }

    public void criarCartelas() {

        for (int n = 0; n < numJogadores; n++) {//cria n cartelas e adicona na lista de cartelas

            String cartela[][] = new String[5][5];
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

            //Preecher a cartela com o vetor já ordenado.
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {

                    if (i == 2 && j == 2) {
                        cartela[i][j] = "     ";
                    } else {
                        switch (j) {
                            case 0:
                                cartela[i][j] = "[ ]" + nf.format(colunaB[i]);
                                break;
                            case 1:
                                cartela[i][j] = "[ ]" + colunaI[i];
                                break;
                            case 2:
                                cartela[i][j] = "[ ]" + colunaN[i];
                                break;
                            case 3:
                                cartela[i][j] = "[ ]" + colunaG[i];
                                break;
                            case 4:
                                cartela[i][j] = "[ ]" + colunaO[i];
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
        //Imprime os marcadores da rodade se tiver.
        System.out.println("O número sorteado foi: " + sorteado + "\n");
        if (marcadores.isEmpty()) {
            System.out.println("Ninguém marcou nesta rodada");
        } else {
            for (int i = 0; i < marcadores.size(); i++) {
                listaMarcaram.add(n);
                System.out.println("O jogador " + marcadores.get(i) + " marcou.");
            }
        }
        //----------------------------------------------------------------------
        //Imprimi as cartelas.
        for (String[][] leCartela : listaCartelas) {
            System.out.println("\nCartela " + n);

            System.out.println("\n B       I       N       G       O");
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    System.out.print(leCartela[i][j] + "   ");
                }
                System.out.println("");
            }
            System.out.println("\n");
            n++;
        }
    }

    //Marcar as cartelas que tem o número sorteado.
    public void marcaCartelas(int sorteado) {

        listaMarcaram = new ArrayList<>();
        listaSorteados.add("[x]" + nf.format(sorteado)); //Guardar os números sorteados.
        int numSorteado = sorteado;
        List<Integer> marcadores = new ArrayList<>(); // Lista para guardar os jogadores que marcaram na rodada.

        int n = 0;
        while (n < numJogadores) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (listaCartelas.get(n)[i][j].equals("[ ]" + nf.format(numSorteado))) {
                        listaCartelas.get(n)[i][j] = "[x]" + nf.format(numSorteado);
                        marcadores.add(n + 1);
                        listaMarcaram.add(n);//Guardar as cartelas que marcaram na rodada.
                    }
                }
            }
            n++;
        }

        imprime(marcadores, numSorteado);
    }

    public static boolean ganhador() {
        if (listaSorteados.size() < 4) {
            return false;
        }

        if (modoJogo.equals("1")) {

            boolean temGanhador;
            for (int n = 0; n < listaCartelas.size(); n++) {
                temGanhador = verificaLinhaColuna(listaCartelas.get(n));
                if (temGanhador) {
                    System.out.println("O jogador " + (n + 1) + " ganhou!");
                    return true;
                }
            }
            listaMarcaram.clear();
        } else {
            boolean temGanhador;
            for (int n = 0; n < listaCartelas.size(); n++) {
                temGanhador = verificaCruz(listaCartelas.get(n));
                if (temGanhador) {
                    System.out.println("Fim de jogo! Vitoria da cartela " + (n + 1));
                    return true;
                }
            }
            listaMarcaram.clear();
        }
        return false;
    }

    private static boolean verificaLinhaColuna(String[][] cartelaAconferir) {

        for (int i = 0; i < 5; i++) {
            int contColuna = 0;
            for (int j = 0; j < 5; j++) {
                if (listaSorteados.contains(cartelaAconferir[i][j])) {
                    contColuna++;
                }
            }
            if (contColuna == 5 || (contColuna == 4 && i == 2)) {
                return true;
            }
        }
        //verificar linhas
        for (int j = 0; j < 5; j++) {
            int cont = 0;
            for (int i = 0; i < 5; i++) {
                if (listaSorteados.contains(cartelaAconferir[i][j])) {
                    cont++;
                }
            }
            if (cont == 5) {
                return true;
            }
        }
        return false;
    }

    private static boolean verificaCruz(String[][] cartelaAconferir) {
        int cont = 0;
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(j == 2 || i == 2) {
                    if(listaSorteados.contains(cartelaAconferir[i][j])) {
                        cont++;
                    }
                }
            }
        }
        
        
        return cont == 8;
    }

}
