package pibict.ifpb.monteiro.etldadosabertos.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 23/08/2015
 */
public class GerarAtributos {

    public GerarAtributos() {
    }

    public void gerarTabela(List<String> atributos) {
        try {
            String url = "jdbc:postgresql://localhost:5432/etldadosabertos";
            String usuario = "admin";
            String senha = "123";

            Class.forName("org.postgresql.Driver");

            Connection con;

            con = DriverManager.getConnection(url, usuario, senha);

            System.out.println("Conexão realizada com sucesso.");

            Statement stmt = con.createStatement();
            String t = null;
            for (String atributo : atributos) {
                atributo = atributo.replace(" ", "_");
                t += atributo + " VARCHAR(254),";
            }
            t = t.substring(4, (t.length() - 1));
            String sql = "CREATE TABLE tabela_modelo(" + t + ")";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            con.close();
            System.out.println("Completo com Sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GerarAtributos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
