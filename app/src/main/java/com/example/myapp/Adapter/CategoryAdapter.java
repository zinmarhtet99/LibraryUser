package com.example.myapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.CategoryDetailActivity;
import com.example.myapp.Model.Category;
import com.example.myapp.R;
import com.example.myapp.Utils.FontEmbedder;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoriesViewHolder> {
    private Context context;
    private List<Category> categoryList;

    public CategoryAdapter(Context context, List<Category> categoryList) {
        this.context = context;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.category_recyclerview_item_row,parent,false);

        return new CategoriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesViewHolder holder, final int position) {

        FontEmbedder.force(holder.name,categoryList.get(position).getCategoryName());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(context, CategoryDetailActivity.class);
                intent.putExtra("Id",categoryList.get(position).getId()+"");
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }
    class CategoriesViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        CardView cardView;
        public CategoriesViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.category);
            cardView=itemView.findViewById(R.id.category_cardView);

        }
    }


}

