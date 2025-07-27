package banco_digital;

public class Main {
    public static void main(String[] args) {

        Cliente is = new Cliente();
        is.setNome("Isaque");

        Conta account = new ContaCorrente(is);
        Conta account2 = new ContaPoupanca(is);

        account.depositar(500);
        account.transferir(200,account2);

        account.imprimirExtrato();
        account2.imprimirExtrato();

    }
}
