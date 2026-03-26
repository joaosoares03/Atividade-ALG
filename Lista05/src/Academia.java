import java.util.Scanner;

public class Academia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int permitidos = 0;
        int negados = 0;
        int idade;

        System.out.print("Idade: ");
        idade = scanner.nextInt();

        while (idade != -1) {
            if (idade >= 16) {
                permitidos++;
            } else {
                negados++;
            }

            System.out.print("Idade: ");
            idade = scanner.nextInt();
        }

        System.out.println("Acessos permitidos: " + permitidos);
        System.out.println("Acessos negados: " + negados);

        scanner.close();
    }
}