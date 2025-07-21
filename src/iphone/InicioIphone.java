package iphone;

public class InicioIphone {

    public static void main(String[] args) {
        Iphone iphone = new Iphone();

        // Testando reprodutor musical
        iphone.selecionarMusica("Bohemian Rhapsody");
        iphone.tocar();
        iphone.pausar();

        // Testando aparelho telefônico
        iphone.ligar("11999999999");
        iphone.atender();
        iphone.iniciarCorreioDeVoz();

        // Testando navegador
        iphone.exibirPagina("https://dio.me");
        iphone.addNovaAba();
        iphone.atualizarPagina();
    }
}
