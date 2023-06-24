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

public class HeadPartFragment extends Fragment {

    private List<Integer> imageList;
    private int imageIndex;

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
            imageList = savedInstanceState.getIntegerArrayList(AppConstant.HEAD_IMAGE_ID_LIST);
            imageIndex = savedInstanceState.getInt(AppConstant.HEAD_LIST_INDEX);
            Log.v(TAG, "existed Head state ");
        }else {
            Log.v(TAG, "Non existed Head state ");
        }

        View root = inflater.inflate(R.layout.fragment_head_part, container, false);

        ImageView imageView = root.findViewById(R.id.head_part_image_view);

        imageView.setOnClickListener(
                v -> {
                    if(imageIndex < imageList.size() - 1){
                        imageIndex++;
                    }else{
                        imageIndex = 0;
                    }
                    imageView.setImageResource(imageList.get(imageIndex));
                }
        );

        if (imageList != null){
            imageView.setImageResource(imageList.get(imageIndex));
        } else {
            Log.v(TAG, "This fragment has a null list of image id");
        }

        return imageView;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putIntegerArrayList(AppConstant.HEAD_IMAGE_ID_LIST, (ArrayList<Integer>) imageList);
        outState.putInt(AppConstant.HEAD_LIST_INDEX, imageIndex);
    }
}
