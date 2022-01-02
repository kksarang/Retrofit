package com.example.retrofitfullfill.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.retrofitfullfill.Model.CategoryModel;
import com.example.retrofitfullfill.R;

import java.util.ArrayList;

public class SecondAdapter extends RecyclerView.Adapter<SecondAdapter.ViewHolder> {

    private ArrayList<CategoryModel> arrayList;
    private Context context;

    public SecondAdapter(ArrayList<CategoryModel> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

  CategoryModel model = arrayList.get(position);

  holder.name.setText(model.getName());
  holder.size.setText(model.getNumber_of_courses());
        Glide.with(holder.img.getContext()).load(model.getThumbnail()).into(holder.img);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name,size;
        ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.category_txt);
            size=itemView.findViewById(R.id.category_size);

            img=itemView.findViewById(R.id.category_img);
        }
    }
}
