package pibict.ifpb.monteiro.etldadosabertos.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
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
    GerarAtributos gerar;
    private List<String> listaDeRegistros;
    private List<String> retornoConsulta;
    private String consulta;

    public Bean() {
        retornoConsulta = new ArrayList<>();
        ler = new LerArquivo();
        gerar = new GerarAtributos();
        listaDeRegistros = new ArrayList<>();;
        listaDeLinks = new ArrayList<>();
        baixarDeURL = new BaixarDeURL();
    }

    public void salvar() {
        gerar.gerarDados(ler.getListaDeAtributos(), ler.lerArquivoTxt());
        gerar.buscarTodosRegustros();
    }

    public void realizarConsulta() {
        System.out.println(gerar.consulta(consulta));
        retornoConsulta = gerar.consulta(consulta);
    }

    public void adicionarRegistros() {
        baixarDeURL.gravaArquivoDeURL(link);
        ler.lerArquivoTxt();
        listaDeLinks.add(new BaseDeDadosModel(link, nomeTabela, ler.getListaDeAtributos()));
        link = null;
        nomeTabela = null;

    }

    public void removerRegistros(BaseDeDadosModel baseDeDadosModel) {
        listaDeLinks.remove(baseDeDadosModel);

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
    boolean teste = false;
    List<String> ex = new ArrayList<>();

    public List<String> getRegistroExemplo() {
        if (teste == false) {
            List<String> ex1 = ler.getListaDeRegistros();
            teste = true;
        }
        return ex;
    }

    public String getConsulta() {
        return consulta;
    }

    public void setConsulta(String consulta) {
        this.consulta = consulta;
    }

    public List<String> getRetornoConsulta() {
        List<String> n = new ArrayList<>();
        for (String r : retornoConsulta) {
            n.add(r + "\n \r");
        }
        return n;
    }

    public void setRetornoConsulta(List<String> retornoConsulta) {
        this.retornoConsulta = retornoConsulta;
    }

}
