package pucrs.myflight.consoleApp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import pucrs.myflight.modelo.Aeronave;
import pucrs.myflight.modelo.Aeroporto;
import pucrs.myflight.modelo.CiaAerea;
import pucrs.myflight.modelo.Geo;
import pucrs.myflight.modelo.GerenciadorAeronaves;
import pucrs.myflight.modelo.GerenciadorAeroportos;
import pucrs.myflight.modelo.GerenciadorCias;
import pucrs.myflight.modelo.GerenciadorRotas;
import pucrs.myflight.modelo.GerenciadorVoos;
import pucrs.myflight.modelo.LeitorAeronaves;
import pucrs.myflight.modelo.LeitorAeroporto;
import pucrs.myflight.modelo.LeitorCompanhia;
import pucrs.myflight.modelo.Rota;
import pucrs.myflight.modelo.Voo;
import pucrs.myflight.modelo.VooEscalas;
import pucrs.myflight.modelo.VooVariasEscalas;

public class App {
	public static void main(String[] args) {
		
		System.out.println("\nMyFlight project...");

		CiaAerea GOL= new CiaAerea("1231", "GOL");
		CiaAerea LATAM= new CiaAerea("1314", "LATAM");
		CiaAerea QATAR= new CiaAerea("1212", "QATAR AIRWAYS");

		Aeronave BOEING177= new Aeronave("177","Avião para voos internacionais.");
		Aeronave BOEING777= new Aeronave("777", "Avião destinado para voos nacionais");

		Geo portoAlegreGeo= new Geo(-30.033056, -51.230000);
		Geo dohaQatar= new Geo(25.2807,51.5217);
		Geo guarulhosGeo= new Geo(-23.431934, -46.469320);
		Geo santaMonicaGEO= new Geo(33.943091, -118.408125);

		Aeroporto SalgadoFilho= new Aeroporto("3", "POA", portoAlegreGeo);
		Aeroporto HamadDoha= new Aeroporto("4", "HAMAD", dohaQatar);
		Aeroporto Guarulhos= new Aeroporto("1", "GUAR", guarulhosGeo);
		Aeroporto SantaMonica= new Aeroporto("2", "SWMN", santaMonicaGEO);

		Rota GtoS = new Rota(LATAM, Guarulhos, SantaMonica, BOEING777);
		Rota GtoP = new Rota(GOL, Guarulhos, SalgadoFilho, BOEING177);
		Rota GtoD = new Rota(QATAR, Guarulhos, HamadDoha, BOEING777);
		Rota PtoG = new Rota(GOL, SalgadoFilho, Guarulhos, BOEING777);

		// duração de cada voo

		Duration duracao2= Duration.ofMinutes(portoAlegreGeo.getDuracao(guarulhosGeo, portoAlegreGeo));//GuarxPoa
		Duration duracao1= Duration.ofMinutes(portoAlegreGeo.getDuracao(guarulhosGeo, dohaQatar));//GuarxDoha
		Duration duracao3= Duration.ofMinutes(portoAlegreGeo.getDuracao(guarulhosGeo, santaMonicaGEO));
		Duration duracao4= Duration.ofMinutes(portoAlegreGeo.getDuracao(portoAlegreGeo, dohaQatar));
		Duration duracao5= Duration.ofMinutes(portoAlegreGeo.getDuracao(portoAlegreGeo, santaMonicaGEO));

		LocalDateTime datahora1= LocalDateTime.of(2023, 03, 16, 0, 0);

		Voo.Status confirmado = Voo.Status.CONFIRMADO;

		Voo GUARxSWMN= new Voo(GtoS, datahora1, duracao3, 301, "LA01");
		Voo GUARxPOA= new Voo(GtoP, datahora1, duracao2, 80, "GO01");
		Voo GUARxDOHA= new Voo(GtoD, datahora1, duracao1, 368, "QA01");
		VooEscalas POAxGUARxSWMN= new VooEscalas(PtoG, GtoS, datahora1, duracao5, 360, "GOLA01");
		VooEscalas POAxGUARxDOHA= new VooEscalas(PtoG, GtoD, datahora1, duracao4, 350, "GOQA01");

		//System.out.println(santaMonicaGEO.getDistancia(guarulhosGeo, portoAlegreGeo)); //teste
		//System.out.println(santaMonicaGEO.getDistancia(guarulhosGeo, santaMonicaGEO)); //teste
		//GERENCIAMENTO

		GerenciadorCias gerenEmpresa= new GerenciadorCias();
		GerenciadorVoos gerenVoos= new GerenciadorVoos();
		GerenciadorAeroportos gerenAero= new GerenciadorAeroportos();
		GerenciadorRotas gerenRotas= new GerenciadorRotas();

		gerenAero.adicionar(Guarulhos);
		gerenAero.adicionar(SalgadoFilho);
		gerenAero.adicionar(SantaMonica);
		gerenAero.adicionar(HamadDoha);
		// HAMAD = Doha airport
		gerenVoos.adicionar(GUARxDOHA);
		gerenVoos.adicionar(GUARxSWMN);
		gerenVoos.adicionar(GUARxPOA);
		gerenVoos.adicionar(POAxGUARxDOHA);
		gerenVoos.adicionar(POAxGUARxSWMN);

		//input de dados do tipo .dat

		//lendo airports.dat
		LeitorAeroporto leitorAero= new LeitorAeroporto();
		String dadosAero= "airports.dat";
		ArrayList<Aeroporto> aeroArquivos= new ArrayList<Aeroporto>();
		aeroArquivos=leitorAero.leArquivo(dadosAero);
	
		for(int i= 0; i < aeroArquivos.size(); i++){
			gerenAero.adicionar(aeroArquivos.get(i));
		}

		//lendo airlines.dat
		LeitorCompanhia leitorCia= new LeitorCompanhia();
		String dadosCia= "airlines.dat";
		ArrayList<CiaAerea> listaCias= new ArrayList<CiaAerea>();
		listaCias= leitorCia.leArquivo(dadosCia);
		
		for(int i=0; i < listaCias.size(); i++){
			gerenEmpresa.adicionar(listaCias.get(i));
		}

		//lendo equipment.dat
		LeitorAeronaves leitorAeronaves= new LeitorAeronaves();
		String dadosAeronave= "equipment.dat";
		ArrayList<Aeronave> listaAeronaves= new ArrayList<Aeronave>();
		listaAeronaves = leitorAeronaves.leArquivo(dadosAeronave);
		GerenciadorAeronaves gerenAeronaves= new GerenciadorAeronaves();
		
		for(int i= 0; i < listaAeronaves.size(); i++){
			gerenAeronaves.adicionar(listaAeronaves.get(i));
		}

		gerenAeronaves.listarTodos();


		//gerenEmpresa.listarTodas();
		
		/*
		 * MENU:
		 * 1- Ver lista de voos disponíveis
		 * 2- Buscar por rota
		 * 3- Comprar Bilhete de voo
		 * 4- Buscar por origem
		 * 5- Buscar por destino
		 */

		 Scanner usr= new Scanner(System.in);
		 for(int i= 0; i < 20; i++){
		 System.out.println(" ");
		 System.out.println("MENU:");
		 System.out.println("1- Ver lista de voos disponíveis");
		 System.out.println("2- Buscar por rota");
		 System.out.println("3- Buscar por destino");
		 System.out.println("4- Buscar por origem");
		 System.out.println("5- Comprar bilhete para um voo");
		 System.out.println("6- Buscar geral(destino, origem, quantidade de passageiros)");
		 System.out.println("0- Sair");
		 
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
				break;
			case 3:
				System.out.println(" ");
				System.out.println("Digite o destino:");
				gerenAero.listarTodos();
				usr.nextLine();
				String destinoUs= usr.nextLine();
				gerenVoos.buscarPorDestino(destinoUs);
				break;
			
			case 4:
				System.out.println(" ");
				System.out.println("Digite a origem:");
				gerenAero.listarTodos();
				usr.nextLine();
				String origemUs= usr.nextLine();
				gerenVoos.buscarPorOrigem(origemUs);
				break;
			case 5:
				System.out.println(" ");
				System.out.println("Digite o código do voo que deseja efetuar a compra:");
				usr.nextLine();
				String vooUsr= usr.nextLine();
				System.out.println("Quantos bilhetes deseja comprar?:");
				int vooUsr2= usr.nextInt();
				gerenVoos.comprarTicket(vooUsr, vooUsr2);
				break;
			case 6:
				System.out.println("Dentre estas opções, onde você deseja embarcar no voo:");
				gerenAero.listarTodos();
				usr.nextLine();
				String origemUss= usr.nextLine();
				System.out.println("Agora, dentre estas opções, para onde você deseja ir:");
				gerenAero.listarTodos();
				String destinoUss= usr.nextLine();
				System.out.println("Agora informe quantos tickets você precisa: ");
				int tickets= usr.nextInt();
				gerenVoos.buscarGeral(origemUss, destinoUss, tickets);
				break;
			case 0:
				i = 999;
				System.out.println("...");
				break;
			default:
				System.out.println("Função não encontrada.");
				break;
		    }
		}
	}
}