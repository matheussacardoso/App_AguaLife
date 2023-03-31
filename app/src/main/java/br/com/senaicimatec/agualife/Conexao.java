package br.com.senaicimatec.agualife;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Conexao extends SQLiteOpenHelper {

    //Declarando as constantes
    private static final String nome = "banco2.db";
    private static final int version = 1;

    // Construtor da classe
    public Conexao(Context context){
        super(context, nome, null, version);
    }

    //Função que será executada quando o app for inciado
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Método que executa um comando SQL diretamente no banco
        // Cria a tabela de clientes
        db.execSQL("CREATE TABLE IF NOT EXISTS atleta(" +
                "id INTEGER PRIMARY KEY autoincrement," +
                "nome VARCHAR(50)," +
                "idade VARCHAR(50)," +
                "peso VARCHAR(50))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
