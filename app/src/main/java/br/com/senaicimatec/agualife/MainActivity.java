package br.com.senaicimatec.agualife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText valorPeso,valorIdade,valorNome;
    Button calculo;
    TextView resultado;

    AtletaDao atletaDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ids dos componentes para logica
        valorNome = findViewById(R.id.edit_nome);
        valorPeso = findViewById(R.id.edit_peso);
        valorIdade = findViewById(R.id.edit_idade);
        calculo = findViewById(R.id.bt_calcular);
        resultado = findViewById(R.id.txt_resultdo_ml);
        atletaDao = new AtletaDao(this);

        calculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular(v);
                salvar();
            }
        });
    }

//    metodo de calculo da qntd de agua
    public void calcular (View view){
        TextView valorPeso = findViewById(R.id.edit_peso);
        TextView valorIdade = findViewById(R.id.edit_idade);

        if(Integer.valueOf(valorIdade.getText().toString()).intValue() > 66){
            resultado.setText("" + (Integer.valueOf(valorPeso.getText().toString()).intValue() * 25) );
        }

        else if(Integer.valueOf(valorIdade.getText().toString()).intValue() >= 56
                && Integer.valueOf(valorIdade.getText().toString()).intValue() <= 66 ){
            resultado.setText("" + (Integer.valueOf(valorPeso.getText().toString()).intValue() * 30) );
        }

        else if(Integer.valueOf(valorIdade.getText().toString()).intValue() >= 18
                && Integer.valueOf(valorIdade.getText().toString()).intValue() <= 55 ){
            resultado.setText("" + (Integer.valueOf(valorPeso.getText().toString()).intValue() * 35) );
        }

        else{
            resultado.setText("" + (Integer.valueOf(valorPeso.getText().toString()).intValue() * 40) );
        }

    }

//    metodo para direcionar usuario para outra pagina
    public void abrirLista(View v){
//        deve-se criar uma intent
//        toda activity herda da classe context: classe base de permissão de recursos do dispositivo
//        passa o contexto (this) e o .class relacionado a activity criada
        Intent it_lista = new Intent(this,MainActivity2.class);
        startActivity(it_lista);
    }

//     Função para salvar os dados de um cliente a partir do que foi
//     adicionado às views e realizar a inserção no banco
    public void salvar(){
        Atleta atleta = new Atleta();

        // Define os dados de cliente a partir das entradas no layout
        atleta.setNome(valorNome.getText().toString());
        atleta.setIdade(valorIdade.getText().toString());
        atleta.setPeso(valorPeso.getText().toString());

        //Gera o id e faz a inserção dos dados no banco
        long id = atletaDao.inserir(atleta);

        //Apresenta uma pequena mensagem na tela informando que os dados foram adicionados ao banco
        Toast.makeText(this, "atleta inserido com id: "+id, Toast.LENGTH_SHORT).show();
    }

}