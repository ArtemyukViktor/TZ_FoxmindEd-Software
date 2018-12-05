package com.example.viktor.tzproducttest.view.fragment;

import android.app.Activity;
import android.app.Presentation;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.paging.PagedList;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.viktor.tzproducttest.R;
import com.example.viktor.tzproducttest.adapter.ItemAdapter;
import com.example.viktor.tzproducttest.model.ItemDataSourceFactory;
import com.example.viktor.tzproducttest.model.ItemViewModel;
import com.example.viktor.tzproducttest.pojo.pojoproduct.Result;
import com.example.viktor.tzproducttest.presenter.MainPresenter;

import java.util.List;




public class PlaceholderLoad extends Fragment {

    public static String category;
    public static int isChange = 0;
    public static RecyclerView mRecyclerViewProduct;
    private LinearLayoutManager layoutManager;
    public static ImageView mIvSubmit;
    public static AutoCompleteTextView mAutoCompleteCategory;
    private String mFragmentName;
    private MainPresenter presenter;
    private ItemViewModel itemViewModel;
    SwipeRefreshLayout pullToRefresh;
  public static pl.droidsonroids.gif.GifImageView gifImageView;


    // ItemAdapter adapter;




    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRetainInstance(true);
        mFragmentName = getArguments().getString("key_name_load");
        presenter = MainPresenter.getPresenterInstance();
        presenter.getCategories();








    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_placeholder_load, container, false);

        initView(rootView);
        itemViewModel = ViewModelProviders.of(getActivity()).get(ItemViewModel.class);
        setListeners();

        return rootView;
    }

    private void setListeners() {

        mIvSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                category = mAutoCompleteCategory.getText().toString();

                if (!category.equals("")) {
                    gifImageView.setVisibility(View.VISIBLE);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                        gifImageView.setBackgroundResource(R.drawable.image_anim);
                    }else {
                        Toast.makeText(getActivity(), "please wait", Toast.LENGTH_SHORT).show();
                    }


                   itemViewModel.setItemPagedList();

                    final ItemAdapter adapter = new ItemAdapter(getContext());


                    itemViewModel.getItemPagedList().observe(getActivity(),new Observer<PagedList<Result>>() {
                        @Override
                        public void onChanged(@Nullable PagedList<Result> results) {

                            adapter.submitList(results);
                        }
                    });

                    mRecyclerViewProduct.setAdapter(adapter);

                } else {

                    Toast.makeText(getActivity(), "category is empty!", Toast.LENGTH_SHORT).show();
                }

                view = getActivity().getCurrentFocus();
                if (view != null) {
                    InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Activity.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }

            }
        });
        pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(getContext(), "Refresh", Toast.LENGTH_SHORT).show();
                itemViewModel.setItemPagedList();
                pullToRefresh.setRefreshing(false);
            }
        });


    }

    private void initView(View v) {
       gifImageView = v.findViewById(R.id.tvAnim);
        mRecyclerViewProduct = v.findViewById(R.id.rv_product);
        layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);

        // TODO: 01.12.18 adapter

        mRecyclerViewProduct.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mRecyclerViewProduct.getContext(),
                layoutManager.getOrientation());
        mRecyclerViewProduct.addItemDecoration(dividerItemDecoration);


        mIvSubmit = v.findViewById(R.id.iv_search);
        mAutoCompleteCategory = v.findViewById(R.id.autoCompleteCategory);
        pullToRefresh = v.findViewById(R.id.pullToRefresh);


    }

    public static PlaceholderLoad newInstance(String fragmentName) {

        PlaceholderLoad fragment = new PlaceholderLoad();

        Bundle bundle = new Bundle();
        bundle.putString("key_name_load", fragmentName);
        fragment.setArguments(bundle);

        return fragment;
    }

    public String getFragmentName(){
        return mFragmentName;
    }

    public void setCategories(List<String> categories){

        mAutoCompleteCategory.setThreshold(1);
        mAutoCompleteCategory.setAdapter(new ArrayAdapter<>(getActivity(),  android.R.layout.simple_dropdown_item_1line,categories));
    }


}
