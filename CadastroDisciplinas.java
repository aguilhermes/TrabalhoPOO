import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class CadastroDisciplinas {
    private Set<Disciplina> disciplinas;
    private List<Disciplina> duplicatasDetectadas;

    public CadastroDisciplinas() {
        this.disciplinas = new LinkedHashSet<>();
        this.duplicatasDetectadas = new ArrayList<>();
    }

    public void adicionarDisciplina(Disciplina d) {
        if (!this.disciplinas.add(d)) {
            duplicatasDetectadas.add(d);
        }
    }

    public boolean verificarDisciplina(String codigo) {
        return this.disciplinas.stream().anyMatch(d -> d.getCodigo().equals(codigo));
    }

    public boolean removerDisciplina(String codigo) {
        return this.disciplinas.removeIf(d -> d.getCodigo().equals(codigo));
    }

    public Set<Disciplina> obterTodasDisciplinas() {
        return Collections.unmodifiableSet(this.disciplinas);
    }

    public List<Disciplina> getDuplicatasDetectadas() {
        return Collections.unmodifiableList(this.duplicatasDetectadas);
    }
}