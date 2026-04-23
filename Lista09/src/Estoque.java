import java.util.Scanner;

public class Estoque {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantidade de produtos: ");
        int quantidade = scanner.nextInt();

        int[] estoque = new int[quantidade];

        for (int i = 0; i < quantidade; i++) {
            System.out.print("Estoque produto " + (i + 1) + ": ");
            estoque[i] = scanner.nextInt();
        }

        int contador = 0;

        for (int i = 0; i < quantidade; i++) {
            if (estoque[i] < 5) {
                contador++;
            }
        }

        System.out.println("Produtos com estoque baixo: " + contador);

        scanner.close();
    }
}