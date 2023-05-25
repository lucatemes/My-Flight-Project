package pucrs.myflight.modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeitorCompanhia {
    private ArrayList<CiaAerea> listaCias;

    public LeitorCompanhia() {
        listaCias= new ArrayList<CiaAerea>();
    }

    public ArrayList<CiaAerea> leArquivo(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] parts = linha.split(";");
                if (parts.length == 2) {
                    String codigo = parts[0].trim();
                    String nome = parts[1].trim();
                    listaCias.add(new CiaAerea(codigo, nome));
                }
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            return null;
        }
        return listaCias;
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
        return listaCias.toString();
    }

    public void filtrarCodigo(String string, String string2) {
    }
}