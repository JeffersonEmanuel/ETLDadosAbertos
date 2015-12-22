package pibict.ifpb.monteiro.etldadosabertos.util;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import static java.lang.StrictMath.log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.bson.Document;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 23/08/2015
 */
public class GerarAtributos {

    public GerarAtributos() {
    }

    public DBCollection con() {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        DB db = mongoClient.getDB("etldb");
        DBCollection coll = db.getCollection("etlcol");

        return coll;
    }

    public void gerarDados(List<String> atributos, List<List<String>> registros) {
        DBCollection conexao = con();
        for (List<String> registro : registros) {
            BasicDBObject object = new BasicDBObject();
            for (int i = 0; i < registro.size(); i++) {
                if (registro.get(i).length() > 0) {
                    object.put(atributos.get(i), registro.get(i));
                }
            }
            conexao.insert(object);
        }
    }

    public void buscarTodosRegustros() {
        DBCollection conexao = con();
        DBCursor cursor2 = conexao.getDB().getCollection("etlcol").find();
        int i = 1;
        while (cursor2.hasNext()) {
            System.out.println(i + "-----" + cursor2.next());
        }
    }

    public List<String> consulta(String consulta) {
        DBCollection conexao = con();
        BasicDBObject query = new BasicDBObject();
        List<String> dados = separarValores(consulta);
        List<String> retorno = new ArrayList<>();
        for (int i = 0; i < dados.size(); i += 2) {
            query.put(dados.get(i), dados.get(i + 1));
        }

        DBCursor db = conexao.find(query);

        while (db.hasNext()) {
            retorno.add(db.next().toString());

        }

        return retorno;

    }

    public List<String> separarValores(String consulta) {

        String[] bloco = consulta.split(",");
        List<String> blocos = new ArrayList<>();
        for (String string : bloco) {
            String[] aux = string.split(":");
            blocos.add(aux[0]);
            blocos.add(aux[1]);
        }
        return blocos;

    }

}
