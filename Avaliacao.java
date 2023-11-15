

public class Avaliacao {
    private Propriedade propriedade;
    private Usuario usuario;
    private int pontuacao;
    private String comentario;

    public Avaliacao(Propriedade propriedade, Usuario usuario, int pontuacao, String comentario){
        this.propriedade = propriedade;
        this.usuario = usuario;
        this.pontuacao = pontuacao;
        this.comentario = comentario;
    }

    public Propriedade getPropriedade(){
        return propriedade;
    }

    public Usuario getUsuario(){
        return usuario;
    }

    public int getPontuacao(){
        return pontuacao;
    }

    public String getComentario(){
        return comentario;
    }

    public void setPropriedade(Propriedade propriedade){
        this.propriedade = propriedade;
    }

    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }

    public void setPontuacao(int pontuacao){
        this.pontuacao = pontuacao;
    }

    public void setComentario(String comentario){
        this.comentario = comentario;
    }
}
