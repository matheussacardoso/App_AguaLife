package br.com.senaicimatec.agualife;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

// Classe que fará a ligação entre o banco e a aplicação
public class AtletaDao {

//    Declarando os campos
    private Conexao conexao;
    private SQLiteDatabase banco;
    public ListView listViewDados;

//     Construtor da classe
    public AtletaDao(Context context){
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public long inserir(Atleta atleta){
        ContentValues values = new ContentValues();

        //Declaração de pares chave-valor para receber os dados do cliente
        values.put("nome",atleta.getNome());
        values.put("peso",atleta.getPeso());
        values.put("idade",atleta.getIdade());

        //Realiza o insert no banco
        return banco.insert("atleta", "null", values);
    }

    public List<Atleta> Listar() {
//         Cria uma list de clientes
        List<Atleta> listaAtleta = new ArrayList<>();

//        Cria um cursor para verificar os registros nas tabelas, nesse caso "cliente".
//        Cria-se um array do tipo de string que possui os atributos da tabela
        Cursor cursor = banco.query("atleta", new String[]{"id", "nome","idade","peso"}, null,
                null, null, null, null, null);

//         Laço que adiciona os clientes na lista a medida que o cursor encontra registros
        while (cursor.moveToNext()) {

//             Instancia o objeto cliente
            Atleta atleta = new Atleta();

//            Seta o id e nome a partir do array criado do cursor, que referencia o registro.
//            A partir disso, é adicionado o id e nome no objeto cliente

            atleta.setId(cursor.getInt(0));
            atleta.setNome(cursor.getString(1));
            atleta.setIdade(cursor.getString(2));
            atleta.setPeso(cursor.getString(3));

//             Adiciona o cliente na lista
            listaAtleta.add(atleta);
        }
        return listaAtleta;
    }

    public void Excluir(Atleta atleta){
        banco.delete("atleta","id=?",new String[]{atleta.getId().toString()});
    }
}
