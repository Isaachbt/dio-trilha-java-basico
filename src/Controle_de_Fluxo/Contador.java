package Controle_de_Fluxo;

import java.util.Scanner;

public class Contador {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Digite o primeiro parâmetro 1");
        int parametroUm = scn.nextInt();
        System.out.println("Digite o segundo parâmetro 2");
        int parametroDois = scn.nextInt();

        try {
            contar(parametroUm, parametroDois);

        }catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

    }
    static void contar(int parametroUm, int parametroDois ) throws ParametrosInvalidosException {
        if (parametroUm >= parametroDois) {
            throw new ParametrosInvalidosException("O segundo parâmetro deve ser maior que o primeiro");
        }

        int contagem = parametroDois - parametroUm;
        for (int i = 0; i <= contagem; i++) {
            System.out.println("Contando: " + (parametroUm + i));
        }
    }
}
