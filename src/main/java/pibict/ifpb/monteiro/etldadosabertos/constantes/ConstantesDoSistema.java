package pibict.ifpb.monteiro.etldadosabertos.constantes;

import javax.faces.context.FacesContext;


/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 18/08/2015
 */
public class ConstantesDoSistema {

    private String pegarCaminho() {
        return FacesContext.getCurrentInstance().getExternalContext().getRealPath("/ArquivosTemporarios/");
    }


    public String arquivo () {
        String caminho = pegarCaminho() + "temporario";
        return caminho;
    }
    
    
    //Valores GIS
    public static String valorPOINT = "POINT";
    public static String valorMULTIPOINT = "MULTIPOINT";
    public static String valorPOLYGON = "POLYGON";
    public static String valorLINE = "LINE";
}
