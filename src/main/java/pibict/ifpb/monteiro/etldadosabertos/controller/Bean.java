package pibict.ifpb.monteiro.etldadosabertos.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pibict.ifpb.monteiro.etldadosabertos.model.BaseDeDadosModel;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 19/08/2015
 */
@ManagedBean
@SessionScoped
public class Bean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String link;
    private String nomeTabela;
    private List<BaseDeDadosModel> listaDeLinks;
//    private LerArquivo ler;
//    private List<String> listaDeAtributos;
//    private List<String> listaDeRegistros;

    public Bean() {
//        ler = new LerArquivo();
//        listaDeAtributos = new ArrayList<>();
//        listaDeRegistros = new ArrayList<>();
//        listaDeAtributos.add("");
        listaDeLinks = new ArrayList<>();
    }
//
//    public void enviar() {
//
//        BaixarDeURL.gravaArquivoDeURL(getLink(),
//                ConstantesDoSistema.diretorio);
//
//        ler.lerArquivoTxt();
//        GerarAtributos atributos = new GerarAtributos();
//        atributos.gerarTabela(ler.getListaDeAtributos(), nomeTabela);
////        listaDeAtributos = ler.getListaDeAtributos();
////        listaDeRegistros = ler.getListaDeRegistros();
//        ExcluirArquivos.removerArquivos(ConstantesDoSistema.diretorio);
//    }

    public void adicionarRegistros() {
        listaDeLinks.add(new BaseDeDadosModel(link, nomeTabela));
        link = null;
        nomeTabela = null;

    }

    public void removerRegistros() {
        listaDeLinks.remove(0);

    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getNomeTabela() {
        return nomeTabela;
    }

    public void setNomeTabela(String nomeTabela) {
        this.nomeTabela = nomeTabela;
    }

    public List<BaseDeDadosModel> getListaDeLinks() {
        return listaDeLinks;
    }

    public void setListaDeLinks(List<BaseDeDadosModel> listaDeLinks) {
        this.listaDeLinks = listaDeLinks;
    }

}
