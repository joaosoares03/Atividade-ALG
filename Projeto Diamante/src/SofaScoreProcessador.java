import java.util.*;

public class SofaScoreProcessador {

    // Estrutura para armazenar o desempenho (Pode ser uma classe ou Map)
    static Map<String, int[]> estatisticas = new HashMap<>();
    // Índices do array: 0: Pontos, 1: Vitórias, 2: Empates, 3: Derrotas, 4: Saldo

    public static void main(String[] args) {
        String[] partidas = {
                "Flamengo:3:1:Palmeiras", "Corinthians:0:3:São Paulo",
                "Atletico-MG:2:2:Fluminense", "Palmeiras:1:0:Corinthians",
                "São Paulo:3:2:Flamengo", "Fluminense:0:1:Atletico-MG",
                "Flamengo:2:2:Corinthians", "Palmeiras:4:1:Fluminense",
                "São Paulo:3:0:Atletico-MG", "Corinthians:1:3:Fluminense",
                "Atletico-MG:0:2:Flamengo", "Fluminense:1:5:São Paulo"
        };

        // TAREFA 1 & 2: Processamento
        for (String linha : partidas) {
            processarRodada(linha);
        }

        // TAREFA 2: Exibição usando laço WHILE
        exibirTabelaIncremental();
    }

    public static void processarRodada(String linha) {
        String[] dados = linha.split(":");

        // Validação básica
        if (dados.length != 4) return;

        String casa = dados[0].trim().toUpperCase();
        int gCasa = Integer.parseInt(dados[1].trim());
        int gFora = Integer.parseInt(dados[2].trim());
        String fora = dados[3].trim().toUpperCase();

        // Inicializa times no mapa se novos
        estatisticas.putIfAbsent(casa, new int[5]);
        estatisticas.putIfAbsent(fora, new int[5]);

        int[] statusCasa = estatisticas.get(casa);
        int[] statusFora = estatisticas.get(fora);

        // Atualização de Saldo de Gols (Índice 4)
        statusCasa[4] += (gCasa - gFora);
        statusFora[4] += (gFora - gCasa);

        // --- LÓGICA DE PONTUAÇÃO (REQUISITO IF/ELSE) ---
        if (gCasa > gFora) {
            // Vitória Casa
            statusCasa[0] += 3; // Pontos
            statusCasa[1] += 1; // Vitórias
            statusFora[3] += 1; // Derrotas Fora
        }
        else if (gCasa < gFora) {
            // Vitória Fora
            statusFora[0] += 3;
            statusFora[1] += 1;
            statusCasa[3] += 1;
        }
        else {
            // Empate
            statusCasa[0] += 1;
            statusFora[0] += 1;
            statusCasa[2] += 1;
            statusFora[2] += 1;
        }
    }

    public static void exibirTabelaIncremental() {
        System.out.println("\n=== ATUALIZAÇÃO DE DESEMPENHO (WHILE LOOP) ===");
        System.out.printf("%-15s | %-3s | %-2s | %-2s | %-2s | %-3s%n", "TIME", "P", "V", "E", "D", "SG");

        Iterator<Map.Entry<String, int[]>> it = estatisticas.entrySet().iterator();

        // REQUISITO: Uso de laço WHILE para percorrer os dados processados
        while (it.hasNext()) {
            Map.Entry<String, int[]> entrada = it.next();
            String nome = entrada.getKey();
            int[] s = entrada.getValue();

            System.out.printf("%-15s | %-3d | %-2d | %-2d | %-2d | %-3d%n",
                    nome, s[0], s[1], s[2], s[3], s[4]);
        }
    }
}