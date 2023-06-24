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
import com.example.android.android_me.data.AndroidImageAssets;
import com.example.android.android_me.data.AppConstant;

import java.util.ArrayList;
import java.util.List;

public class BottomPartFragment extends Fragment {
    List<Integer> imageList;
    int imageIndex;

    public List<Integer> getImageList() {
        return imageList;
    }

    public void setImageList(List<Integer> imageList) {
        this.imageList = imageList;
    }

    public int getImageIndex() {
        return imageIndex;
    }

    public void setImageIndex(int imageIndex) {
        this.imageIndex = imageIndex;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if(savedInstanceState != null){
            imageList = savedInstanceState.getIntegerArrayList(AppConstant.BOTTOM_IMAGE_ID_LIST);
            imageIndex = savedInstanceState.getInt(AppConstant.BOTTOM_LIST_INDEX);
            Log.v(TAG, "existed Bottom state ");
        }else {
            Log.v(TAG, "Non existed Bottom state ");
        }

        View root = inflater.inflate(R.layout.fragment_bottom_part, container, false);

        ImageView imageView = root.findViewById(R.id.bottom_part_image_view);

        if(imageList != null){
            imageView.setImageResource(imageList.get(imageIndex));
        }

        imageView.setOnClickListener(
                v -> {
                    if(imageIndex < imageList.size() - 1){
                        imageIndex++;
                    }else{
                        imageIndex = 0;
                    }
//                    Update imageview
                    imageView.setImageResource(imageList.get(imageIndex));
                }
        );


        return imageView;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putIntegerArrayList(AppConstant.BOTTOM_IMAGE_ID_LIST, (ArrayList<Integer>) imageList);
        outState.putInt(AppConstant.BOTTOM_LIST_INDEX, imageIndex);
    }
}
