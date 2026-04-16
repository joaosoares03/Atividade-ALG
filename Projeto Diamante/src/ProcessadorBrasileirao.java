public class ProcessadorBrasileirao {

    public static void main(String[] args) {
        String[] partidas = {
                "Flamengo:3:1:Palmeiras",
                "Corinthians:0:0:São Paulo",
                "Atletico-MG:2:2:Fluminense",
                "Palmeiras:1:0:Corinthians",
                "São Paulo:3:2:Flamengo",
                "Fluminense:0:1:Atletico-MG",
                "Flamengo:2:0:Corinthians",
                "Palmeiras:4:1:Fluminense",
                "São Paulo:0:0:Atletico-MG",
                "Corinthians:1:3:Fluminense",
                "Atletico-MG:0:2:Flamengo",
                "Fluminense:1:1:São Paulo"
        };

        System.out.println("--- INICIANDO PARSING DAS PARTIDAS ---");

        // Percorrendo todas as partidas usando um laço for
        for (int i = 0; i < partidas.length; i++) {
            parsearPartida(partidas[i]);
        }
    }

    /**
     * TAREFA 1: Realiza o parsing e a normalização dos dados.
     */
    public static void parsearPartida(String linha) {
        try {
            // Requisito: Use split() para separar os campos
            String[] campos = linha.split(":");

            // Validação de campos ausentes
            if (campos.length != 4) {
                System.out.println("[ERRO] Linha inválida: " + linha);
                return;
            }

            // Requisito: Normalização com trim() e toUpperCase()
            String timeCasa = campos[0].trim().toUpperCase();
            String golsCasaStr = campos[1].trim();
            String golsForaStr = campos[2].trim();
            String timeFora = campos[3].trim().toUpperCase();

            // Validação de integridade (conferindo se os gols são números)
            int golsCasa = Integer.parseInt(golsCasaStr);
            int golsFora = Integer.parseInt(golsForaStr);

            // Se chegou aqui, os dados estão válidos
            System.out.printf("Processado: %s %d x %d %s%n",
                    timeCasa, golsCasa, golsFora, timeFora);

        } catch (Exception e) {
            // Requisito: Captura erros de formato (ex: letras onde deveriam ser números)
            System.out.println("[ERRO] Linha inválida: " + linha);
        }
    }
}