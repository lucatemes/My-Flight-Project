package pucrs.myflight.modelo;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class GerenciadorVoos {
    private ArrayList<Voo> voos= new ArrayList<>();

    public void adicionar(Voo v1){
        voos.add(v1);
    }

    public void listarTodos(){
        for(Voo lista : voos ){
            System.out.println("=================================");
            System.out.print("NÚMERO DO VOO: ");
            System.out.println(voos.indexOf(lista) + 1);
            System.out.print("DATA/HORA: ");
			System.out.println(lista.getDatahora());
            System.out.print("DURAÇÃO: ");
			System.out.println(lista.getDuracao());
            System.out.print("STATUS: ");
			System.out.println(lista.getStatus());
            System.out.print("ROTA: ");
			System.out.print(lista.getRota().getOrigem().getNome());
            System.out.print(" X ");
            System.out.println(lista.getRota().getDestino().getNome());
            System.out.print("==================================");
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