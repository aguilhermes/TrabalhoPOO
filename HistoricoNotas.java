import java.util.*;
import java.util.stream.Collectors;

public class HistoricoNotas {

    private Map<Integer, List<Matricula>> historico;

    public HistoricoNotas() {
        this.historico = new HashMap<>();
    }

    public void adicionarMatricula(int idEstudante, String codigoDisciplina, double nota) {
        Matricula novaMatricula = new Matricula(codigoDisciplina, nota);
        historico.computeIfAbsent(idEstudante, k -> new ArrayList<>()).add(novaMatricula);
    }

    public List<Matricula> obterMatriculas(int idEstudante) {
        return historico.getOrDefault(idEstudante, Collections.emptyList());
    }

    public Optional<Double> obterNota(int idEstudante, String codigoDisciplina) {
        return obterMatriculas(idEstudante).stream()
                .filter(m -> m.getCodigoDisciplina().equals(codigoDisciplina))
                .map(Matricula::getNota)
                .findFirst();
    }

    public boolean removerMatricula(int idEstudante, String codigoDisciplina) {
        if (historico.containsKey(idEstudante)) {
            return historico.get(idEstudante).removeIf(m -> m.getCodigoDisciplina().equals(codigoDisciplina));
        }
        return false;
    }

    public double mediaDoEstudante(int idEstudante) {
        List<Matricula> matriculas = obterMatriculas(idEstudante);
        if (matriculas.isEmpty()) {
            return 0.0;
        }
        return matriculas.stream()
                .mapToDouble(Matricula::getNota)
                .average()
                .orElse(0.0);
    }

    public double mediaDaDisciplina(String codigoDisciplina) {
        return historico.values().stream()
                .flatMap(List::stream)
                .filter(m -> m.getCodigoDisciplina().equals(codigoDisciplina))
                .mapToDouble(Matricula::getNota)
                .average()
                .orElse(0.0);
    }

    public List<Estudante> topNEstudantesPorMedia(int n, ListaEstudantes listaEstudantes) {
        return listaEstudantes.getEstudantes().stream()
                .sorted(Comparator.comparingDouble(e -> mediaDoEstudante(((Estudante) e).getId())).reversed())
                .collect(Collectors.toList());
    }
}