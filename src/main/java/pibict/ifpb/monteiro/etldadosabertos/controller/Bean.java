package pibict.ifpb.monteiro.etldadosabertos.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pibict.ifpb.monteiro.etldadosabertos.model.BaseDeDadosModel;
import pibict.ifpb.monteiro.etldadosabertos.util.BaixarDeURL;
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

    private static final long serialVersionUID = 1L;

    private String link;
    private String nomeTabela;
    private List<BaseDeDadosModel> listaDeLinks;
    private LerArquivo ler;
    BaixarDeURL baixarDeURL;
    private List<List<String>> listaDeAtributosTemp;
    GerarAtributos gerar;
    private List<String> listaDeRegistros;

    public Bean() {
        ler = new LerArquivo();
        listaDeAtributosTemp = new ArrayList<>();
        gerar = new GerarAtributos();
        listaDeRegistros = new ArrayList<>();;
        listaDeLinks = new ArrayList<>();
        baixarDeURL = new BaixarDeURL();
    }

    public void salvar() {

        gerar.gerarDados("BancoTeste2", "ColecaoTeste", ler.getListaDeAtributos(), ler.lerArquivoTxt());
//        atributos.gerarTabela(ler.getListaDeAtributos(), nomeTabela);
////        listaDeAtributos = ler.getListaDeAtributos();
//        listaDeRegistros = ler.getListaDeRegistros();
//        ExcluirArquivos.removerArquivos(ConstantesDoSistema.diretorio);
    }

    public void adicionarRegistros() {
        baixarDeURL.gravaArquivoDeURL(link);
        listaDeLinks.add(new BaseDeDadosModel(link, nomeTabela));
        link = null;
        nomeTabela = null;
        ler.lerArquivoTxt();
        listaDeAtributosTemp.add(ler.getListaDeAtributos());

    }

    public List<String> getListaDeAtributos() {
        for (List<String> lista : listaDeAtributosTemp) {
            return lista;
        }
        return null;
    }

    public void removerRegistros(BaseDeDadosModel baseDeDadosModel) {
        listaDeLinks.remove(baseDeDadosModel);

    }

    public void salvarRegistros() {

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
