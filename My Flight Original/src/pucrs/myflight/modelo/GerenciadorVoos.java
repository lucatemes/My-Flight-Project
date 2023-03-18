package pucrs.myflight.modelo;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class GerenciadorVoos {
    private ArrayList<Voo> voos= new ArrayList<>();

    public void adicionar(Voo v1){
        voos.add(v1);
    }

    public void listarTodos(){
        for(Voo lista : voos){
            System.out.println("DATA/HORA: ");
			System.out.println(lista.getDatahora());
            System.out.println("DURAÇÃO: ");
			System.out.println(lista.getDuracao());
            System.out.println("STATUS: ");
			System.out.println(lista.getStatus());
            System.out.println("ROTA: ");
			System.out.println(lista.getRota());
		}
    }

    public void buscarData(LocalDateTime data){
        for(Voo lista : voos){
            if(data == lista.getDatahora()){
                System.out.println("|ROTA|");
                System.out.println(lista.getRota());
                System.out.println("|DURAÇÃO|");
                System.out.println(lista.getDuracao());
            }
        }

    }


}
