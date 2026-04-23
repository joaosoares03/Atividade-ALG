import java.util.Scanner;

public class Votacao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] votos = new int[3];

        System.out.print("Total de votos: ");
        int totalVotos = scanner.nextInt();

        for (int i = 0; i < totalVotos; i++) {
            System.out.print("Voto: ");
            int candidato = scanner.nextInt();

            if (candidato >= 1 && candidato <= 3) {
                votos[candidato - 1]++; // ajuste de índice
            } else {
                System.out.println("Voto inválido!");
                i--;
            }
        }

        for (int i = 0; i < 3; i++) {
            System.out.println("Candidato " + (i + 1) + ": " + votos[i] + " votos");
        }

        int vencedor = 0;

        for (int i = 1; i < 3; i++) {
            if (votos[i] > votos[vencedor]) {
                vencedor = i;
            }
        }

        System.out.println("Vencedor: Candidato " + (vencedor + 1));

        scanner.close();
    }
}