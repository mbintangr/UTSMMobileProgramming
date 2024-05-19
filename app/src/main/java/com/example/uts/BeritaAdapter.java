package com.example.uts;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class BeritaAdapter extends BaseAdapter {

    private Context context;
    private List<BeritaData> dataSource;

    public BeritaAdapter(Context context, List<BeritaData> dataSource) {
        this.context = context;
        this.dataSource = dataSource;
    }

    @Override
    public int getCount() {
        return dataSource.size();
    }

    @Override
    public Object getItem(int position) {
        return dataSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder holder;

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
            holder = new ViewHolder();
            holder.ivBerita = view.findViewById(R.id.ivBerita);
            holder.tvJudul = view.findViewById(R.id.tvJudul);
            holder.tvDeskripsi = view.findViewById(R.id.tvDeskripsi);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }

        BeritaData beritaData = (BeritaData) getItem(position);
        holder.tvJudul.setText(beritaData.judul);
        holder.tvDeskripsi.setText(beritaData.deskripsi);
        Glide.with(context)
                .load(beritaData.imageUrl)
                .into(holder.ivBerita);

        view.setOnClickListener(v -> {
            Intent intent = new Intent(context, BeritaDetailsActivity.class);
            intent.putExtra("judul", beritaData.judul);
            intent.putExtra("deskripsi", beritaData.deskripsi);
            intent.putExtra("imageUrl", beritaData.imageUrl);
            intent.putExtra("beritaContent", beritaData.beritaContent);
            context.startActivity(intent);
        });

        return view;
    }

    private static class ViewHolder {
        ImageView ivBerita;
        TextView tvJudul;
        TextView tvDeskripsi;
    }
}
