import java.util.Scanner;

public class Lanchonete {

    public static double calcularTotal(double preco, int quantidade) {
        return preco * quantidade;
    }

    public static double calcularDesconto(double total, int pagamento) {

        if (pagamento == 1) { // dinheiro
            return total * 0.90;
        }
        else if (pagamento == 3) { // pix
            return total * 0.95;
        }
        else {
            return total;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int produto, quantidade, pagamento;
        double preco = 0;
        String nomeProduto = "", formaPagamento = "";

        System.out.print("Digite o código do produto: ");
        produto = sc.nextInt();

        switch (produto) {
            case 1:
                nomeProduto = "Hamburguer";
                preco = 18;
                break;
            case 2:
                nomeProduto = "Pizza";
                preco = 25;
                break;
            case 3:
                nomeProduto = "Batata frita";
                preco = 12;
                break;
            case 4:
                nomeProduto = "Refrigerante";
                preco = 8;
                break;
            case 5:
                nomeProduto = "Milkshake";
                preco = 15;
                break;
            default:
                System.out.println("Produto inválido");
                return;
        }

        System.out.print("Quantidade: ");
        quantidade = sc.nextInt();

        double total = calcularTotal(preco, quantidade);

        System.out.print("Forma de pagamento (1-Dinheiro 2-Cartão 3-Pix): ");
        pagamento = sc.nextInt();

        switch (pagamento) {
            case 1:
                formaPagamento = "Dinheiro";
                break;
            case 2:
                formaPagamento = "Cartao";
                break;
            case 3:
                formaPagamento = "Pix";
                break;
        }

        double totalComDesconto = calcularDesconto(total, pagamento);

        double taxaEntrega = 0;
        if (totalComDesconto < 40) {
            taxaEntrega = 8;
        }

        double valorFinal = totalComDesconto + taxaEntrega;

        System.out.println("\nResumo do pedido");
        System.out.println("Produto: " + nomeProduto);
        System.out.println("Quantidade: " + quantidade);
        System.out.println("Valor unitário: " + preco);
        System.out.println("Total do pedido: " + total);
        System.out.println("Pagamento: " + formaPagamento);
        System.out.println("Total com desconto: " + totalComDesconto);
        System.out.println("Taxa de entrega: " + taxaEntrega);
        System.out.println("Valor final: " + valorFinal);
    }
}