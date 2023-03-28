package pucrs.myflight.consoleApp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Scanner;
import pucrs.myflight.modelo.Aeronave;
import pucrs.myflight.modelo.Aeroporto;
import pucrs.myflight.modelo.CiaAerea;
import pucrs.myflight.modelo.Geo;
import pucrs.myflight.modelo.GerenciadorAeroportos;
import pucrs.myflight.modelo.GerenciadorCias;
import pucrs.myflight.modelo.GerenciadorVoos;
import pucrs.myflight.modelo.Rota;
import pucrs.myflight.modelo.Voo;

public class App {
	public static void main(String[] args) {
		
		System.out.println("\nMyFlight project...");

		/*
		 * Processo para criação de Voos!!
		 * 1º Criação das CIAS aéreas;
		 * 2º Criação da aeronave;
		 * 3º Criação da geolocalização da origem e destino (coordenadas);
		 * 4º Criação dos aeroportos com a respectiva localização;
		 * 5º Criação da Rota incluindo CIA, Aeroporto de origem, Aeoroporto de destino e o Avião;
		 * 6º Criação da duração em minutos da viagem;
		 * 7º Criação de um LocalDateTime;
		 * 8º Definir um status;
		 * 9º Para finalizar a criação do Voo, incluindo Rota, LocalDateTime e duração
		 */

		CiaAerea GOL= new CiaAerea("1231", "GOL");
		CiaAerea LATAM= new CiaAerea("1314", "LATAM");

		Aeronave BOEING157= new Aeronave("157","Avião para voos internacionais.");

		Geo guarulhosGeo= new Geo(-23.4322, -46.4692);
		Aeroporto Guarulhos= new Aeroporto("1", "GUAR", guarulhosGeo);

		Geo santaMonicaGEO= new Geo(34.0158, -118.451);
		Aeroporto SantaMonica= new Aeroporto("2", "SWMN", santaMonicaGEO);

		Rota GtoS = new Rota(LATAM, Guarulhos, SantaMonica, BOEING157);

		Duration duracao1= Duration.ofMinutes(522);

		LocalDateTime datahora1= LocalDateTime.of(2023, 03, 16, 0, 0);

		Voo.Status confirmado = Voo.Status.CONFIRMADO;

		Voo GUARxSWMN= new Voo(GtoS, datahora1, duracao1);

		
		//GERENCIAMENTO

		GerenciadorCias gerenEmpresa= new GerenciadorCias();
		GerenciadorVoos gerenVoos= new GerenciadorVoos();
		GerenciadorAeroportos gerenAero= new GerenciadorAeroportos();

		gerenAero.adicionar(Guarulhos);
		gerenAero.adicionar(SantaMonica);
		gerenVoos.adicionar(GUARxSWMN);
		
		
		/*
		 * MENU:
		 * 1- Ver lista de voos disponíveis
		 * 2- Buscar por rota
		 * 
		 */

		 Scanner usr= new Scanner(System.in);

		 System.out.println("MENU:");
		 System.out.println("1- Ver lista de voos disponíveis");
		 System.out.println("2- Buscar por rota");

		 int answer= usr.nextInt();
	
		 switch(answer){
			case 1:
				gerenVoos.listarTodos();
				break;
			case 2:
				System.out.println("Dentre estas opções, onde você deseja embarcar no voo:");
				gerenAero.listarTodos();

				usr.nextLine();
				String origemUsr= usr.nextLine();

				System.out.println("Agora, dentre estas opções, para onde você deseja ir:");
				gerenAero.listarTodos();
				String destinoUsr= usr.nextLine();
				gerenVoos.buscarPorRota(origemUsr, destinoUsr);

		 }
	
	}

	

}