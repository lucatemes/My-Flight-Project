package pucrs.myflight.modelo;
import java.util.ArrayList;

public class GerenciadorAeroportos {
    private ArrayList<Aeroporto> aeros = new ArrayList<>();

    public void adicionar(Aeroporto aero){
        aeros.add(aero);
    }

    public void listarTodos(){
        for(Aeroporto lista : aeros){
			System.out.println(lista.getNome());
		}
    }

    

}
