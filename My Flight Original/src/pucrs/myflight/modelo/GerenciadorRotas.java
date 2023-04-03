package pucrs.myflight.modelo;
import java.util.ArrayList;

public class GerenciadorRotas {

    private ArrayList<Rota> rotas = new ArrayList<>();

    // adiciona uma rota a um arraylist (para vincular com o voo)

    public void adicionar(Rota caminho){
        rotas.add(caminho);
    }

    // lista todas rotas disponiveis para voos

    public void listarTodos(){
        for(Rota lista : rotas){
            System.out.println("ORIGEM: ");
			System.out.println(lista.getOrigem());
            System.out.println("COMPANHIA: ");
			System.out.println(lista.getCia());
            System.out.println("AVIÃO: ");
			System.out.println(lista.getAeronave());
		}
    }

    

}
