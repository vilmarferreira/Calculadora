package com.example.vilmar.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TelaPrincipal extends AppCompatActivity {

    private TextView __textoView;// variavel que será usada para armazenar o texto que tiver no textview da tela
    private String __Texto="";// variavel que será usada para atualizar o texto da tela na textview
    private  String Operador;

     @Override
     protected void onCreate(Bundle savedInstanceState)
     {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_tela_principal);
         __textoView= (TextView)findViewById(R.id.textView2);
         __textoView.setText(__Texto);
    }

    public void updateTela()
    {
        __textoView.setText(__Texto);
    }
    public void onClickNumber(View v)
    {
        Button b= (Button) v;
        __Texto += b.getText(); // pegar o texto já existente e vai concatenar com o texto do botão selecionado
        updateTela();
    }
    public void onClickOperador (View v)
    {
        Button b= (Button) v;
        __Texto += b.getText(); // pegar o texto já existente e vai concatenar com o texto do botão selecionado
        Operador=b.getText().toString(); // vai pegar o valor do operador
        updateTela();
    }
    public void clear ()
    {
        __Texto="";
        Operador="";
    }
    public void OnClickClear(View v)
    {
        clear();
        updateTela();
    }
}
