package pibict.ifpb.monteiro.etldadosabertos.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import pibict.ifpb.monteiro.etldadosabertos.constantes.ConstantesDoSistema;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 18/08/2015
 */
public class LerArquivo {

    private List<String> listaDeAtributos = new ArrayList<>();

    private List<String> listaDeRegistros = new ArrayList<>();

    public void lerArquivoTxt() {

        try {
            int i = 0;
            String atributos = null;

            BufferedReader lerArq = new BufferedReader(new InputStreamReader(new FileInputStream(ConstantesDoSistema.arquivo), "ISO-8859-3"));

            String linha = lerArq.readLine();

            if (i == 0) {
                atributos = linha.replace("\"", "");
                listaDeAtributos = Arrays.asList(atributos.split(","));
                linha = lerArq.readLine();
                i++;
            }

            while (linha != null) {
                System.out.println(atributos);
                linha = linha.replace("\"", " ");
                listaDeRegistros = Arrays.asList(linha.split(","));
                System.out.println(linha);

                linha = lerArq.readLine();
            }

        } catch (IOException e) {

            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }
        System.out.println();
    }

    public List<String> getListaDeAtributos() {
        return listaDeAtributos;
    }

    public void setListaDeAtributos(List<String> listaDeAtributos) {
        this.listaDeAtributos = listaDeAtributos;
    }

    public List<String> getListaDeRegistros() {
        return listaDeRegistros;
    }

    public void setListaDeRegistros(List<String> listaDeRegistros) {
        this.listaDeRegistros = listaDeRegistros;
    }

}
