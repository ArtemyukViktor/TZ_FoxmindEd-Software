package com.example.viktor.tzproducttest.view.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
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
import com.squareup.picasso.Picasso;


import java.util.List;

import static com.example.viktor.tzproducttest.view.fragment.PlaceholderLoad.mAutoCompleteCategory;
import static com.example.viktor.tzproducttest.view.fragment.PlaceholderLoad.mIvSubmit;
import static com.example.viktor.tzproducttest.view.fragment.PlaceholderLoad.mRecyclerViewProduct;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentAditionalInform.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentAditionalInform#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentAditionalInform extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";
    TextView tv, tv2;
    ImageView imageView;
    Button btnCancel, btnSave;
    private Dao dao;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String mParam3;

    private OnFragmentInteractionListener mListener;

    public FragmentAditionalInform() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @param param3 Parameter 3.
     * @return A new instance of fragment FragmentAditionalInform.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentAditionalInform newInstance(String param1, String param2, String param3) {
        FragmentAditionalInform fragment = new FragmentAditionalInform();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putString(ARG_PARAM3, param3);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            mParam3 = getArguments().getString(ARG_PARAM3);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragment_aditional_inform, container, false);
        tv = v.findViewById(R.id.tvTitle);
        tv2 = v.findViewById(R.id.tvPrise);
        btnCancel = v.findViewById(R.id.btnCancel);
        btnSave = v.findViewById(R.id.btnSave);
        btnCancel.setOnClickListener(this);
        btnSave.setOnClickListener(this);
        imageView = v.findViewById(R.id.imageViewADITIONAL);
        Picasso.get().load(mParam3).into(imageView);
        tv.setText(mParam1);
        tv2.setText(mParam2 + " USD");

        dao = App.getInstanceDB().daoProduct();


        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnCancel:{
                mIvSubmit.setEnabled(true);
                mAutoCompleteCategory.setEnabled(true);
                mRecyclerViewProduct.setVisibility(View.VISIBLE);
                mRecyclerViewProduct.setEnabled(true);


                ((AppCompatActivity) getContext()).getSupportFragmentManager().beginTransaction().
                        remove( ((AppCompatActivity) getContext()).getSupportFragmentManager().findFragmentById(R.id.FrLoy)).commit();
                break;
            }case R.id.btnSave:{
                mIvSubmit.setEnabled(true);
                mAutoCompleteCategory.setEnabled(true);
                mRecyclerViewProduct.setVisibility(View.VISIBLE);
                mRecyclerViewProduct.setEnabled(true);
                Result result = new Result();
                MainImage mainImage = new MainImage();
                mainImage.setUrl75x75(mParam3);

                result.setTitle(mParam1);
                result.setPrice(mParam2);
                result.setMainImage(mainImage);
                List<Result> list = dao.getAllProducts();
                boolean isDuble = false;

                for (int i = 0; i <list.size() ; i++) {
                    if (list.get(i).getMainImage().getUrl75x75().equals(result.getMainImage().getUrl75x75())){
                        Toast.makeText(getContext(), "You have already saved this item!", Toast.LENGTH_SHORT).show();
                        isDuble = true;
                    }
                }
                if (!isDuble){dao.insertProduct(result);}
//                dao.insertProduct(result);


                ((AppCompatActivity) getContext()).getSupportFragmentManager().beginTransaction().
                        remove( ((AppCompatActivity) getContext()).getSupportFragmentManager().findFragmentById(R.id.FrLoy)).commit();


                break;
            }
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
