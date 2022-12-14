/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package dcc025.bingo;

/**
 *
 * @author thiago
 */
import java.util.*;

public class Bingo {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int numJogadores;
        String modoJogo;
        String continuar = "S";

        System.out.println("------------------------------------------------------------------------");
        System.out.println("                       B     I     N     G     O");
        System.out.println("------------------------------------------------------------------------");
        System.out.println("Bem Vindo ao Bingo!");

        System.out.println("\n_____________________________");
        System.out.println("\nDigite o número de jogadores: ");
        numJogadores = teclado.nextInt();

        System.out.println("Digite o modo de jogo:");
        System.out.println("1 - Linha/Coluna\n2 - Cruz");
        modoJogo = teclado.next();
        System.out.println("_____________________________");

        Cartela newCartela = new Cartela(numJogadores, modoJogo);
        newCartela.criarCartelas();

        List<Integer> jaSorteados = new ArrayList<>();
        GeradorNumero sorteado = new GeradorNumero();

        do {
            int valSorteado = sorteado.aleatorio(1, 75);
            jaSorteados.add(valSorteado);
            newCartela.marcaCartelas(valSorteado);

            if (!Cartela.ganhador()) {
                System.out.println("Deseja continuar? (S/N)");
                continuar = teclado.next();
            } else {
                break;
            }
        } while (continuar.equalsIgnoreCase("S"));

    }
}
