# 📱 Modelagem e Diagramação de um Componente iPhone

Este projeto foi desenvolvido como parte do desafio de modelar e implementar o componente iPhone com base no vídeo do lançamento original de 2007. O objetivo foi representar o iPhone como um dispositivo multifuncional, capaz de tocar músicas, realizar chamadas e navegar na internet.

---

## 🎯 Funcionalidades Modeladas

### 🔊 Reprodutor Musical
- `tocar()`
- `pausar()`
- `selecionarMusica(String musica)`

### 📞 Aparelho Telefônico
- `ligar(String numero)`
- `atender()`
- `iniciarCorreioVoz()`

### 🌐 Navegador na Internet
- `exibirPagina(String url)`
- `adicionarNovaAba()`
- `atualizarPagina()`

---

## 📐 Diagrama UML (Mermaid)

```mermaid
classDiagram
    class ReprodutorMusical {
        +tocar()
        +pausar()
        +selecionarMusica(musica: String)
    }

    class AparelhoTelefonico {
        +ligar(numero: String)
        +atender()
        +iniciarCorreioVoz()
    }

    class NavegadorInternet {
        +exibirPagina(url: String)
        +adicionarNovaAba()
        +atualizarPagina()
    }

    class Iphone {
        +tocar()
        +pausar()
        +selecionarMusica(musica: String)
        +ligar(numero: String)
        +atender()
        +iniciarCorreioVoz()
        +exibirPagina(url: String)
        +adicionarNovaAba()
        +atualizarPagina()
    }

    ReprodutorMusical <|.. Iphone
    AparelhoTelefonico <|.. Iphone
    NavegadorInternet <|.. Iphone
