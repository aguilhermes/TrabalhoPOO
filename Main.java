import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ListaEstudantes listaEstudantes = new ListaEstudantes();
        CadastroDisciplinas cadastroDisciplinas = new CadastroDisciplinas();
        HistoricoNotas historicoNotas = new HistoricoNotas();

        carregarDados(listaEstudantes, cadastroDisciplinas, historicoNotas);

        System.out.println("== Lista de Estudantes (ordenada) ==");
        listaEstudantes.ordenarEstudantesPorNome(); //
        listaEstudantes.getEstudantes().forEach(System.out::println);
        System.out.println();

        System.out.println("== Disciplinas (ordem de inserção) ==");
        cadastroDisciplinas.obterTodasDisciplinas().forEach(System.out::println);
        System.out.println();

        System.out.println("== Duplicatas detectadas na importação ==");
        List<Disciplina> duplicatas = cadastroDisciplinas.getDuplicatasDetectadas();
        if (duplicatas.isEmpty()) {
            System.out.println("(nenhuma)");
        } else {
            duplicatas.forEach(System.out::println);
        }
        System.out.println();

        System.out.println("== Matrículas e Médias dos Alunos ==");
        for (Estudante estudante : listaEstudantes.getEstudantes()) {
            List<Matricula> matriculas = historicoNotas.obterMatriculas(estudante.getId());
            double media = historicoNotas.mediaDoEstudante(estudante.getId());

            String matriculasStr = matriculas.stream()
                    .map(m -> m.getCodigoDisciplina() + "(" + m.getNota() + ")")
                    .collect(Collectors.joining(", "));

            System.out.printf("%s: [%s] Média: %.2f\n", estudante.getNome(), matriculasStr, media);
        }
        System.out.println();

        System.out.println("== Médias por Disciplina ==");
        for (Disciplina disciplina : cadastroDisciplinas.obterTodasDisciplinas()) {
            double media = historicoNotas.mediaDaDisciplina(disciplina.getCodigo());
            System.out.printf("%s (%s): Média %.2f\n", disciplina.getNome(), disciplina.getCodigo(), media);
        }
        System.out.println();

        System.out.println("== Top 3 Alunos por Média ==");
        List<Estudante> top3 = historicoNotas.topNEstudantesPorMedia(3, listaEstudantes);
        int rank = 1;
        for (Estudante estudante : top3) {
            System.out.printf("%d) %s - Média: %.2f\n",
                    rank++, estudante.getNome(), historicoNotas.mediaDoEstudante(estudante.getId()));
        }
        System.out.println();

        System.out.println("== Alunos com média >= 8.0 ==");
        listaEstudantes.getEstudantes().stream()
                .filter(e -> historicoNotas.mediaDoEstudante(e.getId()) >= 8.0)
                .forEach(e -> System.out.println(e.getNome()));
        System.out.println();

        System.out.println("== Disciplinas com média < 6.0 ==");
        List<Disciplina> disciplinasReprovadas = cadastroDisciplinas.obterTodasDisciplinas().stream()
                .filter(d -> {
                    double media = historicoNotas.mediaDaDisciplina(d.getCodigo());
                    return media > 0 && media < 6.0;
                })
                .collect(Collectors.toList());

        if (disciplinasReprovadas.isEmpty()) {
            System.out.println("(nenhuma)");
        } else {
            disciplinasReprovadas.forEach(d -> System.out.printf("%s - Média: %.2f\n",
                    d.getNome(), historicoNotas.mediaDaDisciplina(d.getCodigo())));
        }
    }

    private static void carregarDados(ListaEstudantes le, CadastroDisciplinas cd, HistoricoNotas hn) {

        le.adicionarEstudante(new Estudante(1, "Julia"));
        le.adicionarEstudante(new Estudante(2, "Octavio"));
        le.adicionarEstudante(new Estudante(3, "Maria"));
        le.adicionarEstudante(new Estudante(4, "Guilherme"));
        le.adicionarEstudante(new Estudante(5, "Elisa"));

        cd.adicionarDisciplina(new Disciplina("MAT101", "Matemática"));
        cd.adicionarDisciplina(new Disciplina("PRG201", "Programação"));
        cd.adicionarDisciplina(new Disciplina("BD301", "Banco de Dados"));
        cd.adicionarDisciplina(new Disciplina("EDF110", "Educação Física"));

        cd.adicionarDisciplina(new Disciplina("PRG201", "Programação II"));

        hn.adicionarMatricula(1, "MAT101", 8.5);
        hn.adicionarMatricula(1, "PRG201", 9.0);
        hn.adicionarMatricula(2, "PRG201", 7.0);
        hn.adicionarMatricula(3, "BD301", 6.5);
        hn.adicionarMatricula(4, "PRG201", 8.0);
        hn.adicionarMatricula(5, "EDF110", 10.0);

        hn.adicionarMatricula(2, "MAT101", 5.0);
        hn.adicionarMatricula(3, "MAT101", 7.5);
    }
}