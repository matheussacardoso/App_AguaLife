package br.com.senaicimatec.agualife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    ListView listView;

    AtletaDao atletaDao;
    List<Atleta> atleta;
    List<Atleta> atletaFilter = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listView =  findViewById(R.id.listaAtleta);

        atletaDao = new AtletaDao(this);
        atleta = atletaDao.Listar();

        atletaFilter.addAll(atleta);

        ArrayAdapter<Atleta> arrayAdapter = new ArrayAdapter<Atleta>(this,
                android.R.layout.simple_list_item_1, atletaFilter);
        listView.setAdapter(arrayAdapter);
    }

    public void abrirCadastro(View v){
        //deve-se criar uma intent
        //toda activity herda da classe context: classe base de permissão de recursos do dispositivo
        //passa o contexto (this) e o .class relacionado a activity criada
        Intent it_cadastro = new Intent(this,MainActivity.class);
        startActivity(it_cadastro);
    }

    @Override
    public void onResume(){
        super.onResume();//chamar o metodo da classe mãe
        atleta = atletaDao.Listar(); //receber todos os dados
        atletaFilter.clear();
        atletaFilter.addAll(atleta); //adicionar os dados atualizados da nova lista
        listView.invalidateViews(); //inativar os dados antigos da listview para exibir os novos dados

    }
}