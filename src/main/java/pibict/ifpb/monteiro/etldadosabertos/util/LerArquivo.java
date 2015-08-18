package pibict.ifpb.monteiro.etldadosabertos.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import pibict.ifpb.monteiro.etldadosabertos.constantes.ConstantesDoSistema;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 18/08/2015
 */
public class LerArquivo {

    public void lerArquivoTxt() {

        try {
            int i = 0;
            String atributos = null;
            
            BufferedReader lerArq = new BufferedReader(new InputStreamReader(new FileInputStream(ConstantesDoSistema.arquivo), "UTF-8"));

            String linha = lerArq.readLine();

            if(i == 0) {
                atributos = linha.replace("\"", " ");
                linha = lerArq.readLine();
                i++;
            }
            
            while (linha != null) {
                System.out.println(atributos);
               linha = linha.replace("\"", " ");
                System.out.println(linha);

                linha = lerArq.readLine();
            }

        } catch (IOException e) {

            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }
        System.out.println();
    }

}
