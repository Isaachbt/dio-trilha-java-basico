package sudoku;

import java.util.Scanner;
import java.util.Random;

    public class Sudoku {
        private static final int SIZE = 9;
        private int[][] board;
        private int[][] solution;

        public Sudoku() {
            board = new int[SIZE][SIZE];
            solution = new int[SIZE][SIZE];
            gerarTabuleiro();
        }

        private void gerarTabuleiro() {
            preencherTabuleiro(solution);
            copiarTabuleiro(solution, board);
            removerNumeros(board, 40);
        }

        private boolean preencherTabuleiro(int[][] tab) {
            for (int row = 0; row < SIZE; row++) {
                for (int col = 0; col < SIZE; col++) {
                    if (tab[row][col] == 0) {
                        int[] nums = embaralharNumeros();
                        for (int num : nums) {
                            if (validarNum(tab, row, col, num)) {
                                tab[row][col] = num;
                                if (preencherTabuleiro(tab)) {
                                    return true;
                                }
                                tab[row][col] = 0;
                            }
                        }
                        return false;
                    }
                }
            }
            return true;
        }

        private int[] embaralharNumeros() {
            int[] nums = new int[SIZE];
            for (int i = 0; i < SIZE; i++) nums[i] = i + 1;
            Random rand = new Random();
            for (int i = SIZE -1; i > 0; i--) {
                int j = rand.nextInt(i + 1);
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            return nums;
        }

        private void removerNumeros(int[][] tab, int quantidade) {
            Random rand = new Random();
            int removidos = 0;
            while (removidos < quantidade) {
                int row = rand.nextInt(SIZE);
                int col = rand.nextInt(SIZE);
                if (tab[row][col] != 0) {
                    tab[row][col] = 0;
                    removidos++;
                }
            }
        }

        private void copiarTabuleiro(int[][] origem, int[][] destino) {
            for (int i = 0; i < SIZE; i++) {
                System.arraycopy(origem[i], 0, destino[i], 0, SIZE);
            }
        }

        private boolean validarNum(int[][] tab, int row, int col, int num) {
            for (int i = 0; i < SIZE; i++) {
                if (tab[row][i] == num) return false;    // Linha
                if (tab[i][col] == num) return false;    // Coluna
            }
            int boxRow = (row / 3) * 3;
            int boxCol = (col / 3) * 3;
            for (int r = boxRow; r < boxRow + 3; r++) {
                for (int c = boxCol; c < boxCol + 3; c++) {
                    if (tab[r][c] == num) return false;  // Quadrante 3x3
                }
            }
            return true;
        }


        private void mostrarTabuleiro() {
            System.out.println("   0 1 2   3 4 5   6 7 8");
            for (int i = 0; i < SIZE; i++) {
                if (i % 3 == 0) System.out.println(" +-------+-------+-------+");
                System.out.print(i + "| ");
                for (int j = 0; j < SIZE; j++) {
                    System.out.print((board[i][j] == 0 ? ". " : board[i][j] + " "));
                    if ((j + 1) % 3 == 0) System.out.print("| ");
                }
                System.out.println();
            }
            System.out.println(" +-------+-------+-------+");
        }

        private boolean completo() {
            for (int[] linha : board) {
                for (int val : linha) {
                    if (val == 0) return false;
                }
            }
            return true;
        }

        public void jogar() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Bem vindo ao sudoku.Sudoku!");
            System.out.println("Digite linha coluna valor para jogar (ex: 0 1 5)");
            System.out.println("Comandos especiais: 'ajuda' para ver solução, 'sair' para encerrar.");
            while (true) {
                mostrarTabuleiro();
                if (completo()) {
                    System.out.println("Parabéns! Você completou o sudoku.Sudoku!");
                    break;
                }
                System.out.print("Sua jogada: ");
                String linha = scanner.next();
                if (linha.equalsIgnoreCase("sair")) break;
                if (linha.equalsIgnoreCase("ajuda")) {
                    mostrarSolucao();
                    continue;
                }
                int row, col, val;
                try {
                    row = Integer.parseInt(linha);
                    col = scanner.nextInt();
                    val = scanner.nextInt();
                } catch (Exception e) {
                    System.out.println("Entrada inválida! Tente novamente.");
                    scanner.nextLine();
                    continue;
                }
                if (row < 0 || row >= SIZE || col < 0 || col >= SIZE || val < 1 || val > 9) {
                    System.out.println("Valores fora do intervalo. Linha e coluna: 0-8, valor: 1-9.");
                    continue;
                }
                if (solution[row][col] != 0 && board[row][col] == 0) {

                    if (validarNum(board, row, col, val)) {
                        board[row][col] = val;
                    } else {
                        System.out.println("Jogada inválida segundo as regras do sudoku.Sudoku.");
                    }
                } else if (board[row][col] != 0) {
                    System.out.println("Posição já preenchida.");
                } else {
                    System.out.println("Essa posição é fixa e não pode ser alterada.");
                }
            }
            System.out.println("Fim do jogo. Obrigado por jogar!");
            scanner.close();
        }

        private void mostrarSolucao() {
            System.out.println("Solução completa:");
            for (int i = 0; i < SIZE; i++) {
                if (i % 3 == 0) System.out.println(" +-------+-------+-------+");
                for (int j = 0; j < SIZE; j++) {
                    if (j % 3 == 0) System.out.print("| ");
                    System.out.print(solution[i][j] + " ");
                }
                System.out.println("|");
            }
            System.out.println(" +-------+-------+-------+");
        }

        public static void main(String[] args) {
            Sudoku jogo = new Sudoku();
            jogo.jogar();
        }
    }
