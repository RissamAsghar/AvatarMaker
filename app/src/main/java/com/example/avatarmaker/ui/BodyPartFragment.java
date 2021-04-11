package com.example.avatarmaker.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.avatarmaker.R;
import com.example.avatarmaker.data.AndroidImageAssets;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BodyPartFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BodyPartFragment extends Fragment {

    private List<Integer> mImageIds;
    private int mListIndex;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private static final String TAG = "BodyPartFragment";

    public static final String IMAGE_ID_LIST = "image_ids";
    public static final String LIST_INDEX = "list_index";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BodyPartFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BodyPartFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BodyPartFragment newInstance(String param1, String param2) {
        BodyPartFragment fragment = new BodyPartFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if(savedInstanceState != null){
            mImageIds = savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST);
            mListIndex = savedInstanceState.getInt(LIST_INDEX);
        }
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_body_part, container, false);

        final ImageView imageView = (ImageView) rootView.findViewById(R.id.body_part_image_view);

       if(mImageIds != null){
           imageView.setImageResource(mImageIds.get(mListIndex));

           imageView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   if(mListIndex < mImageIds.size()-1){
                       mListIndex++;
                   }
                   else {
                       mListIndex = 0;
                   }
                   imageView.setImageResource(mImageIds.get(mListIndex));
               }
           });
       }
       else{
           Log.v(TAG,"This fragment has a null list of image ids");

       }
        return rootView;
    }

    public void setImageIds(List<Integer> mImageIds){
        this.mImageIds = mImageIds;

    }

    public void setListIndex(int mListIndex){
        this.mListIndex = mListIndex;

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle currentState) {
        currentState.putIntegerArrayList(IMAGE_ID_LIST,(ArrayList<Integer>) mImageIds);
        currentState.putInt(LIST_INDEX, mListIndex);

    }
}
