package com.samsul.aplikasiuser.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.samsul.aplikasiuser.data.model.data.DataGet;
import com.samsul.aplikasiuser.databinding.ItemListBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    private final ArrayList<DataGet> listData = new ArrayList<>();

    public static OnItemClickCallBack onItemClickCallBack;

    public void setOnItemClickCallBack(OnItemClickCallBack onItemClickCallBack) {
        ListAdapter.onItemClickCallBack = onItemClickCallBack;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setData(List<DataGet> list) {
        listData.clear();
        listData.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ListAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListBinding view = ItemListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ListViewHolder holder, int position) {
        holder.bind(listData.get(position));
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }


    public static class ListViewHolder extends RecyclerView.ViewHolder {

        ItemListBinding binding;

        public ListViewHolder(ItemListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(DataGet data) {
            binding.tvTitle.setText(data.getName());
            binding.tvDeslripsi.setText(data.getDeskripsi());
            byte[] imageAsBytes = Base64.decode(data.getImage(), Base64.DEFAULT);
            Bitmap decodedByte = BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.length);
            binding.imgGambar.setImageBitmap(decodedByte);

            binding.getRoot().setOnClickListener(v -> {
                onItemClickCallBack.onItemClicked(data);
            });

        }
    }

    public interface OnItemClickCallBack {
        void onItemClicked(DataGet data);
    }
}
