package vendaingressos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Evento {

    // Atributos do evento
    private String nome;
    private String descricao;
    private Date data;
    private List<String> assentos;
    private boolean isAtivo;

    // Construtor para inicializar um novo evento
    public Evento(String nome, String descricao, Date data) {
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
        this.assentos = new ArrayList<>();
        this.isAtivo = true;
    }

    // Getter para o nome do evento
    public String getNome() {
        return nome;
    }

    // Getter para a descrição do evento
    public String getDescricao() {
        return descricao;
    }

    // Getter para a data do evento
    public Date getData() {
        return data;
    }

    // Verifica se o evento já ocorreu
    public boolean isEventoPassado() {
        Date agora = new Date();
        return data.before(agora);
    }

    // Adiciona um novo assento ao evento
    public void adicionarAssento(String assento) {
        if(!assentos.contains(assento)){
            assentos.add(assento);
        }
    }

    // Retorna a lista de assentos disponíveis
    public List<String> getAssentosDisponiveis() {
        return new ArrayList<>(assentos);
    }

    // Remove um assento da lista de assentos disponíveis
    public void removerAssento(String assento) {
        if(assentos.contains(assento)){
            assentos.remove(assento);
        }
    }

    // Verifica se o evento está ativo com base na data
    public boolean isAtivo() {
        if(isEventoPassado()){
            this.isAtivo = false;
            return isAtivo;
        }else {
            return true;
        }
    }
}
