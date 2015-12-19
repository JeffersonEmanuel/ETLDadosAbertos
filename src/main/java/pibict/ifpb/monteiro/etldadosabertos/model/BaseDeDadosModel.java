/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pibict.ifpb.monteiro.etldadosabertos.model;

import java.io.Serializable;

/**
 *
 * @author jefferson-ecs
 */
public class BaseDeDadosModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private String link;
    private String nomeTabela;

    public BaseDeDadosModel(String link, String nomeTabela) {
        this.link = link;
        this.nomeTabela = nomeTabela;
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

}
