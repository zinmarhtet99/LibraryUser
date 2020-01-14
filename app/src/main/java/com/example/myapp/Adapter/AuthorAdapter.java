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

import com.example.myapp.AuthorDetailActivity;
import com.example.myapp.Model.Author;
import com.example.myapp.R;
import com.example.myapp.Utils.FontEmbedder;

import java.util.List;

public class AuthorAdapter extends RecyclerView.Adapter<AuthorAdapter.AuthorViewHolder> {

    private Context context;
    private List<Author> authorList;

    public AuthorAdapter(Context context, List<Author> authorList) {
        this.context = context;
        this.authorList = authorList;
    }

    @NonNull
    @Override
    public AuthorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.author_recyclerview_row_item, parent, false);
        return new AuthorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AuthorAdapter.AuthorViewHolder holder, final int position) {
        FontEmbedder.force(holder.tauthor, authorList.get(position).getName());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, AuthorDetailActivity.class);
                intent.putExtra("Id",authorList.get(position).getId()+"");
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return authorList.size();
    }

    class AuthorViewHolder extends RecyclerView.ViewHolder {

        TextView tauthor;
        CardView cardView;

        public AuthorViewHolder(@NonNull View itemView) {
            super(itemView);
            tauthor = itemView.findViewById(R.id.author1);
            cardView=itemView.findViewById(R.id.author_cardView);
        }
    }
}