package jogodecartas;

import java.util.Scanner;

public class Jogo {

    private final Scanner entrada = new Scanner(System.in);
    private final Baralho BARALHO;
    private Jogador[] jogadores;

    public Jogo() {
        BARALHO = new Baralho();
        BARALHO.mostrarBaralho();
        BARALHO.embaralhar();
        BARALHO.mostrarBaralho();
    }

    public void iniciarJogo() {
        int qtdJogadores = 0;

        do {
            System.out.println("Quantos jogadores irao participar? (maximo de 7 jogadores)");
            qtdJogadores = entrada.nextInt();
        } while (qtdJogadores > 7);

        jogadores = new Jogador[qtdJogadores];

        for (int i = 0; i < qtdJogadores; i++) {
            System.out.println("Jogador " + i + ", digite seu nome:");
            jogadores[i] = new Jogador(entrada.next());
        }
    }

    public void distribuirCartas(int qtdCartas) {
        for (Jogador jogadore : jogadores) {
            jogadore.setCartas(BARALHO.distribuirCartas(qtdCartas));
        }
    }

    public void mostrarCartas() {
        for (Jogador jogadore : jogadores) {
            jogadore.mostrarCartas();
        }
    }

    public static void main(String[] args) {
        Jogo executar = new Jogo();
        executar.iniciarJogo();
        executar.distribuirCartas(7);
        executar.mostrarCartas();
    }
}
