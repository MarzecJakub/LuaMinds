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
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.MyViewHolder2> {

    Context context;
    ArrayList<Tasks> tasksArrayList;

    public MyAdapter2(Context context, ArrayList<Tasks> tasksArrayList) {
        this.context = context;
        this.tasksArrayList = tasksArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_item_tasks,parent,false);
        return new MyViewHolder2(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder2 holder, int position) {
        Tasks tasks = tasksArrayList.get(position);
        holder.titleTask.setText(tasks.titleTask);
        holder.picPlayTask.setImageResource(tasks.picTask);


        holder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(view);
                int position = holder.getAdapterPosition();
//                Log.d("tag", tasksArrayList.toString());
//                Log.d("tag2",String.valueOf(tasks.taskText));
                navController.navigate(tasksFragmentDirections.actionTasksFragmentToTasksShow(position, tasks.titleTask, tasks.taskText, tasks.taskPic, tasks.taskSol));

//                if(holder.getAdapterPosition() == 0){
//                    navController.navigate(R.id.action_lekcjeFragment_to_lekcja1); //do zmiany
//                } else if (holder.getAdapterPosition() == 1) {
//                    navController.navigate(R.id.action_lekcjeFragment_to_lekcja2); //do zmiany
//                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return tasksArrayList.size();
    }

    public static class MyViewHolder2 extends RecyclerView.ViewHolder {
        ImageView picPlayTask;
        TextView titleTask;

        public MyViewHolder2(@NonNull View itemView) {
            super(itemView);
            titleTask = itemView.findViewById(R.id.titleItemTasks);
            picPlayTask = itemView.findViewById(R.id.picItemTasks);
        }


    }

}
