

public class Reserva {
    private Propriedade propriedade;
    private Usuario usuario;
    private String dataInicio;
    private String dataFim; 
    private double valor;

    public Reserva(Propriedade propriedade, Usuario usuario, String dataInicio, String dataFim, double valor){
        this.propriedade = propriedade;
        this.usuario = usuario;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.valor = valor;
    }

    public Propriedade getPropriedade(){
        return propriedade;
    }

    public Usuario getUsuario(){
        return usuario;
    }

    public String getDataInicio(){
        return dataInicio;
    }

    public String getDataFim(){
        return dataFim;
    }

    public double getValor(){
        return valor;
    }

    public void setPropriedade(Propriedade propriedade){
        this.propriedade = propriedade;
    }

    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }

    public void setDataInicio(String dataInicio){
        this.dataInicio = dataInicio;
    }

    public void setDataFim(String dataFim){
        this.dataFim = dataFim;
    }

    public void setValor(double valor){
        this.valor = valor;
    }

}

