import java.util.Scanner;

public class Sensor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Numero de leituras: ");
        int n = scanner.nextInt();

        double[] temperaturas = new double[n];
        int validas = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Temperatura: ");
            double temp = scanner.nextDouble();

            if (temp == 999) {
                break;
            }

            if (temp < -50 || temp > 50) {
                continue;
            }

            temperaturas[validas] = temp;
            validas++;
        }

        if (validas == 0) {
            System.out.println("Nenhuma leitura valida registrada");
        } else {
            double soma = 0;
            for (int i = 0; i < validas; i++) {
                soma += temperaturas[i];
            }

            double media = soma / validas;

            int acima = 0;
            for (int i = 0; i < validas; i++) {
                if (temperaturas[i] > media) {
                    acima++;
                }
            }

            System.out.println("Media das leituras validas: " + media);
            System.out.println("Leituras acima da media: " + acima);
        }

        scanner.close();
    }
}