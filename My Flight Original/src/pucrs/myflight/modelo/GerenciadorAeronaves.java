package pucrs.myflight.modelo;
import java.util.ArrayList;

public class GerenciadorAeronaves {

    private ArrayList<Aeronave> avioes= new ArrayList<>();

    public void adicionar(Aeronave aviao){
        avioes.add(aviao);
    }

    public void listarTodos(){
        for(Aeronave lista : avioes){
            System.out.println(lista.getCodigo());
        }
    }

    public void buscarPorCodigo(String codigo){
        for(Aeronave lista : avioes){
            if(codigo == lista.getCodigo()){
                System.out.println(lista.getDescricao());
            }
        }

    }
}
