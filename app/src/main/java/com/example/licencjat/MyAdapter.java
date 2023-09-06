package com.example.licencjat;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    Context context;
    ArrayList<Lekcje> lekcjeArrayList;

    public MyAdapter(Context context, ArrayList<Lekcje> lekcjeArrayList) {
        this.context = context;
        this.lekcjeArrayList = lekcjeArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
        return new MyViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Lekcje lekcje = lekcjeArrayList.get(position);
        holder.tytulLekcji.setText(lekcje.tytul);
        holder.zdjeciePlay.setImageResource(lekcje.zdjecie);
        holder.itemView.setOnClickListener(view -> {
            NavController navController = Navigation.findNavController(view);
            Log.d("asd", lekcje.tytul);

            if(holder.getAdapterPosition() == 0){
                navController.navigate(R.id.action_lekcjeFragment_to_lesson0);
            } else if (holder.getAdapterPosition() == 7) {
                navController.navigate(R.id.action_lekcjeFragment_to_lesson7);
            } else if (holder.getAdapterPosition() == 8) {
                navController.navigate(R.id.action_lekcjeFragment_to_lesson8);
            }
        });

//        holder.itemView.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View view) {
//                NavController navController = Navigation.findNavController(view);
//                if(holder.getAdapterPosition() == 0){
//                    navController.navigate(R.id.action_lekcjeFragment_to_lekcja1);
////                    LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
////                    View newView = inflater.inflate(R.layout.new_layout, null);
////                    container.addView(newView);
//                } else if (holder.getAdapterPosition() == 1) {
//                    navController.navigate(R.id.action_lekcjeFragment_to_lekcja2);
//                }
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return lekcjeArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView zdjeciePlay;
        TextView tytulLekcji;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tytulLekcji = itemView.findViewById(R.id.titleItem);
            zdjeciePlay = itemView.findViewById(R.id.picItem);
        }




    }
}
