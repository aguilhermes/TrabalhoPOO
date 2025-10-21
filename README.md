# Sistema de Gerenciamento Escolar (Trabalho de POO)
Participantes: Antonio Guilherme Santos da Silva, Octavio Alves Freire.

Este projeto é uma solução para um trabalho acadêmico da disciplina de Programação Orientada a Objetos (POO). O objetivo é simular um sistema de controle de estudantes, disciplinas e notas para uma escola, aplicando de forma prática as **Java Collections Framework (List, Set e Map)**.

O sistema carrega um conjunto de dados de exemplo e, a partir deles, gera diversos relatórios no console sobre o desempenho dos alunos e das disciplinas.

## 🚀 Funcionalidades

O programa é dividido em módulos de gerenciamento, cada um focado em uma Collection específica:

* **Gerenciamento de Estudantes (List)**
    * Permite adicionar, remover, buscar e ordenar a lista de estudantes.
    * A ordenação é feita alfabeticamente pelo nome do aluno.

* **Gerenciamento de Disciplinas (Set)**
    * Garante que cada disciplina seja única (baseado no seu código), evitando duplicatas.
    * Mantém a ordem de inserção das disciplinas (utilizando `LinkedHashSet`).
    * Detecta e armazena tentativas de inserção de disciplinas duplicadas.

* **Controle de Notas e Matrículas (Map)**
    * Associa o ID de um estudante a uma lista de suas matrículas e respectivas notas.
    * Permite o cálculo de médias individuais por aluno e médias gerais por disciplina.

* **Geração de Relatórios**
    O programa principal (`Main.java`) executa e exibe os seguintes relatórios:
    1.  Lista de todos os estudantes, ordenados por nome.
    2.  Lista de todas as disciplinas, na ordem em que foram cadastradas.
    3.  Relatório de disciplinas duplicadas que foram ignoradas durante a importação.
    4.  Boletim individual de cada aluno, com suas notas e média final.
    5.  Média de desempenho geral para cada disciplina.
    6.  Ranking dos 3 melhores alunos (Top 3) por média.
    7.  Lista de alunos aprovados (média $\ge 8.0$).
    8.  Lista de disciplinas com baixo desempenho (média $< 6.0$).

## 🛠️ Tecnologias Utilizadas

* **Java 11 (ou superior)**
* **Java Collections Framework:**
    * `java.util.List` (implementado com `ArrayList`)
    * `java.util.Set` (implementado com `LinkedHashSet`)
    * `java.util.Map` (implementado com `HashMap`)
* **Java Streams API** (para cálculos de médias e filtros)

## 📁 Estrutura do Projeto

O projeto é composto por 7 arquivos `.java`:

1.  **Classes de Modelo (POJO):**
    * `Estudante.java`: Representa o aluno (id, nome).
    * `Disciplina.java`: Representa a disciplina (código, nome).
    * `Matricula.java`: Representa a nota de um aluno em uma disciplina.
2.  **Classes de Gerenciamento (Collections):**
    * `ListaEstudantes.java`: (Parte A) Gerencia os alunos usando `List`.
    * `CadastroDisciplinas.java`: (Parte B) Gerencia as disciplinas usando `Set`.
    * `HistoricoNotas.java`: (Parte C) Gerencia as notas usando `Map`.
3.  **Classe Principal:**
    * `Main.java`: (Parte D) Programa executável que carrega os dados e gera os relatórios no console.

## ▶️ Como Executar

### Pré-requisitos
* Java Development Kit (JDK) 11 ou superior instalado e configurado no `PATH`.

### Execução via Terminal

1.  Clone este repositório ou baixe e coloque todos os 7 arquivos `.java` em um mesmo diretório.
2.  Abra um terminal nesse diretório.
3.  Compile todos os arquivos Java:
    ```bash
    javac *.java
    ```
4.  Execute o programa principal:
    ```bash
    java Main
    ```

### Execução via IDE

1.  Abra o diretório como um novo projeto em sua IDE favorita (VS Code, IntelliJ, Eclipse, etc.).
2.  Localize o arquivo `Main.java`.
3.  Clique com o botão direito e selecione "Run" (Executar).

## 📋 Saída

A execução do programa `Main` irá gerar a seguinte saída no console (baseado nos dados de `carregarDados`):
== Lista de Estudantes (ordenada) == ID: 5, Nome: Elisa ID: 4, Nome: Guilherme ID: 1, Nome: Julia ID: 3, Nome: Maria ID: 2, Nome: Octavio

== Disciplinas (ordem de inserção) == Código: MAT101, Nome: Matemática Código: PRG201, Nome: Programação Código: BD301, Nome: Banco de Dados Código: EDF110, Nome: Educação Física

== Duplicatas detectadas na importação == Código: PRG201, Nome: Programação II

== Matrículas e Médias dos Alunos == Elisa: [EDF110(10.0)] Média: 10,00 Guilherme: [PRG201(8.0)] Média: 8,00 Julia: [MAT101(8.5), PRG201(9.0)] Média: 8,75 Maria: [BD301(6.5), MAT101(7.5)] Média: 7,00 Octavio: [PRG201(7.0), MAT101(5.0)] Média: 6,00

== Médias por Disciplina == Matemática (MAT101): Média 7,00 Programação (PRG201): Média 8,00 Banco de Dados (BD301): Média 6,50 Educação Física (EDF110): Média 10,00

== Top 3 Alunos por Média ==

Elisa - Média: 10,00

Julia - Média: 8,75

Guilherme - Média: 8,00

== Alunos com média >= 8.0 == Elisa Guilherme Julia

== Disciplinas com média < 6.0 == (nenhuma)
