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
        System.out.println("=================================");
                System.out.print("CÓDIGO DO VOO: ");
                System.out.println(lista.getCodigo());
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
                System.out.print("LUGARES DISPONÍVEIS: ");
                System.out.println(lista.getLugares());
                System.out.println("=================================");
                contador++;
                }
                for(VooEscalas lista1 : escalas){
                    System.out.println("=================================");
                            System.out.print("CÓDIGO DO VOO: ");
                            System.out.println(lista1.getCodigo());
                            System.out.print("DATA/HORA: ");
                            System.out.println(lista1.getDatahora());
                            System.out.print("DURAÇÃO: ");
                            System.out.println(lista1.getDuracao());
                            System.out.print("STATUS: ");
                            System.out.println(lista1.getStatus());
                            System.out.print("ROTA: ");
                            System.out.print(lista1.getRota().getOrigem().getNome());
                            System.out.print(" X ");
                            System.out.print(lista1.getRota().getDestino().getNome());
                            System.out.print(" X ");
                            System.out.println(lista1.getRotaFinal().getDestino().getNome());
                            System.out.print("LUGARES DISPONÍVEIS: ");
                            System.out.println(lista1.getLugares());
                            System.out.println("=================================");
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
                System.out.println("=================================");
                System.out.print("CÓDIGO DO VOO: ");
                System.out.println(lista.getCodigo());
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
                System.out.print("LUGARES DISPONÍVEIS: ");
                System.out.println(lista.getLugares());
                System.out.println("=================================");
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
                System.out.println("=================================");
                System.out.print("CÓDIGO DO VOO: ");
                System.out.println(lista.getCodigo());
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
                System.out.print("LUGARES DISPONÍVEIS: ");
                System.out.println(lista.getLugares());
                System.out.println("=================================");
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
                System.out.println("=================================");
                System.out.print("CÓDIGO DO VOO: ");
                System.out.println(lista.getCodigo());
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
                System.out.print("LUGARES DISPONÍVEIS: ");
                System.out.println(lista.getLugares());
                System.out.println("=================================");
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
                System.out.println("=================================");
                System.out.print("CÓDIGO DO VOO: ");
                System.out.println(lista.getCodigo());
                System.out.println("|ROTA|");
                System.out.print(lista.getRota().getOrigem().getNome());
                System.out.print(" X ");
                System.out.println(lista.getRota().getDestino().getNome());
                System.out.println("|DURAÇÃO|");
                System.out.println(lista.getDuracao());
                System.out.println("=================================");
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
                System.out.println("=================================");
                System.out.print("CÓDIGO DO VOO: ");
                System.out.println(lista.getCodigo() + 1);
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
                System.out.print("LUGARES DISPONÍVEIS: ");
                System.out.println(lista.getLugares());
                System.out.println("=================================");
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