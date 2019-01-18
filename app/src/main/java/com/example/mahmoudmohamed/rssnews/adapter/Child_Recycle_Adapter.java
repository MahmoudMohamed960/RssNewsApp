package com.example.mahmoudmohamed.rssnews.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mahmoudmohamed.rssnews.R;
import com.example.mahmoudmohamed.rssnews.data.room.models.Article_Info_Model;
import com.example.mahmoudmohamed.rssnews.help.Helper_Class;


import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Child_Recycle_Adapter extends RecyclerView.Adapter<Child_Recycle_Adapter.Providor_Holder> {
    private List<Article_Info_Model> listModel;
    private Context context;
    private LayoutInflater inflater;
    private Helper_Class help;

    public Child_Recycle_Adapter(Context context) {
        this.context = context;
        listModel = new ArrayList<>();
        inflater = LayoutInflater.from(context);
        help = new Helper_Class(context);
    }

    @NonNull
    @Override
    public Providor_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item_child_recycle_view, parent, false);
        return new Providor_Holder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull Providor_Holder holder, int position) {
        Article_Info_Model model = listModel.get(position);
        System.out.println(model.getArticleTitle());
        holder.titleArticleTv.setText(model.getArticleTitle());
        String imageURL = model.getArticleImage();
        Glide.with(context).load(imageURL).into(holder.imageArticleIv);
        help.textViewLink(holder.more,null);
    }

    @Override
    public int getItemCount() {
        return listModel.size();
    }

    public void setData(List<Article_Info_Model> listModel ){
        this.listModel = listModel;
        notifyDataSetChanged();
    }
    public class Providor_Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.title_article_tv)
        TextView titleArticleTv;
        @BindView(R.id.more)
        TextView more;
        @BindView(R.id.image_article_iv)
        ImageView imageArticleIv;

        public Providor_Holder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
