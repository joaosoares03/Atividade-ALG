import java.util.Scanner;

public class Placar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantidade de participantes: ");
        int quantidade = scanner.nextInt();

        int[] placares = new int[quantidade];

        for (int i = 0; i < quantidade; i++) {
            System.out.print("Placar " + (i + 1) + ": ");
            placares[i] = scanner.nextInt();
        }

        int maior = placares[0];
        int menor = placares[0];

        for (int i = 1; i < quantidade; i++) {
            if (placares[i] > maior) {
                maior = placares[i];
            }

            if (placares[i] < menor) {
                menor = placares[i];
            }
        }

        System.out.println("Maior placar: " + maior);
        System.out.println("Menor placar: " + menor);

        scanner.close();
    }
}