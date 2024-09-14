package vendaingressos;

public class Ingresso {
    // Atributos do ingresso
    public Evento evento; // Evento associado ao ingresso
    public double preco; // Preço do ingresso
    public String assento; // Assento reservado
    public boolean ativo; // Estado do ingresso (ativo ou não)

    // Construtor para inicializar um novo ingresso
    public Ingresso(Evento evento, double preco, String assento) {
        this.evento = evento;
        this.preco = preco;
        this.assento = assento;
        this.ativo = true; // Inicialmente o ingresso está ativo
    }

    // Getter para o evento associado ao ingresso
    public Evento getEvento() {
        return this.evento;
    }

    // Getter para o preço do ingresso
    public double getPreco() {
        return this.preco;
    }

    // Getter para o assento reservado
    public String getAssento() {
        return this.assento;
    }

    // Getter para verificar se o ingresso está ativo
    public boolean isAtivo() {
        return this.ativo;
    }

    // Setter para definir o estado do ingresso (ativo ou não)
    public void setAtivo(boolean value){
        this.ativo = value;
    }

    // Método para cancelar o ingresso se o evento não tiver passado
    public boolean cancelar() {
        if (evento.isEventoPassado()) {
            return false; // Não pode cancelar se o evento já ocorreu
        }

        this.ativo = false;
        return true;
    }

    // Método para reativar o ingresso se o evento não tiver passado
    public void reativar() {
        if (!this.ativo && !evento.isEventoPassado()) {
            this.ativo = true;
        }
    }

    // Comparação para verificar se dois ingressos são iguais com base no assento
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }
        Ingresso ingresso = (Ingresso) obj;
        return assento.equals(ingresso.assento);
    }

    // Código hash para o ingresso, baseado no assento
    public int hashCode(){
        return assento.hashCode();
    }
}
