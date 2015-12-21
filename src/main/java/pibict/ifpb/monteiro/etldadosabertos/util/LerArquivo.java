package pibict.ifpb.monteiro.etldadosabertos.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pibict.ifpb.monteiro.etldadosabertos.constantes.ConstantesDoSistema;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 18/08/2015
 */
public class LerArquivo {

    private List<String> listaDeAtributos = new ArrayList<>();

    private List<String> listaDeRegistros = new ArrayList<>();
    private ConstantesDoSistema cns = new ConstantesDoSistema();

    public List<List<String>> lerArquivoTxt() {
        List<List<String>> llregistros = new ArrayList<>();
        try {
            int i = 0;
            String atributos = null;

            BufferedReader lerArq = new BufferedReader(new InputStreamReader(new FileInputStream(cns.arquivo()), "ISO-8859-3"));

            String linha = lerArq.readLine();

            boolean atributoGIS = false;
            if (i == 0) {
                atributos = linha.replace("\"", "");
                listaDeAtributos = Arrays.asList(atributos.split(","));
                atributoGIS = verificarAtributo(listaDeAtributos);
                linha = lerArq.readLine();
                i++;
            }

            boolean registroGIS = false;
            while (linha != null) {
                linha = linha.replace("\"", " ");
                listaDeRegistros = Arrays.asList(linha.split(","));
                llregistros.add(listaDeRegistros);
                registroGIS = verificarValorGIS(listaDeRegistros);
                linha = lerArq.readLine();
            }
            System.out.println("Registro existe? " + registroGIS + " // Atributo existe? " + atributoGIS);

        } catch (IOException e) {

            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }
        return llregistros;
    }

    /**
     * Verificar entre as linhas, se os valores contêm indícios de registros
     * geométricos (POINT, LINE, MULTIPOINT, POLYGON) e retorna verdadeiro
     * (TRUE) caso exista, ou, retorna falso (FALSE) caso não exista.
     *
     * @param listaDeLinhas
     * @return TRUE or FALSE
     */
    private boolean verificarValorGIS(List<String> listaDeLinhas) {
        for (String atributo : listaDeLinhas) {
            if (atributo.contains(ConstantesDoSistema.valorLINE)
                    || atributo.contains(ConstantesDoSistema.valorPOINT)
                    || atributo.contains(ConstantesDoSistema.valorPOLYGON)
                    || atributo.contains(ConstantesDoSistema.valorMULTIPOINT)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Verificar entre os atributos, se contêm a sequência de caracteres "geom",
     * caso exista retorna verdadeiro (TRUE), caso não exista retorna falso
     * (FALSE).
     *
     * @param listaDeAtributos
     * @return TRUE or FALSE
     */
    private boolean verificarAtributo(List<String> listaDeAtributos) {
        for (String atributo : listaDeAtributos) {
            atributo = atributo.toLowerCase();
            if (atributo.contains("geom")) {
                return true;
            }
        }
        return false;
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
