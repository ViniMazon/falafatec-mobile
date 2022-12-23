package com.example.pifalafatec;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.pifalafatec.eventos.Eventos;
import com.example.pifalafatec.eventos.EventosAdapter;
import com.example.pifalafatec.eventos.RetrofitClientEventos;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewActivity extends AppCompatActivity implements EventosAdapter.OnItemClickListener {
/*
    public static final String NOME = "nome_evento";
    public static final String DATA = "data_evento";
    public static final String PALES = "palestrante_evento";
    public static final String HORA = "hora_evento";
    public static final String DESC = "desc_evento";

 */
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    EventosAdapter adapter;
    List<Eventos> eventosList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        recyclerView = findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new EventosAdapter(eventosList);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(ViewActivity.this);

        fetchEventos();

    }

    private void fetchEventos(){


        RetrofitClientEventos.getRetrofitClient().getEventos().enqueue(new Callback<List<Eventos>>() {
            @Override
            public void onResponse(Call<List<Eventos>> call, Response<List<Eventos>> response) {
                if(response.isSuccessful() && response.body() != null){
                    eventosList.addAll(response.body());
                    adapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<List<Eventos>> call, Throwable t) {
                Toast.makeText(ViewActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });



       //RetrofitClientEventos.getRetrofitClient().eventos();

    }

    @Override
    public void onItemClick(int position) {
        /*
        Intent intent = new Intent(this, MainActivity2.class);
        Eventos clickedItem = eventosList.get(position);
        intent.putExtra(NOME, clickedItem.getNome());
        intent.putExtra(DATA, clickedItem.getData());
        intent.putExtra(PALES, clickedItem.getPalestrante());
        intent.putExtra(HORA, clickedItem.getHora());
        intent.putExtra(DESC, clickedItem.getDescricao());



        startActivity(intent);
        */

    }
}