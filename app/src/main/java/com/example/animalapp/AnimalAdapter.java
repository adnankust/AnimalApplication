package com.example.animalapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.AnimalRowHolder> {
    ArrayList<Animal> animals;
    Context context;
    MyClickInterface myClickInterface;

    public AnimalAdapter(ArrayList<Animal> animals, Context context, MyClickInterface myClickInterface) {
        this.animals = animals;
        this.context = context;
        this.myClickInterface = myClickInterface;
    }

    @NonNull
    @Override
    public AnimalRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.animal_row, parent, false);
        return new AnimalRowHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalRowHolder holder, int position) {
       holder.txtAnimalName.setText(animals.get(position).getName());
       holder.imgAnimal.setImageResource(animals.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return animals.size();
    }

    class AnimalRowHolder extends RecyclerView.ViewHolder {

        TextView txtAnimalName;
        ImageView imgAnimal;

        public AnimalRowHolder(@NonNull View itemView) {
            super(itemView);
            txtAnimalName = itemView.findViewById(R.id.txt_animal_name);
            imgAnimal = itemView.findViewById(R.id.img_animal);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    myClickInterface.onItemClick(getAdapterPosition());
                }
            });
        }

    }

    interface MyClickInterface{
        void onItemClick(int positionOfTheAnimal);
    }
}
