package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;

public class VooEscalas extends Voo
{
    private Rota rotaFinal;

    public VooEscalas(Rota rota, Rota rotaFinal, LocalDateTime datahora, Duration duracao, int lugares) {
        super(rota, datahora, duracao, lugares); // chama o construtor de Voo
        this.rotaFinal = rotaFinal;
     }

    @Override
    public String toString() {
       return super.toString() + " -> " + rotaFinal;
    }
}
