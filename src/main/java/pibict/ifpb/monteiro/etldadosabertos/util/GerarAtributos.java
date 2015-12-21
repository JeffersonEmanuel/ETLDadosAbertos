package pibict.ifpb.monteiro.etldadosabertos.util;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import java.util.List;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 23/08/2015
 */
public class GerarAtributos {

    public GerarAtributos() {
    }

    public DBCollection con(String nomeDoBanco, String nomeDaColecao) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        DB db = mongoClient.getDB(nomeDoBanco);
        DBCollection coll = db.getCollection(nomeDaColecao);

        return coll;
    }

    public void gerarDados(String nomeDoBanco, String nomeDaColecao,
            List<String> atributos, List<List<String>> registros) {
        DBCollection conexao = con(nomeDoBanco, nomeDaColecao);
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

    public void buscarTodosRegustros(String nomeDoBanco, String nomeDaColecao) {
        DBCollection conexao = con(nomeDoBanco, nomeDaColecao);
        DBCursor cursor2 = conexao.getDB().getCollection(nomeDaColecao).find();

        while (cursor2.hasNext()) {
            System.out.println(cursor2.next());
        }

    }

}
