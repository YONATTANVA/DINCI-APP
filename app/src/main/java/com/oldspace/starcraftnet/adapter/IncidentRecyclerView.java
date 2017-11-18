package com.oldspace.starcraftnet.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.oldspace.starcraftnet.Model.Incident;
import com.oldspace.starcraftnet.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by YonattanVisita on 18/11/2017.
 */

//esta clase se encarga de la lista, reciclar
    //como parametro se pasa un arreglo de vistas de cardView, es decir su clase interna
public class IncidentRecyclerView extends RecyclerView.Adapter<IncidentRecyclerView.IncidentViewHolder>{

    private ArrayList<Incident> incidents;
    private int resource;// el recurso layout cardview(xml)
    private Activity activity;//la actividad desde donde se llama la clase.

    public IncidentRecyclerView(ArrayList<Incident> incidents, int resources, Activity activity) {
        this.incidents = incidents;
        this.resource = resources;
        this.activity = activity;
    }

    //en este metodo devuelve el objeto ViewHolder(cardview) inicializado
    @Override
    public IncidentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //el metedo inflate, lo que hace es pasar un archivo xml en codigo java
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new IncidentViewHolder(view);
    }

    //en este metodo el translado de datos de los objetos del array al cardview
    @Override
    public void onBindViewHolder(IncidentViewHolder holder, int position) {
        Incident incident = incidents.get(position);//asigna una posicion para cada objeto
        Picasso.with(activity).load(incident.getImage()).into(holder.cardImage);
        holder.cardName.setText(incident.getName());
        holder.cardTime.setText(incident.getTime());
        holder.cardSolution.setText(incident.getSolution());

    }

    //este metodo devuelve la cantidad de cardviews que se van a mostrar en total
    @Override
    public int getItemCount() {
        return incidents.size();
    }

    //Esta clase se encarga de manejar el cardview
    public class IncidentViewHolder extends RecyclerView.ViewHolder{

        //Componentes del CardView
        private ImageView cardImage;
        private TextView cardName;
        private TextView cardTime;
        private TextView cardSolution;

        public IncidentViewHolder(View itemView) {
            super(itemView);
            //el parametro itemView es un layout(cardview)
            cardImage = (ImageView) itemView.findViewById(R.id.cardImage);
            cardName = (TextView) itemView.findViewById(R.id.cardName);
            cardTime = (TextView) itemView.findViewById(R.id.cardTime);
            cardSolution = (TextView) itemView.findViewById(R.id.cardSolution);
        }
    }
}
