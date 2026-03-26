import java.util.Scanner;

public class Senhas {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String senhaCorreta = "03032005";
        String senhaDigitada;
        int tentativas = 0;

        while (tentativas < 3) {
            System.out.print("Digite a senha: ");
            senhaDigitada = scanner.next();

            if (senhaDigitada.equals(senhaCorreta)) {
                System.out.println("Acesso permitido");
                break;
            }

            tentativas++;
        }

        if (tentativas == 3) {
            System.out.println("Acesso bloqueado");
        }

        scanner.close();
    }
}