
import java.util.ArrayList;

public class Propriedade {
    private String titulo;
    private String descricao;
    private String localizacao;
    private int capacidade;
    private double precoNoite;
    private String fotos;
    private Usuario proprietario;
    private ArrayList<Avaliacao> avaliacoes =  new ArrayList<Avaliacao>();

    public Propriedade(String titulo, String descricao, String localizacao, int capacidade, double precoNoite, Usuario proprietario){
        this.titulo = titulo;
        this.descricao = descricao;
        this.localizacao = localizacao;
        this.capacidade = capacidade;
        this.precoNoite = precoNoite;
        this.proprietario = proprietario;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getDescricao(){
        return descricao;
    }

    public String getLocalizacao(){
        return localizacao;
    }

    public int getCapacidade(){
        return capacidade;
    }

    public double getPrecoNoite(){
        return precoNoite;
    }

    public String getFotos(){
        return fotos;
    }

    public Usuario getProprietario(){
        return proprietario;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public void setLocalizacao(String localizacao){
        this.localizacao = localizacao;
    }

    public void setCapacidade(int capacidade){
        this.capacidade = capacidade;
    }

    public void setPrecoNoite(double precoNoite){
        this.precoNoite = precoNoite;
    }

    public void setFotos(String fotos){
        this.fotos = fotos;
    }

    public void setProprietario(Usuario proprietario){
        this.proprietario = proprietario;
    }

    public void adicionaAvaliacao(Avaliacao a){
        avaliacoes.add(a);
    }
    
}

