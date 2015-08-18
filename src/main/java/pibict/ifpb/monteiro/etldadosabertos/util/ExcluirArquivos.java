package pibict.ifpb.monteiro.etldadosabertos.util;

import java.io.File;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 18/08/2015
 */
public class ExcluirArquivos {

    public static void removerArquivos(String diretorio) {
        File f = new File(diretorio);
        // Se o arquivo passado for um diretório
        if (f.isDirectory()) {
            /* Lista todos os arquivos do diretório em um array
             de objetos File */
            File[] files = f.listFiles();
            // Identa a lista (foreach) e deleta um por um
            for (File file : files) {
                file.delete();
            }
        }
    }

}
