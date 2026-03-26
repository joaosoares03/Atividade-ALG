import java.util.Scanner;

public class Gorjeta {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double gorjeta = 1;
        double total = 0;

        while (gorjeta != 0) {
            System.out.print("Digite a gorjeta: ");
            gorjeta = scanner.nextDouble();

            if (gorjeta != 0) {
                total += gorjeta;
            }
        }

        System.out.println("Total de gorjetas: " + total);

        scanner.close();
    }
}