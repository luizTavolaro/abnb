
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

    public ArrayList<Propriedade> propriedades =  new ArrayList<Propriedade>();
    public ArrayList<Usuario> usuarios =  new ArrayList<Usuario>();
    public ArrayList<Reserva> reservas =  new ArrayList<Reserva>();
    public ArrayList<Avaliacao> avaliacoes =  new ArrayList<Avaliacao>();
    
    public void cadastroUsuario(){
        Scanner leitor = new Scanner(System.in);

        System.out.println("Cadastro de Usuários");
        System.out.println("Informe um nome");
        String nome = leitor.nextLine();

        System.out.println("Informe um email");
        String email = leitor.nextLine();
        
        System.out.println("Informe uma senha");
        String senha = leitor.nextLine();

        Usuario usuario = new Usuario(nome, email, senha);
        usuarios.add(usuario);
    }

    public void cadastroPropriedade(Usuario usuario){
        Scanner leitor = new Scanner(System.in);

        System.out.println("Cadastro de Propriedade");
        System.out.println("Informe o título da propriedade");
        String titulo = leitor.nextLine();

        System.out.println("Informe a descrição da propriedade");
        String descricao = leitor.nextLine();
        
        System.out.println("Informe a localização da propriedade");
        String localizacao = leitor.nextLine();
        
        System.out.println("Informe a capacidade da propriedade");
        int capacidade = leitor.nextInt();
        
        System.out.println("Informe o preço por noite da propriedade");
        double precoNoite = leitor.nextDouble();
        
        
        Propriedade propriedade = new Propriedade(titulo, descricao, localizacao, capacidade, precoNoite, usuario);
        propriedades.add(propriedade);
        usuario.adicionaPropriedade(propriedade);
        System.out.println("Propriedade cadastrada!");
    }

    public void detalhesPropriedades(Usuario usuario) {
    	double valorPrecos = 0.00;
    	for(int i = 0; i < usuario.getPropriedades().size(); i++) {
    		System.out.println(usuario.getPropriedades().get(i).getTitulo());
    		System.out.println(usuario.getPropriedades().get(i).getDescricao());
    		System.out.println(usuario.getPropriedades().get(i).getLocalizacao());
    		System.out.println(usuario.getPropriedades().get(i).getPrecoNoite());
    		valorPrecos =+ usuario.getPropriedades().get(i).getPrecoNoite();
    	}
    	double valorMedio = valorPrecos / usuario.getPropriedades().size();
    	System.out.println("O valor médio é: " + valorMedio);
    }
    
    public void propriedadesAlugadas(Usuario usuario) {
    	for(int i = 0 ; i < reservas.size(); i++) {
    		if(reservas.get(i).getPropriedade().getProprietario().getNome().equals(usuario.getNome())) {
    			System.out.println("A propriedade: " + reservas.get(i).getPropriedade().getTitulo() + " está alugada");
    		}
    	}
    }

    public ArrayList<Propriedade> buscaPropriedades(){
        Scanner leitor = new Scanner(System.in);
        ArrayList<Propriedade> propriedadesLocal = new ArrayList<Propriedade>();
        
        System.out.println("Busca Propriedades");
        System.out.println("Informe a localizacao");
        String localizacao = leitor.nextLine();

        for(Propriedade p : propriedades){
            if(localizacao.equals(p.getLocalizacao())){
                System.out.println("Propriedade no local encontrada: " + p.getTitulo());
                propriedadesLocal.add(p);
            }
        }

        return propriedadesLocal;
    }

    public void realizaReserva(Usuario usuario){
        Scanner leitor = new Scanner(System.in);
        ArrayList<Propriedade> propriedadesLocal = buscaPropriedades();

        System.out.println("Informe uma data de início");
        String dataInicio = leitor.nextLine();

        System.out.println("Informe uma data final");
        String dataFim = leitor.nextLine();
        
        for(Propriedade p : propriedadesLocal){
        	for(Reserva r : reservas){
        		if(r.getPropriedade() == p && dataInicio.equals(r.getDataInicio()) && dataFim.equals(r.getDataFim())){
        			System.out.println("Propriedade indisponível na data informada");
        			break;
        		}
        		else {
                    double valor = p.getPrecoNoite(); // * dias de estadia;
                    Reserva novaReserva = new Reserva(p, usuario, dataInicio, dataFim,valor);
                    System.out.println("Título da propriedade " + p.getTitulo());
                    System.out.println("Descrição da propriedade " + p.getDescricao());
                    System.out.println("Capacidade da propriedade " + p.getCapacidade());
                    System.out.println("Fotos da propriedade " + p.getFotos());
                    System.out.println("Valor pro noite " + p.getPrecoNoite());
                    System.out.println("Valor total de estadia " + valor);
                    System.out.println("Deseja finalizar a reserva? ");
                    String reservar = leitor.nextLine();
                    if(reservar.equals("sim")){
                        reservas.add(novaReserva);
                        usuario.adicionaReserva(novaReserva);
                        break;
                    }
                    else {
                    	break;
                    }
        		}
        	}
        }
    }

    public void avaliar(Usuario usuario){
        Scanner leitor = new Scanner(System.in);
        boolean avaliou = false;
        // data atual
        for(Reserva r : reservas){
            if(r.getUsuario() == usuario){ // add validacao de data
            	System.out.println("Propriedade: " + r.getPropriedade().getTitulo());
            	System.out.println("Data Inicial da estadia: " + r.getDataInicio());
            	System.out.println("Data final da estadia: " + r.getDataInicio());
                System.out.println("Informe a quantidade de estrelas da sua avaliação");
                int pontuacao = leitor.nextInt();
                leitor.nextLine();
                System.out.println("Informe um comentário");
                String comentario = leitor.nextLine();
                
                Avaliacao novaAvaliacao = new Avaliacao(r.getPropriedade(), usuario, pontuacao, comentario);
                avaliacoes.add(novaAvaliacao);
               
                Usuario proprietario = r.getPropriedade().getProprietario();
                proprietario.adicionaAvaliacao(novaAvaliacao);
                avaliou = true;
            }
        }
        if(!avaliou) {
       	 	System.out.println("Usuário não fez nenhuma reserva ainda");
        }
    }

    public void menu() {
    	System.out.println("+++ MENU +++");
    	System.out.println("Proprietário (1)");
    	System.out.println("Hóspede (2)");
    }


}
