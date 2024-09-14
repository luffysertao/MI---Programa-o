package vendaingressos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Controller {
    // Lista de usuários cadastrados
    public List<Usuario> usuarios = new ArrayList<>();

    // Lista de eventos disponíveis
    public List<Evento> eventos = new ArrayList<>();

    // Lista de ingressos comprados
    public List<Ingresso> ingressosComprados = new ArrayList<>();

    // Método para cadastrar um novo usuário
    public Usuario cadastrarUsuario(String login, String senha, String adminUser, String number, String email, boolean valido) {
        Usuario admin = new Usuario(login, senha, adminUser, number, email, valido);
        usuarios.add(admin);
        return admin;
    }

    // Método para cadastrar um novo evento, apenas para administradores
    public Evento cadastrarEvento(Usuario admin, String nome, String descricao, Date data) {
        if(admin.getLogin().equals("admin")){
            Evento evento = new Evento(nome, descricao, data);
            eventos.add(evento);
            return evento;
        }else{
            throw new SecurityException("Somente administradores podem cadastrar eventos.");
        }
    }

    // Método para adicionar um assento a um evento específico
    public void adicionarAssentoEvento(String show, String assento) {
        for(Evento evento : eventos){
            if (evento.getNome().equals(show)){
                evento.adicionarAssento(assento);
            }
        }
    }

    // Método para comprar um ingresso para um evento específico
    public Ingresso comprarIngresso(Usuario usuario, String nomeEvento, String assento){
        for(Evento evento : eventos){
            if (evento.getNome().equals(nomeEvento)){
                if(evento.getAssentosDisponiveis().contains(assento)){
                    Ingresso ingresso = new Ingresso(evento, 100 ,assento);
                    usuario.adicionarIngresso(ingresso);
                    evento.removerAssento(assento);
                    ingressosComprados.add(ingresso);
                    return ingresso;
                }else{
                    throw new IllegalArgumentException("Assento não disponível");
                }
            }
        }
        throw new IllegalArgumentException("Evento não encontrado");
    }

    // Método para cancelar a compra de um ingresso
    public boolean cancelarCompra(Usuario usuario, Ingresso ingresso) {
        usuario.removerIngresso(ingresso);
        ingresso.setAtivo(false);
        return true;
    }

    // Método para listar todos os eventos disponíveis
    public List<Evento> listarEventosDisponiveis() {
        return eventos;
    }

    // Método para listar todos os ingressos comprados por um usuário
    public List<Ingresso> listarIngressosComprados(Usuario usuario) {
        return ingressosComprados;
    }
}
