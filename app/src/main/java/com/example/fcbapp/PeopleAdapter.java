package com.example.fcbapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.PeopleAdapterViewHolder> {
    static PlayersDetails[] details;
    PeopleAdapter(PlayersDetails[] details) {
        this.details=details;
    }
    public static class PeopleAdapterViewHolder extends RecyclerView.ViewHolder
    {
        TextView name,pos,con;
        ImageView smalldp;
        Context mcontext;

        public PeopleAdapterViewHolder(final View itemView)
        {
            super(itemView);
            mcontext=itemView.getContext();
            name=itemView.findViewById(R.id.rectxt);
            pos=itemView.findViewById(R.id.recpos);
            con=itemView.findViewById(R.id.reccon);
            smalldp=itemView.findViewById(R.id.recimg);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i=new Intent(itemView.getContext(), Main3Activity.class);
                    i.putExtra("obj",details).putExtra("pos",getAdapterPosition());
                    itemView.getContext().startActivity(i);
                }
            });
        }
    }

    @Override
    public PeopleAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int ViewType)
    {
        Context context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.recyclerview,parent,false);
        return new PeopleAdapterViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull PeopleAdapterViewHolder holder,int position)
    {
        holder.name.setText(details[position].fname);
        holder.pos.setText(details[position].position);
        holder.con.setText(details[position].country);
        int resid=holder.mcontext.getResources().getIdentifier(details[position].imagename,"mipmap",holder.mcontext.getPackageName());
        holder.smalldp.setImageBitmap(BitmapFactory.decodeResource(holder.mcontext.getResources(),resid));
    }
    @Override
    public int getItemCount()
    {
        return details.length;
    }
}

