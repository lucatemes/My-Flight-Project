package pucrs.myflight.modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeitorAeronaves {
    private ArrayList<Aeronave> aeronaveArquivos;

    public ArrayList<Aeronave> leArquivo(String nomeArquivo) {
        List<String[]> linhas = new ArrayList<>();
        aeronaveArquivos= new ArrayList<Aeronave>();

        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] campos = linha.split(";");
                linhas.add(campos);
                if (campos.length >= 3) {
                    String codigo = campos[0];
                    String desc = campos[1];
                    
                    aeronaveArquivos.add(new Aeronave(codigo, desc));

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return aeronaveArquivos;
    }
}