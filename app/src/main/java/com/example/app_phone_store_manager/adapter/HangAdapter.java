package com.example.app_phone_store_manager.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.example.app_phone_store_manager.R;
import com.example.app_phone_store_manager.model.Hang;
import com.example.app_phone_store_manager.model.KhachHang;
import com.example.app_phone_store_manager.utilities.ItemHangClick;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HangAdapter extends RecyclerView.Adapter<HangAdapter.ViewHolder> implements Filterable {
    private List<Hang> list;
    private ItemHangClick itemOnClick;
    private ItemHangClick imgDeleteOnClick;
    private TextDrawable textDrawable;
    private List<Hang> mlistHold;

    public HangAdapter(List<Hang> list) {
        this.list = list;
        this.mlistHold = list;
    }

    public void setItemOnClick(ItemHangClick itemOnClick) {
        this.itemOnClick = itemOnClick;
    }

    public void setImgDeleteOnClick(ItemHangClick imgDeleteOnClick) {
        this.imgDeleteOnClick = imgDeleteOnClick;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item_hang, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        Hang hang = list.get(position);
        if (hang == null) {
            return;
        }
        if (hang.getHinhAnh() == null) {
            String tenHang = hang.getTenHang();
            textDrawable = TextDrawable.builder().beginConfig().width(48).height(48).endConfig().buildRect(tenHang.substring(0, 1).toUpperCase(), getRandomColor());
            holder.imgHang.setImageDrawable(textDrawable);
        } else {
            Bitmap bitmap = BitmapFactory.decodeByteArray(hang.getHinhAnh(), 0, hang.getHinhAnh().length);
            holder.imgHang.setImageBitmap(bitmap);
        }
        holder.tvMaHang.setText("Mã hãng: " + hang.getMaHang());
        holder.tvTenHang.setText("Tên hãng: " + hang.getTenHang());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemOnClick.ItemClick(hang);
            }
        });
        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgDeleteOnClick.ItemClick(hang);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override
    public Filter getFilter() {
       return new Filter() {
           @Override
           protected FilterResults performFiltering(CharSequence constraint) {
               String serH = constraint.toString();
               if (serH.isEmpty()) {
                   list = mlistHold;
               } else {
                   List<Hang> listh = new ArrayList<>();
                   for (Hang hang : mlistHold) {
                       if (hang.getMaHang().toLowerCase().contains(serH.toLowerCase()) ||
                               hang.getTenHang().toLowerCase().contains(serH.toLowerCase())) {
                           listh.add(hang);
                       }
                   }
                   list = listh;
               }
               FilterResults filterResults = new FilterResults();
               filterResults.values = list;
               return filterResults;
           }

           @Override
           protected void publishResults(CharSequence constraint, FilterResults results) {
               list = (List<Hang>) results.values;
               notifyDataSetChanged();
           }
       };
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgHang, imgDelete;
        private TextView tvMaHang, tvTenHang;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            imgHang = itemView.findViewById(R.id.imgHang);
            imgDelete = itemView.findViewById(R.id.imgDelHang);
            tvMaHang = itemView.findViewById(R.id.tvMaHang);
            tvTenHang = itemView.findViewById(R.id.tvTenHang);
        }
    }
    public void filter(List<Hang> list){
        this.list = list;
        notifyDataSetChanged();
    }
    public int getRandomColor() {
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }
}
