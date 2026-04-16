public class RelatorioSofaScore {

    public static void main(String[] args) {
        // ... (Considerando que os pontos já foram calculados na Tarefa 2)

        // Exemplo de mapa de resultados após processamento:
        // Flamengo: 9, Palmeiras: 6, Atletico-MG: 5, São Paulo: 5, Fluminense: 5, Corinthians: 1

        System.out.println("\n===== RELATÓRIO DE CATEGORIAS - BRASILEIRÃO 2026 =====");

        // Simulando a iteração sobre os times processados
        exibirCategoria("FLAMENGO", 9);
        exibirCategoria("PALMEIRAS", 6);
        exibirCategoria("SÃO PAULO", 5);
        exibirCategoria("ATLETICO-MG", 5);
        exibirCategoria("FLUMINENSE", 5);
        exibirCategoria("CORINTHIANS", 1);
    }

    /**
     * TAREFA 3: Classifica o time usando Switch Expression
     */
    public static void exibirCategoria(String nomeTime, int pontos) {
        // Determinamos a faixa para o switch
        String categoria;

        // Requisito obrigatório: Use switch para mapear a faixa de pontos
        // Como o switch padrão não aceita "pontos >= 20", usamos uma lógica de suporte
        categoria = switch (pontos) {
            case 20, 21, 22, 23, 24, 25 -> "LÍDER"; // Considerando um teto hipotético
            case 14, 15, 16, 17, 18, 19 -> "G4 - ZONA DE CLASSIFICAÇÃO";
            case 8, 9, 10, 11, 12, 13   -> "MEIO DE TABELA";
            case 4, 5, 6, 7             -> "ALERTA";
            case 0, 1, 2, 3             -> "REBAIXAMENTO";
            default -> (pontos > 25) ? "LÍDER" : "DESCONHECIDO";
        };

        System.out.printf("Time: %-12s | Pontos: %-2d | Status: %s%n",
                nomeTime, pontos, categoria);
    }
}