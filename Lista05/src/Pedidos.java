import java.util.Scanner;

public class Pedidos {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double valor;
        double total = 0;
        int quantidade = 0;

        while (true) {
            System.out.print("Valor: ");
            valor = scanner.nextDouble();

            if (valor == 0) {
                break;
            }

            if (valor < 0) {
                continue;
            }

            total += valor;
            quantidade++;
        }

        if (quantidade > 0) {
            System.out.println("Total vendido: " + total);
            System.out.println("Quantidade de pedidos: " + quantidade);
        } else {
            System.out.println("Nenhum pedido válido registrado");
        }

        scanner.close();
    }
}