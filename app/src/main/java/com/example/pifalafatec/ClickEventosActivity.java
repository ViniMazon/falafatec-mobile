package com.example.pifalafatec;

import static com.example.pifalafatec.eventos.CalendarioDeEventosFragment.DATA;
import static com.example.pifalafatec.eventos.CalendarioDeEventosFragment.DESC;
import static com.example.pifalafatec.eventos.CalendarioDeEventosFragment.HORA;
import static com.example.pifalafatec.eventos.CalendarioDeEventosFragment.NOME;
import static com.example.pifalafatec.eventos.CalendarioDeEventosFragment.PALES;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ClickEventosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_eventos);

        Intent intent = getIntent();
        String nome_evento = intent.getStringExtra(NOME);
        String pales_evento = intent.getStringExtra(PALES);
        String hora_evento = intent.getStringExtra(HORA);
        String data_evento = intent.getStringExtra(DATA);
        String desc_evento = intent.getStringExtra(DESC);


        TextView txtNome = findViewById(R.id.txtEventoNom);
        TextView txtPales = findViewById(R.id.txtEventoPal);
        TextView txtHora = findViewById(R.id.txtEventoHora);
        TextView txtDesc = findViewById(R.id.txtEventoDesc);
        TextView txtData = findViewById(R.id.txtEventoData);

        txtNome.setText(nome_evento);
        txtPales.setText(pales_evento);
        txtHora.setText(hora_evento);
        txtDesc.setText(desc_evento);
        txtData.setText(data_evento);
    }
}