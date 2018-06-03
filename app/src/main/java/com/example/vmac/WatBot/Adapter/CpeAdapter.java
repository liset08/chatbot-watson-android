package com.example.vmac.WatBot.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vmac.WatBot.Activities.DetallesPfr;
import com.example.vmac.WatBot.Model.Cpe;
import com.example.vmac.WatBot.Model.Pfr;
import com.example.vmac.WatBot.R;
import com.example.vmac.WatBot.Service.ApiService;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LISET on 30/05/2018.
 */

public class CpeAdapter extends RecyclerView.Adapter<CpeAdapter.ViewHolder> {

    private List<Cpe> cpe;
    private Activity activity;

    public CpeAdapter(){
        this.cpe = new ArrayList<>();
    }
    public void setCpe(List<Cpe> cpe){
        this.cpe = cpe;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView namecurso;
        public TextView nombre;
        public TextView fechinicio;
        public TextView precio;
        public TextView duracion;




        public ViewHolder(View itemView)
            super(itemView);

            nombre = itemView.findViewById(R.id.carreras);
            namecurso = itemView.findViewById(R.id.carreras1);
            fechinicio = itemView.findViewById(R.id.textinicio);
            precio = itemView.findViewById(R.id.textprecio);
            duracion= itemView.findViewById(R.id.textduracion);


        }}

    @Override
    public CpeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pce, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CpeAdapter.ViewHolder viewHolder, int position) {
        final Cpe cpe = this.cpe.get(position);

        viewHolder.nombre.setText(cpe.getNombre());
        viewHolder.namecurso.setText( cpe.getArea());
        viewHolder.fechinicio.setText( cpe.getFec_inic());
        viewHolder.precio.setText( cpe.getPrecio());
        viewHolder.duracion.setText( cpe.getDuracion());



       /* viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, DetallesPfr.class);
                intent.putExtra("id", pfr.getId());
                activity.startActivity(intent);
            }
        });*/
    }



    @Override
    public int getItemCount() {
        return this.cpe.size();
    }
}
