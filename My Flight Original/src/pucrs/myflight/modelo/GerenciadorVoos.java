package pucrs.myflight.modelo;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class GerenciadorVoos {
    private ArrayList<Voo> voos= new ArrayList<>();
    private ArrayList<VooEscalas> escalas= new ArrayList<>();

    public void adicionar(Voo v1){
        voos.add(v1);
    }

    public void adicionar(VooEscalas v1){
       escalas.add(v1);
    }

    //lista todos voos

    public void listarTodos(){
        int contador= 0;
        int temp= 0;
        for(Voo lista : voos){
            System.out.println(lista.toString());
            contador++;
        }
        for(VooEscalas lista1 : escalas){
            System.out.println(lista1.toString());
            contador++;
        }
        if(contador == 0){
            System.out.println("Nenhum voo encontrado.");
        }
    }

    // busca voos por rota

    public void buscarPorRota(String origem, String destino){
        int contador= 0;
        for(Voo lista : voos){
            if(lista.getRota().getOrigem().getNome().equals(origem) && lista.getRota().getDestino().getNome().equals(destino)){
                contador++;
                System.out.println(lista.toString());
            }
        }
        for(VooEscalas lista1 : escalas){
            if(lista1.getRota().getOrigem().getNome().equals(origem) && lista1.getRotaFinal().getDestino().getNome().equals(destino)){
                System.out.println(lista1.toString());
                contador++;
            }
        }
        if(contador == 0){
            System.out.println("Voo não encontrado.");
        }
    }


    // busca voos por destino

    public void buscarPorDestino(String destino){
        int contador= 0;
        for(Voo lista : voos){
            if(destino.equals(lista.getRota().getDestino().getNome())){
                System.out.println(lista.toString());
                contador++;
            }
        }
        for(VooEscalas lista1 : escalas){
            if(destino.equals(lista1.getRotaFinal().getDestino().getNome())){
                System.out.println(lista1.toString());
            contador++;
            }
        }
        if(contador == 0){
            System.out.println("Voo não encontrado.");
        }
    }

    // busca voos por origem

    public void buscarPorOrigem(String origem){
        int contador =0;
        for(Voo lista : voos){
            if(origem.equals(lista.getRota().getOrigem().getNome())){
                System.out.println(lista.toString());
                contador++;
            }
        }
        for(VooEscalas lista1 : escalas){
            if(origem.equals(lista1.getRota().getOrigem().getNome())){
                System.out.println(lista1.toString());
                contador++;
            }
        }
        if(contador == 0){
            System.out.println("Voo nao encontrado.");
        }
    }

    // busca voos por data

    public void buscarPorData(LocalDateTime data){
        int contador =0;
        for(Voo lista : voos){
            if(data == lista.getDatahora()){
                System.out.println(lista.toString());
                contador++;
            }
        }
        for(VooEscalas lista1 : escalas){
            if(data == lista1.getDatahora()){
                System.out.println(lista1.toString());
                contador++;
            }
        }
        if(contador == 0){
            System.out.println("Voo não encontrado.");
        }
    }

    //reserva tickets de voo

    public void comprarTicket(String nVoo, int qtdBilhete){
        int contador= 0;
       
        for(Voo lista: voos){
            if(nVoo.equals(lista.getCodigo())){
                if(qtdBilhete > 0 && qtdBilhete <= lista.getLugares()){
                lista.setLugares(lista.getLugares() - qtdBilhete);
                System.out.println("Compra efetuada com sucesso, lugares disponíveis: " + lista.getLugares());
                }else{
                    System.out.println("Não é possível fornecer esta quantidade de bilhetes.");
                }
                contador++;  
            }
        }
        for(VooEscalas lista1: escalas){
            if(nVoo.equals(lista1.getCodigo())){
             if(qtdBilhete > 0 && qtdBilhete <= lista1.getLugares()){
                    lista1.setLugares(lista1.getLugares() - qtdBilhete);
                    System.out.println("Compra efetuada com sucesso, lugares disponíveis: " + lista1.getLugares());
                    }else{
                        System.out.println("Não é possível fornecer esta quantidade de bilhetes.");
                    }
                 contador++;
            }
        }
        if(contador == 0){
            System.out.println("Nenhum voo com este código encontrado.");
        }
    }

    public void buscarGeral(String origem, String destino, int lugaresMinimos){
        int contador= 0;
        for(Voo lista : voos){
            if(lista.getRota().getOrigem().getNome().equals(origem) && lista.getRota().getDestino().getNome().equals(destino)){
                if(lista.getLugares() >= lugaresMinimos){
                contador++;
                System.out.println(lista.toString());
                }else{
                System.out.println("Lugares insuficientes: " + lista.getLugares() + " bilhetes restantes.");
                }
            }
        }
        if(contador == 0){
            System.out.println("Voo não encontrado.");
        }
    }

}   