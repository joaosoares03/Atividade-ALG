import java.util.Scanner;

public class Atendimento {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nota = -1;
        int soma = 0;
        int quantidade = 0;

        while (nota != 0) {
            System.out.print("Nota: ");
            nota = scanner.nextInt();

            if (nota >= 1 && nota <= 5) {
                soma += nota;
                quantidade++;
            }
        }

        if (quantidade > 0) {
            double media = (double) soma / quantidade;
            System.out.println("Média das avaliações: " + media);
        } else {
            System.out.println("Nenhuma avaliação registrada");
        }

        scanner.close();
    }
}