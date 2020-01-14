package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.myapp.Utils.FontEmbedder;

public class BookDetailActivity extends AppCompatActivity {

    TextView txttitle,txtauthor,txtpublisher,txtedition,txtrecommend,txtcname;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_detail_activity);

        imageView=findViewById(R.id.book_image);
        txttitle=findViewById(R.id.book_title);

        txtauthor=findViewById(R.id.author_name);
        txtpublisher=findViewById(R.id.publisher);
        txtedition=findViewById(R.id.edition);
        txtrecommend=findViewById(R.id.recommend);
        txtcname=findViewById(R.id.category_name);

        Intent intent=getIntent();
        String image=intent.getStringExtra("Image");
        String title=intent.getStringExtra("Title");
        String cname=intent.getStringExtra("CategoryName");
        String author=intent.getStringExtra("Author");
        String publiser=intent.getStringExtra("Publisher");
        String edition=intent.getStringExtra("Edition");
        String recommend=intent.getStringExtra("Recommand");

        Glide.with(getApplicationContext())
                .load("https://culibrary1.000webhostapp.com/"+image)
                .into(imageView);

        FontEmbedder.force(txttitle,title);
        FontEmbedder.force(txtcname,cname);
        FontEmbedder.force(txtauthor,author);
        FontEmbedder.force(txtpublisher,publiser);
        FontEmbedder.force(txtedition,edition);
        FontEmbedder.force(txtrecommend,recommend);

    }
}
