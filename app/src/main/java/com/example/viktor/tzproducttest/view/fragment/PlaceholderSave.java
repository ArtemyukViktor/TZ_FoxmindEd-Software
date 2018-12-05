package com.example.viktor.tzproducttest.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.viktor.tzproducttest.R;
import com.example.viktor.tzproducttest.adapter.MyRecyclerViewAdapterGrid;
import com.example.viktor.tzproducttest.app.App;
import com.example.viktor.tzproducttest.model.Dao;
import com.example.viktor.tzproducttest.pojo.pojoproduct.Result;

import java.util.ArrayList;
import java.util.List;

public class PlaceholderSave extends Fragment {

    private RecyclerView recyclerView;
    private String mFragmentName;
    private Dao dao;
    private MyRecyclerViewAdapterGrid adapter;
    private List<Result>resultList;





    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRetainInstance(true);
        mFragmentName = getArguments().getString("key_name_save");
        dao = App.getInstanceDB().daoProduct();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_placeholder_save, container, false);

        recyclerView = rootView.findViewById(R.id.rv_product_save);
        int numberOfColumns = 2;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),numberOfColumns);
        recyclerView.setLayoutManager(gridLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                gridLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        //DELETE !!!!

        List<Result> results = dao.getAllProducts();
        resultList = results;
//        for (int i = 0; i < results.size(); i++) {
//
//            String s = " title - "+results.get(i).getTitle()
//                    + " price - "+results.get(i).getPrice()
//                    + " image - "+results.get(i).getMainImage().getUrl75x75();
//            Log.d("myLog1", "onClick: " + s + "\n");
//        }

        adapter = new MyRecyclerViewAdapterGrid(getActivity());
        adapter.setmData(results);
        //adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

        initView(rootView);

        return rootView;
    }


    private void initView(View v) {

        recyclerView = v.findViewById(R.id.rv_product_save);


    }


    public void updateRecycler(){
        adapter.setmData(dao.getAllProducts());
        recyclerView.getAdapter().notifyDataSetChanged();
    }

    public static PlaceholderSave newInstance(String fragmentName) {

        PlaceholderSave fragment = new PlaceholderSave();

        Bundle bundle = new Bundle();
        bundle.putString("key_name_save",fragmentName);
        fragment.setArguments(bundle);

        return fragment;
    }

    public String getFragmentName(){
        return mFragmentName;
    }
}
