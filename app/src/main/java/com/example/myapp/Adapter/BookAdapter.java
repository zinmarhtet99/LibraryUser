package com.example.myapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapp.BookDetailActivity;
import com.example.myapp.Model.Book;
import com.example.myapp.R;
import com.example.myapp.Utils.FontEmbedder;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {
    private Context context;
    private List<Book> bookList;

    public BookAdapter(Context context, List<Book> bookList) {
        this.context = context;
        this.bookList = bookList;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_recyclerview_item_row, parent, false);
        return new BookViewHolder(view);
    }

    public void onBindViewHolder(@NonNull final BookViewHolder holder, final int position) {
        FontEmbedder.force(holder.txttitle,bookList.get(position).getTitle().toString());
        FontEmbedder.force(holder.txtauthor,bookList.get(position).getAuthor().getName().toString());
        Glide.with(context)
                .load("https://culibrary1.000webhostapp.com/"+bookList.get(position).getImage())
                .into(holder.imageView);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, BookDetailActivity.class);
                intent.putExtra("Image",bookList.get(position).getImage().toString());
                intent.putExtra("Title",bookList.get(position).getTitle().toString());
                intent.putExtra("CategoryName",bookList.get(position).getCategory().getCategoryName().toString());
                intent.putExtra("Author",bookList.get(position).getAuthor().getName().toString());
                intent.putExtra("Publisher",bookList.get(position).getPublisher().toString());
                intent.putExtra("Edition",bookList.get(position).getEdition().toString());
                intent.putExtra("Recommand",bookList.get(position).getRecommand().toString());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {

        return bookList
                .size();
    }

    class BookViewHolder extends RecyclerView.ViewHolder {
        Button btnall, btnavailable;
        ImageView imageView;
        TextView txtauthor,txttitle;
        LinearLayout linearLayout;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            btnall = itemView.findViewById(R.id.btnAll);
            btnavailable = itemView.findViewById(R.id.btnAvailable);
            imageView = itemView.findViewById(R.id.bookimage);
            txtauthor=itemView.findViewById(R.id.txtauthor);
            txttitle=itemView.findViewById(R.id.txttitle);

            linearLayout=itemView.findViewById(R.id.book_detail);
        }
    }
}