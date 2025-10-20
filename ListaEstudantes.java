import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ListaEstudantes {

    private List<Estudante> estudantes;

    public ListaEstudantes() {
        this.estudantes = new ArrayList<>();
    }

    public void adicionarEstudante(Estudante e) {
        this.estudantes.add(e);
    }

    public boolean removerEstudantePorId(int id) {
        return this.estudantes.removeIf(e -> e.getId() == id);
    }

    public Estudante obterEstudantePorIndice(int indice) {
        if (indice >= 0 && indice < estudantes.size()) {
            return this.estudantes.get(indice);
        }
        return null;
    }

    public List<Estudante> buscarEstudantesPorNome(String substring) {
        return this.estudantes.stream()
                .filter(e -> e.getNome().toLowerCase().contains(substring.toLowerCase()))
                .collect(Collectors.toList());
    }

    public void ordenarEstudantesPorNome() {

        Collections.sort(this.estudantes);
    }

    public List<Estudante> getEstudantes() {
        return Collections.unmodifiableList(this.estudantes);
    }
}