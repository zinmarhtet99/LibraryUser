package com.example.myapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.Adapter.CategoryAdapter;
import com.example.myapp.Api.ApiUtils;
import com.example.myapp.Api.Apiinterface;
import com.example.myapp.Model.Category;
import com.example.myapp.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryFragment extends Fragment {
    View rootView;
    RecyclerView recyclerView;

    Apiinterface apiinterface;
    CategoryAdapter categoryAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.category_recyclerview_fragment, container, false);
        apiinterface= ApiUtils.getApi();

        recyclerView = rootView.findViewById(R.id.recyclerview_category);


        Call<List<Category>> getCategory = apiinterface.getAllCategory();
        getCategory.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                LoadCategoryList(response.body());
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                Toast.makeText(getContext(), t.toString(), Toast.LENGTH_LONG).show();
            }
        });

        GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager);
        return rootView;
    }


        public void LoadCategoryList(List<Category> categoryList){
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

            categoryAdapter=new CategoryAdapter(getContext(),categoryList);
            recyclerView.setAdapter(categoryAdapter);
        }



    }

