package vendaingressos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Usuario {
    // Atributos do usuário
    public String login; // Nome de usuário para login
    public String senha; // Senha do usuário
    public String nome; // Nome completo do usuário
    public String cpf; // CPF do usuário
    public String email; // Email do usuário
    public boolean isAdmin; // Indica se o usuário é um administrador
    private List<Ingresso> ingressos; // Lista de ingressos comprados pelo usuário

    // Construtor para inicializar um novo usuário
    public Usuario(String login, String senha, String nome, String cpf, String email, boolean isAdmin){
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.isAdmin = isAdmin;
        this.ingressos = new ArrayList<>();
    }

    // Getter para o login do usuário
    public String getLogin() {
        return this.login;
    }

    // Getter para o nome do usuário
    public String getNome() {
        return this.nome;
    }

    // Getter para o CPF do usuário
    public String getCpf() {
        return this.cpf;
    }

    // Getter para o email do usuário
    public String getEmail() {
        return this.email;
    }

    // Verifica se o usuário é um administrador
    public boolean isAdmin() {
        return this.isAdmin;
    }

    // Método para realizar o login do usuário, verifica se as credenciais estão corretas
    public boolean login(String login, String senha) {
        return login.equals(this.login) && senha.equals(this.senha);
    }

    // Setter para atualizar a senha do usuário
    public void setSenha(String novaSenha) {
        this.senha = novaSenha;
    }

    // Setter para atualizar o nome do usuário
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Setter para atualizar o CPF do usuário
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    // Setter para atualizar o email do usuário
    public void setEmail(String email) {
        this.email = email;
    }

    // Método para comparar se dois usuários são iguais com base no login
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Usuario usuario = (Usuario) o;
        return Objects.equals(login, usuario.login);
    }

    // Gera um código hash para o usuário baseado no login
    public int hashCode() {
        return Objects.hash(login);
    }

    // Getter para a lista de ingressos do usuário
    public List<Ingresso> getIngressos() {
        return ingressos;
    }

    // Adiciona um ingresso à lista de ingressos do usuário
    public void adicionarIngresso(Ingresso ingresso){
        ingressos.add(ingresso);
    }

    // Remove um ingresso da lista de ingressos do usuário
    public void removerIngresso(Ingresso ingresso){
        ingressos.remove(ingresso);
    }
}
