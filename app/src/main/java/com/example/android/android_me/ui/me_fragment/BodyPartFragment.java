package com.example.android.android_me.ui.me_fragment;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AppConstant;

import java.util.ArrayList;
import java.util.List;

public class BodyPartFragment extends Fragment {


    private List<Integer> imageList;
    private int imageIndex;

    public List<Integer> getImageList() {
        return imageList;
    }

    public void setImageList(List<Integer> imageList) {
        this.imageList = imageList;
    }

    public int getListIndex() {
        return imageIndex;
    }

    public void setListIndex(int mListIndex) {
        this.imageIndex = mListIndex;
    }

    public BodyPartFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(savedInstanceState != null){
            imageList = savedInstanceState.getIntegerArrayList(AppConstant.BODY_IMAGE_ID_LIST);
            imageIndex = savedInstanceState.getInt(AppConstant.BODY_LIST_INDEX);
            Log.v(TAG, "existed Body state ");
        }else {
            Log.v(TAG, "Non existed body state ");
        }

        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);

        ImageView imageView = rootView.findViewById(R.id.body_part_image_view);

        imageView.setOnClickListener(
                v -> {
                    if (imageIndex < imageList.size() - 1 ){
                        imageIndex ++;
                    }else {
                        imageIndex = 0;
                    }
                    imageView.setImageResource(imageList.get(imageIndex));
                }
        );

        if(imageList != null){
            imageView.setImageResource(imageList.get(getListIndex()));
        } else {
            Log.v(TAG, "This fragment has a null list of image id");
        }

        return rootView;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putIntegerArrayList(AppConstant.BODY_IMAGE_ID_LIST, (ArrayList<Integer>) imageList);
        outState.putInt(AppConstant.BODY_LIST_INDEX, imageIndex);
    }
}
