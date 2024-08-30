package com.example.recipe.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipe.Models.Recipe;
import com.example.recipe.R;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

public class RandomRecipeAdapter extends RecyclerView.Adapter<RandomRecipeViewHolder>{

    Context context;
    List<Recipe> list;

    public RandomRecipeAdapter(Context context, List<Recipe> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RandomRecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_random_recipe,parent,false);
        return new RandomRecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RandomRecipeViewHolder holder, int position) {
        Recipe model = list.get(position);
        holder.tv_title.setText(model.title);
        holder.tv_title.setSelected(true);
        holder.tv_likes.setText(model.aggregateLikes+" likes");
        holder.tv_servings.setText(model.servings+" Servings");
        holder.tv_time.setText(model.readyInMinutes+" minutes");
        Picasso.get().load(model.image).into(holder.image_view_food);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
class RandomRecipeViewHolder extends RecyclerView.ViewHolder{

    CardView random_list_container;
    TextView tv_title,tv_servings,tv_likes,tv_time;
    ImageView image_view_food;

    public RandomRecipeViewHolder(@NonNull View itemView) {
        super(itemView);
        random_list_container = itemView.findViewById(R.id.random_container);
        tv_title = itemView.findViewById(R.id.tv_title);
        tv_servings = itemView.findViewById(R.id.tv_servings);
        tv_likes = itemView.findViewById(R.id.tv_likes);
        tv_time = itemView.findViewById(R.id.tv_time);

        image_view_food = itemView.findViewById(R.id.imageView_food);

    }
}