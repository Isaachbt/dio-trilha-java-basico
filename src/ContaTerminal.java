import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ContaTerminal {

    private static int numero;
    private static String agencia;
    private static String nomeCliente;
    private static double saldo;

    public static void main(String[] args) {

        System.out.println("Bem vindo ao Banco Java!");
        System.out.println("Vamos começar com os dados da sua conta.");
        System.out.println();
        System.out.println("Digite o numero da sua conta: ");
        numero = new Scanner(System.in).nextInt();
        System.out.println("Digite a agencia da sua conta: ");
        agencia = new Scanner(System.in).next();
        System.out.println("Digite o nome: ");
        nomeCliente = new Scanner(System.in).next();
        System.out.println("Digite o saldo da sua conta: ");
        saldo = new Scanner(System.in).nextDouble();

        System.out.println("Olá " + nomeCliente + ", obrigado por criar uma conta em nosso banco, sua agencia é "
                + agencia + " conta " + numero + " e seu saldo é R$ " + saldo + " já está disponível para saque!");

    }
}