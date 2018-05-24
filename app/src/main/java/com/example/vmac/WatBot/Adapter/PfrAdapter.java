package com.example.vmac.WatBot.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vmac.WatBot.Model.Pfr;
import com.example.vmac.WatBot.R;
import com.example.vmac.WatBot.Service.ApiService;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LISET on 22/05/2018.
 */

public class PfrAdapter extends RecyclerView.Adapter<PfrAdapter.ViewHolder> {

    private List<Pfr> pfr;
    public PfrAdapter(){
        this.pfr = new ArrayList<>();
    }
    public void setProductos(List<Pfr> pfr){
        this.pfr = pfr;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView fotoImage;
    public TextView description;
    public TextView nombre;
    public TextView sede;


    public ViewHolder(View itemView) {
        super(itemView);

        nombre = itemView.findViewById(R.id.nombre_text);
        description = itemView.findViewById(R.id.carreras_text);
        sede = itemView.findViewById(R.id.sede_text);
        fotoImage = itemView.findViewById(R.id.foto_image);

    }}

    @Override
    public PfrAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pfr, parent, false);
        return new ViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(PfrAdapter.ViewHolder viewHolder, int position) {
        Pfr pfr = this.pfr.get(position);

        viewHolder.nombre.setText(pfr.getNombre());
        viewHolder.description.setText(pfr.getDescripcion());
        viewHolder.sede.setText( pfr.getSede());


        String url = ApiService.API_BASE_URL + "/images/" + pfr.getImg_carrera();
        Picasso.with(viewHolder.itemView.getContext()).load(url).into(viewHolder.fotoImage);


    }

    @Override
    public int getItemCount() {
        return this.pfr.size();
    }


}
