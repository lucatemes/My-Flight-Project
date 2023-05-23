package pucrs.myflight.modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeitorAeroporto {
    private ArrayList<String> aeroporto;
    private ArrayList<Aeroporto> aeroArquivos;
    private ArrayList<Geo> geoArquivos;

    public LeitorAeroporto() {
        aeroporto = new ArrayList<String>();
        aeroArquivos= new ArrayList<Aeroporto>();
        geoArquivos= new ArrayList<Geo>();
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
                    String pais = campos[4];

                    /*
                    System.out.println("Código: " + codigo);
                    System.out.println("Latitude: " + latitude);
                    System.out.println("Longitude: " + longitude);
                    System.out.println("Nome: " + nome);
                    System.out.println("País: " + pais);
                    System.out.println();
                    */
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


    @Override
    public String toString() {
        return aeroporto.toString();
    }

    public void filtrarCodigo(String string, String string2) {
    }
}