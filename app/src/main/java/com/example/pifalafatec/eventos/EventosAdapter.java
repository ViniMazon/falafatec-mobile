package com.example.pifalafatec.eventos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pifalafatec.R;

import java.util.List;

public class EventosAdapter extends RecyclerView.Adapter<EventosAdapter.ViewHolder> {
    private List<Eventos> eventosList;
    private OnItemClickListener mListener;

    public EventosAdapter(List<Eventos> eventosList) {
        this.eventosList = eventosList;

    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.eventos_list, parent, false);

        return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.txtNome.setText(eventosList.get(position).getNome());
        holder.txtHora.setText("Horário: " + eventosList.get(position).getHora());
        holder.txtData.setText("Data: " + eventosList.get(position).getData());

    }

    @Override
    public long getItemId(int position){
        return eventosList.get(position).getId();
    }

    @Override
    public int getItemCount() {
        return eventosList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtNome;
        TextView txtHora;
        TextView txtData;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNome = itemView.findViewById(R.id.txtNomeEvento);
            txtData = itemView.findViewById(R.id.txtDataEvento);
            txtHora = itemView.findViewById(R.id.txtHoraEvento);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mListener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            mListener.onItemClick(position);
                        }
                    }
                }
            });

        }
    }
}
