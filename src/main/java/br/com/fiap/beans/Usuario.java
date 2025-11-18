package br.com.fiap.beans;

public class Usuario {

    private String nome;
    private String sobrenome;
    private int idade;
    private String curso;
    private String email;
    private String senha;

    public Usuario() {

    }

    public Usuario(String nome, String sobrenome, int idade, String curso, String email, String senha) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.curso = curso;
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario" +
                "nome=" + nome +
                ", sobrenome=" + sobrenome +
                ", idade=" + idade +
                ", curso=" + curso +
                ", email=" + email +
                ", senha=" + senha;
    }
}







