package pucrs.myflight.modelo;

import java.util.ArrayList;

public class GerenciadorCias {
	private ArrayList<CiaAerea> empresas;
	
	public GerenciadorCias() {
		empresas = new ArrayList<>();
	}

	public void adicionar(CiaAerea cia){
		empresas.add(cia);
	}

	// lista todas companhias aereas

	public void listarTodas(){
		for(CiaAerea lista : empresas){
			System.out.println(lista.getNome());
		}
	}

	// busca companhia aerea por codigo referente

	public void buscarCodigo(String codigo){

		for(CiaAerea lista : empresas){
			if(lista.getCodigo() == codigo){
				System.out.println(lista.getNome());
			}
		}
	}

	// procura companhia aerea por seus nomes
	
	public void buscarNome(String nome){

		for(CiaAerea lista : empresas){
			if(lista.getNome() == nome){
				System.out.println(lista.getCodigo());
			}
		}
	}
}
