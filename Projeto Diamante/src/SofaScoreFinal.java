import java.util.*;
import java.util.stream.Collectors;

public class SofaScoreFinal {


    record Time(String nome, int pontos, int vitorias, int empates,
                int derrotas, int golsPro, int golsContra) {

        int saldoGols() { return golsPro - golsContra; }


        String categoria() {
            if (pontos >= 20) return "LÍDER";
            if (pontos >= 14) return "G4";
            if (pontos >= 8)  return "MEIO";
            if (pontos >= 4)  return "ALERTA";
            return "Z4";
        }
    }

    public static void main(String[] args) {
        List<Time> times = Arrays.asList(
                new Time("FLAMENGO", 9, 3, 0, 1, 9, 5),
                new Time("PALMEIRAS", 6, 2, 0, 1, 6, 4),
                new Time("SÃO PAULO", 12, 4, 0, 0, 20, 3),
                new Time("ATLETICO-MG", 5, 1, 2, 1, 3, 4),
                new Time("FLUMINENSE", 5, 1, 2, 2, 5, 7),
                new Time("CORINTHIANS", 1, 0, 1, 3, 2, 6)
        );

        executarTarefa4(times);
        executarTarefa5(times);
    }

    private static void executarTarefa4(List<Time> times) {
        System.out.println("\n--- TAREFA 4: ANÁLISE COM STREAMS ---");

        times.stream()
                .max(Comparator.comparingInt(Time::golsPro))
                .ifPresent(t -> System.out.println("Ataque mais positivo: " + t.nome() + " (" + t.golsPro() + " gols)"));

        times.stream()
                .mapToInt(Time::golsPro)
                .average()
                .ifPresent(m -> System.out.printf("Média de gols marcados por time: %.2f%n", m));

        List<String> z4 = times.stream()
                .filter(t -> t.pontos() < 4)
                .map(Time::nome)
                .collect(Collectors.toList());
        System.out.println("Times no Z4: " + z4);

        System.out.println("Ordem de Classificação (Pontos):");
        times.stream()
                .sorted(Comparator.comparingInt(Time::pontos).reversed())
                .forEach(t -> System.out.println(" - " + t.nome() + ": " + t.pontos() + " pts"));
    }

    private static void executarTarefa5(List<Time> times) {
        System.out.println("\n=== CAMPEONATO BRASILEIRO 2026 ===");
        System.out.println(String.format("%-3s | %-12s | %-3s | %-1s | %-1s | %-1s | %-3s | %-10s",
                "POS", "TIME", "PTS", "V", "E", "D", "SG", "CATEGORIA"));
        System.out.println("------------------------------------------------------------------");

        // Ajuste no Comparator: Ordenar por Pontos DESC, Vitórias DESC, Saldo DESC
        List<Time> ordenados = times.stream()
                .sorted(Comparator.comparingInt(Time::pontos)
                        .thenComparingInt(Time::vitorias)
                        .thenComparingInt(Time::saldoGols)
                        .reversed()) // O reversed aqui inverte todo o conjunto de critérios
                .collect(Collectors.toList());

        for (int i = 0; i < ordenados.size(); i++) {
            Time t = ordenados.get(i);
            String saldoFormatado = (t.saldoGols() > 0 ? "+" : "") + t.saldoGols();

            System.out.println(String.format("%-3d | %-12s | %-3d | %-1d | %-1d | %-1d | %-3s | %-10s",
                    (i + 1), t.nome(), t.pontos(), t.vitorias(), t.empates(), t.derrotas(),
                    saldoFormatado, t.categoria()));
        }
    }
}