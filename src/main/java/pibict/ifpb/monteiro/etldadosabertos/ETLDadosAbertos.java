package pibict.ifpb.monteiro.etldadosabertos;

import pibict.ifpb.monteiro.etldadosabertos.constantes.ConstantesDoSistema;
import pibict.ifpb.monteiro.etldadosabertos.util.BaixarDeURL;
import pibict.ifpb.monteiro.etldadosabertos.util.ExcluirArquivos;
import pibict.ifpb.monteiro.etldadosabertos.util.LerArquivo;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 18/08/2015
 */
public class ETLDadosAbertos {

    public ETLDadosAbertos() {
    }

    public static void main(String[] args) {
        
        
        String url = "http://geoservicos.ibge.gov.br/geoserver/wms?service=WFS&version=1.0.0&request=GetFeature&typeName=CCAR:BC250_Edif_Agropec_Ext_Vegetal_Pesca_P&outputFormat=CSV";

        
        

        LerArquivo ler = new LerArquivo();
        ler.lerArquivoTxt();


    }

}
