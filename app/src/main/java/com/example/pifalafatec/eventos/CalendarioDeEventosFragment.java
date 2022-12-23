package com.example.pifalafatec.eventos;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.pifalafatec.ClickEventosActivity;
import com.example.pifalafatec.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CalendarioDeEventosFragment extends Fragment  implements EventosAdapter.OnItemClickListener{
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    RecyclerView recyclerView;
    ProgressBar progressBar;
    LinearLayoutManager layoutManager;
    EventosAdapter adapter;
    List<Eventos> eventosList = new ArrayList<>();
    SwipeRefreshLayout swipeRefreshLayout;

    public static final String NOME = "nome_evento";
    public static final String DATA = "data_evento";
    public static final String PALES = "palestrante_evento";
    public static final String HORA = "hora_evento";
    public static final String DESC = "desc_evento";

    private String mParam1;
    private String mParam2;

    public CalendarioDeEventosFragment() {
    }

    public static CalendarioDeEventosFragment newInstance(String param1, String param2) {
        CalendarioDeEventosFragment fragment = new CalendarioDeEventosFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_calendario_de_eventos, container, false);

        recyclerView = rootView.findViewById(R.id.recyclerView);
        swipeRefreshLayout = rootView.findViewById(R.id.swipeRefresh);
        progressBar = rootView.findViewById(R.id.progressBar);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new EventosAdapter(eventosList);
        adapter.setHasStableIds(true);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(this);
        swipeRefreshLayout.setRefreshing(false);

        //eventosList.get(getId());

/*
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(false);
                fetchEventos();
                adapter.notifyDataSetChanged();
            }
        });

 */
        fetchEventos();
        return rootView;

    }

    private void fetchEventos() {
        //progressBar.setVisibility(View.VISIBLE);
        RetrofitClientEventos.getRetrofitClient().getEventos().enqueue(new Callback<List<Eventos>>() {
            @Override
            public void onResponse(Call<List<Eventos>> call, Response<List<Eventos>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    eventosList.addAll(response.body());
                    adapter.notifyDataSetChanged();
                    //Toast.makeText(getContext(), "", Toast.LENGTH_SHORT).show();
                    
                }
                else{
                    Toast.makeText(getActivity(), "", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Eventos>> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(getActivity(), ClickEventosActivity.class);
        Eventos clickedItem = eventosList.get(position);
        intent.putExtra(NOME, clickedItem.getNome());
        intent.putExtra(DATA, clickedItem.getData());
        intent.putExtra(PALES, clickedItem.getPalestrante());
        intent.putExtra(HORA, clickedItem.getHora());
        intent.putExtra(DESC, clickedItem.getDescricao());

        startActivity(intent);
    }
}