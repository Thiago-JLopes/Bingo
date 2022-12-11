/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.bingo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thiago
 */
public class PreecherCartelas {

    public void preencherColuna(int vet[], int min, int max) {
        GeradorNumero newNumber = new GeradorNumero();

        for (int i = 0; i < vet.length; i++) {
            vet[i] = newNumber.aleatorio(min, max);
        }
        ordenaVetor(vet);
    }

    private void ordenaVetor(int vet[]) {
        int aux;
        for (int i = 0; i < vet.length; i++) {
            for (int j = i + 1; j < vet.length; j++) {
                if (vet[i] > vet[j]) {
                    aux = vet[i];
                    vet[i] = vet[j];
                    vet[j] = aux;
                }
            }
        }
    }
}
