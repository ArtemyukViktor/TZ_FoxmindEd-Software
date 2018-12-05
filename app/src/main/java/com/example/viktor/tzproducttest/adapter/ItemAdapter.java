package com.example.viktor.tzproducttest.adapter;

import android.arch.paging.PagedListAdapter;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.viktor.tzproducttest.R;
import com.example.viktor.tzproducttest.pojo.pojoproduct.Result;
import com.example.viktor.tzproducttest.view.activity.MainActivity;
import com.example.viktor.tzproducttest.view.fragment.FragmentAditionalInform;
import com.squareup.picasso.Picasso;


import static com.example.viktor.tzproducttest.view.fragment.PlaceholderLoad.mAutoCompleteCategory;
import static com.example.viktor.tzproducttest.view.fragment.PlaceholderLoad.mIvSubmit;
import static com.example.viktor.tzproducttest.view.fragment.PlaceholderLoad.mRecyclerViewProduct;


public class ItemAdapter extends PagedListAdapter<Result, ItemAdapter.ItemViewHolder> {

    private Context mCtx;


    public ItemAdapter(Context mCtx) {
        super(DIFF_CALLBACK);
        this.mCtx = mCtx;


    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemViewHolder holder, final int position) {

        final Result result = getItem(position);

        if (result != null) {
try {
    Picasso.get().load(result.getMainImage().getUrl75x75()).into(holder.imageView);
}catch (Exception e){
    Picasso.get().load(R.drawable.ic_launcher_background).into(holder.imageView);
}
           // Picasso.get().load(result.getMainImage().getUrl75x75()).into(holder.imageView);
           holder.textView.setText(result.getTitle());
            holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mIvSubmit.setEnabled(false);
                    mAutoCompleteCategory.setEnabled(false);
                    mRecyclerViewProduct.setVisibility(View.INVISIBLE);
                    mRecyclerViewProduct.setEnabled(false);

                    FragmentAditionalInform inform = FragmentAditionalInform.newInstance(result.getTitle(), result.getPrice().toString(), result.getMainImage().getUrl170x135());

                    ((AppCompatActivity) mCtx).getSupportFragmentManager().beginTransaction().
                            add(R.id.FrLoy, inform).commit();



                }
            });



        } else {
            Toast.makeText(mCtx, "Item is null", Toast.LENGTH_LONG).show();
        }

    }

    private static DiffUtil.ItemCallback<Result> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<Result>() {
                @Override
                public boolean areItemsTheSame(Result oldItem, Result newItem) {
                    return oldItem.getListingId() == newItem.getListingId();
                }

                @Override
                public boolean areContentsTheSame(Result oldItem, Result newItem) {
                    return oldItem.equals(newItem);
                }
            };


    class ItemViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;
        RelativeLayout relativeLayout;
        FrameLayout  frameLayout;


        public ItemViewHolder(View itemView) {
            super(itemView);
            relativeLayout = itemView.findViewById(R.id.relative_loy_item);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textViewName);
            frameLayout = itemView.findViewById(R.id.FrLoy);


        }
    }
}
