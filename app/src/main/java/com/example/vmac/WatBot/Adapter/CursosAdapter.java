package com.example.vmac.WatBot.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.vmac.WatBot.Model.Pfr;
import com.example.vmac.WatBot.Model.tipocurso;
import com.example.vmac.WatBot.R;
import com.example.vmac.WatBot.Service.ApiService;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LISET on 27/05/2018.
 */

public class CursosAdapter extends RecyclerView.Adapter<CursosAdapter.ViewHolder> {



    private List<tipocurso> tipocurso;
    public CursosAdapter(){
        this.tipocurso = new ArrayList<>();
    }
    public void setTipocurso(List<tipocurso> tipocurso) {
        this.tipocurso = tipocurso;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView bgimagen;
        public TextView carreras;
        public TextView textInic;
        public TextView textFin;
        public TextView textprecio;




        public ViewHolder(View itemView) {
            super(itemView);

            carreras = itemView.findViewById(R.id.carreras);
            textInic = itemView.findViewById(R.id.textinicio);
            textFin = itemView.findViewById(R.id.textfin);
            textprecio = itemView.findViewById(R.id.textprecio);
            bgimagen = itemView.findViewById(R.id.bg_image);
        }
    }

    @Override
    public CursosAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cursos, parent, false);
        return new CursosAdapter.ViewHolder(itemView);    }

    @Override
    public void onBindViewHolder(CursosAdapter.ViewHolder viewHolder, int position) {

        tipocurso tipocurso = this.tipocurso.get(position);

        viewHolder.carreras.setText(tipocurso.getNombre());
        viewHolder.textInic.setText(tipocurso.getFech_inic());
        viewHolder.textFin.setText(tipocurso.getFech_fin());
        viewHolder.textprecio.setText(tipocurso.getPrecio());

        String url = ApiService.API_BASE_URL + "/images/co/" + tipocurso.getImg_curso();
        Picasso.with(viewHolder.itemView.getContext()).load(url).into(viewHolder.bgimagen);

    }


    @Override
    public int getItemCount() {
        return this.tipocurso.size();
    }


}
