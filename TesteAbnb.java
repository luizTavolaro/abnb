
import java.util.Scanner;

public class TesteAbnb {
    public static void main(String[] args) {
        Controller c = new Controller();
        Scanner leitor = new Scanner(System.in);
        
        Usuario luiz = new Usuario("Luiz", "luiz@123", "123luiz");
        Usuario joao = new Usuario("Joao", "joao@123", "123joao");
        Usuario mat = new Usuario("Matheus", "mat@123", "123mat");
        c.usuarios.add(luiz);
        c.usuarios.add(joao);
        c.usuarios.add(mat);
        
        Usuario hosp1 = new Usuario("hosp1", "hosp1@123", "123hosp1");
        Usuario hosp2 = new Usuario("hosp1", "hosp2@123", "123hosp2");
        Usuario hosp3 = new Usuario("hosp1", "hosp3@123", "123hosp3");
        c.usuarios.add(hosp1);
        c.usuarios.add(hosp2);
        c.usuarios.add(hosp3);
        
        Propriedade casaLuiz1 = new Propriedade("casa1","grande","rua123",30,100.0,luiz);
        Propriedade casaLuiz2 = new Propriedade("casa2","media","123rua123",10,200.0,luiz);
        Propriedade casaLuiz3 = new Propriedade("casa3","pequena","456rua123",40,300.0,luiz);
        Propriedade casaLuiz4 = new Propriedade("casa4","grande","789rua123",50,400.0,luiz);
        Propriedade casaLuiz5 = new Propriedade("casa5","grande","rua123",20,500.0,luiz);
        Propriedade casaJoao = new Propriedade("casa6","media","rua456",20,80.0,joao);
        Propriedade casaMat = new Propriedade("casa7","pequena","rua789",10,50.0,mat);
        c.propriedades.add(casaLuiz1);
        c.propriedades.add(casaLuiz2);
        c.propriedades.add(casaLuiz3);
        c.propriedades.add(casaLuiz4);
        c.propriedades.add(casaLuiz5);
        c.propriedades.add(casaJoao);
        c.propriedades.add(casaMat);
        luiz.adicionaPropriedade(casaLuiz1);
        luiz.adicionaPropriedade(casaLuiz2);
        luiz.adicionaPropriedade(casaLuiz3);
        luiz.adicionaPropriedade(casaLuiz4);
        luiz.adicionaPropriedade(casaLuiz5);
        joao.adicionaPropriedade(casaJoao);
        mat.adicionaPropriedade(casaMat);
        
        Reserva rhops1 = new Reserva(casaLuiz1,hosp1,"2023-10-01","2023-10-31",300.0);
        Reserva rhops2 = new Reserva(casaJoao,hosp2,"2023-09-01","2023-09-30",400.0);
        Reserva rhops3 = new Reserva(casaMat,hosp3,"2023-08-01","2023-08-31",500.0);
        c.reservas.add(rhops1);
        c.reservas.add(rhops2);
        c.reservas.add(rhops3);
        
        Avaliacao avhosp1 = new Avaliacao(casaLuiz1, hosp1, 1, "ruim");
        Avaliacao avhosp2 = new Avaliacao(casaJoao, hosp2, 3, "bom");
        Avaliacao avhosp3 = new Avaliacao(casaMat, hosp3, 5, "muito bom");
        c.avaliacoes.add(avhosp1);
        c.avaliacoes.add(avhosp2);
        c.avaliacoes.add(avhosp3);

        
        while(true) {
        	c.menu();
  	      	int escolha = leitor.nextInt();
	          if(escolha == 1){
		          System.out.println("Cadastro de propriedades (1)");
		          System.out.println("Detalhes das propriedades (2)");
		          System.out.println("Propriedades alugadas (3)");

		          int escolhaProprietario = leitor.nextInt();
	          
		          if(escolhaProprietario == 1){
		              c.cadastroPropriedade(luiz);
		          }
	
		          else if(escolhaProprietario == 2){
		        	  c.detalhesPropriedades(luiz);
		          }
		
		          else if(escolhaProprietario == 3){
		              c.propriedadesAlugadas(luiz);
		          }
	          }
	          else if(escolha == 2){
	        	  System.out.println("Buscar propriedades(1)");
		          System.out.println("Reservar propriedades(2)");
		          System.out.println("Avaliar(3)");
		          int escolhaUsuario = leitor.nextInt();
		          if(escolhaUsuario == 1){
		              c.buscaPropriedades();
		          }
		          else if(escolhaUsuario == 2){
		              c.realizaReserva(luiz);
		          }
		          else if(escolhaUsuario == 3) {
		        	  c.avaliar(luiz);
		          }
	          }
	          else {
	        	  break;
	          }
        }
    }
}