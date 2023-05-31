package pucrs.myflight.modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeitorAeroporto {
    private ArrayList<Aeroporto> aeroArquivos;

    public LeitorAeroporto() {
        aeroArquivos= new ArrayList<Aeroporto>();
    }

    public ArrayList<Aeroporto> leArquivo(String filename) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))){
            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                String[] campos = linha.split(";");

                if (campos.length >= 5) {
                    String codigo = campos[0];
                    double latitude = Double.parseDouble(campos[1]);
                    double longitude = Double.parseDouble(campos[2]);
                    String nome = campos[3];

                    aeroArquivos.add(new Aeroporto(codigo, nome, new Geo(latitude, longitude)));

                }
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            return null;
        }
        return aeroArquivos;
    }

        public static void filtrarPorCodigo(List<String> codigos, String codigoFiltro) {
        List<String> codigosFiltrados = new ArrayList<>();
        
        for (String codigo : codigos) {
            if (codigo.equals(codigoFiltro)) {
                codigosFiltrados.add(codigo);
            }
        }
    }



    public void filtrarCodigo(String string, String string2) {
    }
}