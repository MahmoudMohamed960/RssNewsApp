package com.example.mahmoudmohamed.rssnews.adapter;

import android.content.Context;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mahmoudmohamed.rssnews.R;
import com.example.mahmoudmohamed.rssnews.data.room.interfaces.Data_Operations_Interface;
import com.example.mahmoudmohamed.rssnews.data.room.models.Article_Info_Model;
import com.example.mahmoudmohamed.rssnews.data.room.models.DataBase_Model;
import com.example.mahmoudmohamed.rssnews.data.room.models.Provider_Names_Model;


import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;


public class Parent_Recycle_Adapter extends RecyclerView.Adapter<Parent_Recycle_Adapter.Providor_Holder> {

    private List<Article_Info_Model> listModel;
    private List<Provider_Names_Model> providerNamesModels;
    private Context context;
    private LayoutInflater inflater;
    private Child_Recycle_Adapter adapter;
    private DataBase_Model db;
    private Data_Operations_Interface dao;
    private List<List<Article_Info_Model>> lists;
    private List<Article_Info_Model> list;




    public Parent_Recycle_Adapter(Context context) {
        this.context = context;
        providerNamesModels=new ArrayList<>();
        inflater = LayoutInflater.from(context);
        adapter = new Child_Recycle_Adapter(context);
       db = DataBase_Model.getInstance(context);
        dao=db.dao();


    }

    @NonNull
    @Override
    public Providor_Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = inflater.inflate(R.layout.item_parent_recycle_view, viewGroup, false);
        return new Providor_Holder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull Providor_Holder providor_holder, int i) {
        String providerName = providerNamesModels.get(i).getProviderName();
        System.out.println(providerName);
        list=lists.get(i);
        adapter.setData(list);
        providor_holder.providerTitleTv.setText(providerName);
        providor_holder.parentRv.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        providor_holder.parentRv.setHasFixedSize(true);
        providor_holder.parentRv.setNestedScrollingEnabled(false);
        providor_holder.parentRv.setItemAnimator(new DefaultItemAnimator());
        providor_holder.parentRv.setAdapter(adapter);


    }

    @Override
    public int getItemCount() {

        return providerNamesModels.size();
    }

    public void setProvidersName( List<Provider_Names_Model> providerNamesModels) {

        this.providerNamesModels = providerNamesModels;

        notifyDataSetChanged();
    }

    public void setdata(List<List<Article_Info_Model>> lists) {
        this.lists=lists;
        notifyDataSetChanged();
    }



    public class Providor_Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.provider_title_tv)
        TextView providerTitleTv;
        @BindView(R.id.parent_rv)
        RecyclerView parentRv;

        public Providor_Holder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
