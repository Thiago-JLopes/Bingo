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
        
        System.out.println("------------------------------------------------------------------------");
        System.out.println("                       B     I     N     G     O");
        System.out.println("------------------------------------------------------------------------");
        System.out.println("Bem Vindo ao Bingo!");
        
        System.out.println("\n_____________________________"); 
        System.out.println("\nDigite o número de jogadores: ");
        numJogadores = teclado.nextInt();
        
        System.out.println("Digite o modo de jogo:");
        System.out.println("1 - Linha\n2 - Cruz");
        modoJogo = teclado.next();
        System.out.println("_____________________________");
        
        Cartela newCartela = new Cartela(numJogadores, modoJogo);
        newCartela.preecherCartela();
        newCartela.imprime();
        newCartela.ganhador(4);
        newCartela.imprime();
        
    }
}
