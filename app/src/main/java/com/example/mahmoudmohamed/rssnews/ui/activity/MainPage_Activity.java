package com.example.mahmoudmohamed.rssnews.ui.activity;

import android.os.Bundle;
import android.view.View;

import com.example.mahmoudmohamed.rssnews.R;
import com.example.mahmoudmohamed.rssnews.adapter.Parent_Recycle_Adapter;
import com.example.mahmoudmohamed.rssnews.data.room.models.Article_Info_Model;
import com.example.mahmoudmohamed.rssnews.data.room.models.Provider_Names_Model;
import com.example.mahmoudmohamed.rssnews.view_model.ViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
//BBC ,Newyuork times,CNBC

public class MainPage_Activity extends AppCompatActivity {
    @BindView(R.id.recycle_view)
    RecyclerView recyclerView;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private ViewModel viewModel;
    private Parent_Recycle_Adapter parentAdapter;
    private LiveData<List<Article_Info_Model>> list;
    private LiveData<List<Provider_Names_Model>> listLiveDataProvider;
    private List<List<Article_Info_Model>> lists;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        lists=new ArrayList<>();


        //intialize  recycle
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        //make observer
        viewModel = ViewModelProviders.of(this).get(ViewModel.class);
        lists=viewModel.getLists();
        //make observer on viewmodel parent Recycle
        viewModel.getListLiveDataProviders().observe(this, new Observer<List<Provider_Names_Model>>() {
            @Override
            public void onChanged(List<Provider_Names_Model> provider_names_models) {
                System.out.println("herre1");
                System.out.println("provider size "+provider_names_models.size());
                parentAdapter.setProvidersName(provider_names_models);
            }
        });

        //intialize  adapter
        parentAdapter = new Parent_Recycle_Adapter(getApplicationContext());
        recyclerView.setAdapter(parentAdapter);

        //
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    @OnClick({R.id.recycle_view, R.id.fab})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.recycle_view:
                break;
            case R.id.fab:
                break;
        }
    }
}
