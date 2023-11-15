

import java.util.ArrayList;

public class Usuario{
    private String nome;
    private String email;
    private String senha;
    private ArrayList<Propriedade> propriedades =  new ArrayList<Propriedade>();
    private ArrayList<Reserva> reservas =  new ArrayList<Reserva>();
    private ArrayList<Avaliacao> avaliacoes =  new ArrayList<Avaliacao>();

    public Usuario(String nome, String email, String senha){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    public String getNome(){
        return nome;
    }

    public String getEmail(){
        return email;
    }

    public String getSenha(){
        return senha;
    }
    
    public ArrayList<Propriedade> getPropriedades(){
        return propriedades;
    }
    
    public ArrayList<Reserva> getReservas(){
        return reservas;
    }
    
    public ArrayList<Avaliacao> getAvaliacoes(){
        return avaliacoes;
    }

    public void adicionaPropriedade(Propriedade p){
        propriedades.add(p);
    }

    public void adicionaReserva(Reserva r){
        reservas.add(r);
    }

    public void adicionaAvaliacao(Avaliacao a){
        avaliacoes.add(a);
    }
}