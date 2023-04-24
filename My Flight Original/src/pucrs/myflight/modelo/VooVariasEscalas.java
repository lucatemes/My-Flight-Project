package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;

public class VooVariasEscalas extends VooEscalas
{
    private Rota rotaFinal2;

    public VooVariasEscalas(Rota rota, Rota rotaFinal, Rota rotaFinal2, LocalDateTime datahora, Duration duracao, int lugares, String codigo) {
        super(rota, rotaFinal, datahora, duracao, lugares, codigo); // chama o construtor de Voo
        
        this.rotaFinal2 = rotaFinal2;
    }

    @Override
    public String toString() {
       return super.toString() + " - > " + rotaFinal2;
    }

    public Rota getRotaFinal2(){
        return rotaFinal2;
    }


}