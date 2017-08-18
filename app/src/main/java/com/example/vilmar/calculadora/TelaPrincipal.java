package com.example.vilmar.calculadora;

import android.media.MediaCodec;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.regex.Pattern;

public class TelaPrincipal extends AppCompatActivity {

    private TextView __textoView;// variavel que será usada para armazenar o texto que tiver no textview da tela
    private String __Texto="";// variavel que será usada para atualizar o texto da tela na textview
    private  String Operador="";

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
    public double operacao (String a, String b, String op)
    {
        switch (op)
        {
            case "+": return Double.valueOf(a) + Double.valueOf(b);
            case "-": return Double.valueOf(a) - Double.valueOf(b);
            case "X": return Double.valueOf(a)* Double.valueOf(b);
            case "/":
                try {
                    return Double.valueOf(a) / Double.valueOf(b);
                }catch (Exception e)
                {
                        Log.d("Calc",e.getMessage());
                }
            default: return -1;
        }

    }

    public void onClickEqual (View v)
    {
        String[] numeros= __Texto.split(Pattern.quote(Operador));
        if(numeros.length<2) return ;

        double result=operacao(numeros[0],numeros[1],Operador);

        __textoView.setText(__Texto+"\n"+ String.valueOf(result));
    }

}
