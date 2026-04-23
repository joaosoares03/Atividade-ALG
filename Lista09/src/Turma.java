import java.util.Scanner;

public class Turma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantidade de alunos: ");
        int quantidade = scanner.nextInt();

        double[] notas = new double[quantidade];

        for (int i = 0; i < quantidade; i++) {
            System.out.print("Nota do aluno " + (i + 1) + ": ");
            notas[i] = scanner.nextDouble();
        }

        double soma = 0;
        for (int i = 0; i < quantidade; i++) {
            soma += notas[i];
        }

        double media = soma / quantidade;

        System.out.println("Media da turma: " + media);

        scanner.close();
    }
}