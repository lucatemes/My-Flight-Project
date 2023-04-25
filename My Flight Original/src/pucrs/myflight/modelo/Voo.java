package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;

public class Voo {
	
	public enum Status { CONFIRMADO, ATRASADO, CANCELADO };
	
	private LocalDateTime datahora;
	private Duration duracao;
	private Rota rota;
	private Status status;
	private int lugares;
	private String codigoVoo;
	//codigo apresentado na hora de comprar tickets
	
	public Voo(Rota rota, LocalDateTime datahora, Duration duracao, int lugares, String coodigoVoo) {
		this.rota = rota;
		this.datahora = datahora;
		this.duracao = duracao;
		this.status = Status.CONFIRMADO; // default é confirmado
		this.lugares= lugares;
		this.codigoVoo= coodigoVoo;
	}

	public Voo(){
		this.rota= rota;
		this.datahora= LocalDateTime.of(2016, 8, 12, 0, 0);
		this.duracao= duracao;
		this.status= Status.CONFIRMADO;
		this.lugares= lugares;
		this.codigoVoo= codigoVoo;
	}
	
	public Rota getRota() {
		return rota;
	}
	public String getCodigo(){
		return codigoVoo;
	}
	
	public LocalDateTime getDatahora() {
		return datahora;
	}
	
	public Duration getDuracao() {
		return duracao;
	}
	
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status novo) {
		this.status = novo;
	}

	public int getLugares(){
		return lugares;
	}

	public void setLugares(int vagas){
		this.lugares= vagas;
	}
}
