package pibict.ifpb.monteiro.etldadosabertos.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pibict.ifpb.monteiro.etldadosabertos.constantes.ConstantesDoSistema;
import pibict.ifpb.monteiro.etldadosabertos.util.BaixarDeURL;
import pibict.ifpb.monteiro.etldadosabertos.util.ExcluirArquivos;
import pibict.ifpb.monteiro.etldadosabertos.util.GerarAtributos;
import pibict.ifpb.monteiro.etldadosabertos.util.LerArquivo;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 19/08/2015
 */
@ManagedBean
@SessionScoped
public class Bean implements Serializable {

    private String link;
    private String nomeTabela;
    private LerArquivo ler;
    private List<String> listaDeAtributos;
    private List<String> listaDeRegistros;

    public Bean() {
        ler = new LerArquivo();
        listaDeAtributos = new ArrayList<>();
        listaDeRegistros = new ArrayList<>();
        listaDeAtributos.add("");
    }

    public void enviar() {

        BaixarDeURL.gravaArquivoDeURL(getLink(),
                ConstantesDoSistema.diretorio);

        ler.lerArquivoTxt();
        GerarAtributos atributos = new GerarAtributos();
        atributos.gerarTabela(ler.getListaDeAtributos(), nomeTabela);
//        listaDeAtributos = ler.getListaDeAtributos();
//        listaDeRegistros = ler.getListaDeRegistros();
        ExcluirArquivos.removerArquivos(ConstantesDoSistema.diretorio);
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<String> getListaDeAtributos() {
        return listaDeAtributos;
    }

    public List<String> getListaDeRegistros() {
        return listaDeRegistros;
    }

    public String getNomeTabela() {
        return nomeTabela;
    }

    public void setNomeTabela(String nomeTabela) {
        this.nomeTabela = nomeTabela;
    }

}
