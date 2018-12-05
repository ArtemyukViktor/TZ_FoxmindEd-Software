package com.example.viktor.tzproducttest.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.viktor.tzproducttest.R;
import com.example.viktor.tzproducttest.app.App;
import com.example.viktor.tzproducttest.model.Dao;
import com.example.viktor.tzproducttest.pojo.pojoproduct.MainImage;
import com.example.viktor.tzproducttest.pojo.pojoproduct.Result;
import com.example.viktor.tzproducttest.presenter.MainPresenter;
import com.example.viktor.tzproducttest.view.fragment.PlaceholderSave;
import com.squareup.picasso.Picasso;

import java.util.List;

import static com.example.viktor.tzproducttest.view.activity.MainActivity.mMainPresenter;

public class MyRecyclerViewAdapterGrid extends RecyclerView.Adapter<MyRecyclerViewAdapterGrid.ViewHolder> {
   // private String[] mData;
    private List<Result> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private Dao dao;



    // data is passed into the constructor
    public MyRecyclerViewAdapterGrid(Context context ) {
        this.mInflater = LayoutInflater.from(context);

    }

    public List<Result> getmData() {
        return mData;
    }

    public void setmData(List<Result> mData) {
        this.mData = mData;
    }

    // inflates the cell layout from xml when needed
    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_item_grid, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each cell
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(mData.get(position).getTitle());
        holder.price.setText(mData.get(position).getPrice() + "USD");

        Picasso.get().load(mData.get(position).getMainImage().getUrl75x75()).into(holder.iv);
    }

    // total number of cells
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView iv;
        TextView name;
        TextView price;
        Button btnDelet;

        ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textViewName_grid);
            price = itemView.findViewById(R.id.textViewPrice_grid);
            iv = itemView.findViewById(R.id.imageView_grid);
            btnDelet = itemView.findViewById(R.id.btnDell);
            btnDelet.setOnClickListener(this);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btnDell :{
                    dao = App.getInstanceDB().daoProduct();
                    dao.deleteProduct(dao.getAllProducts().get(getAdapterPosition()));
                    for (int i = 0; i < dao.getAllProducts().size(); i++) {
                        Log.d("mTag", "onClick: " + dao.getAllProducts().get(i).getPrice() +" "+ getAdapterPosition());
                    }
                    mMainPresenter.updateGridRecycler();
                   // setmData(dao.getAllProducts());



                //  mMainPresenter.updateGridRecycler();

                }
            }
            //if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
//    String getItem(int id) {
//        return mData[id];
//    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
