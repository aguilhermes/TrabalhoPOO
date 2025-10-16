public class Estudante implements Comparable<Estudante> {
    private int id;
    private String nome;

    public Estudante(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome;
    }

    @Override
    public int compareTo(Estudante outro) {
        return this.nome.compareTo(outro.getNome());
    }
}