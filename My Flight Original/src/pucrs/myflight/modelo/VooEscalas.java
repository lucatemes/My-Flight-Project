package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;

public class VooEscalas extends Voo
{
    private Rota rotaFinal;

    public VooEscalas(Rota rota, Rota rotaFinal, LocalDateTime datahora, Duration duracao, int lugares, String coodigoVoo) {
        super(rota, datahora, duracao, lugares, coodigoVoo); // chama o construtor de Voo
        this.rotaFinal = rotaFinal;
    }

    @Override
    public String toString() {
        StringBuilder sa= new StringBuilder();
		sa.append("===================");
		sa.append("\nCÓDIGO DO VOO: ");
		sa.append(getCodigo());
                sa.append("\nDATA/HORA: ");
			    sa.append(getDatahora());
                sa.append("\nDURAÇÃO: ");
			    sa.append(getDuracao());
                sa.append("\nSTATUS: ");
			    sa.append(getStatus());
                sa.append("\nROTA: ");
			    sa.append(getRota().getOrigem().getNome());
                sa.append(" X ");
                sa.append(getRota().getDestino().getNome());
                sa.append(" X ");
                sa.append(getRotaFinal().getDestino().getNome());
                sa.append("\nLUGARES DISPONÍVEIS: ");
                sa.append(getLugares());
		return sa.toString();
    }

    public Rota getRotaFinal(){
        return rotaFinal;
    }

}
