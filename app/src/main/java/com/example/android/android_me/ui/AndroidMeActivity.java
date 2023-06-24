/*
* Copyright (C) 2017 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*  	http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.android_me.ui;
import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;
import com.example.android.android_me.ui.me_fragment.BodyPartFragment;
import com.example.android.android_me.ui.me_fragment.BottomPartFragment;
import com.example.android.android_me.ui.me_fragment.HeadPartFragment;

// This activity will display a custom Android image composed of three body parts: head, body, and legs
public class AndroidMeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);

        if(savedInstanceState == null){
            Log.d("FOUND", "No Instance");
            //1. Use a fragment manager add transaction to add the fragment to the screen
            //2. Refactor variable
            HeadPartFragment headPartFragment = new HeadPartFragment();
            headPartFragment.setImageList(AndroidImageAssets.getHeads());
            headPartFragment.setImageIndex(1);

            BodyPartFragment bodyPartFragment = new BodyPartFragment();
            bodyPartFragment.setImageList(AndroidImageAssets.getBodies());
            bodyPartFragment.setListIndex(1);

            BottomPartFragment bottomPartFragment = new BottomPartFragment();
            bottomPartFragment.setImageList(AndroidImageAssets.getLegs());
            bottomPartFragment.setImageIndex(1);

            FragmentManager fragmentManager = getSupportFragmentManager();

            fragmentManager.beginTransaction().add(R.id.head_container, headPartFragment).commit();
            fragmentManager.beginTransaction().add(R.id.body_container, bodyPartFragment).commit();
            fragmentManager.beginTransaction().add(R.id.bottom_container, bottomPartFragment).commit();
            Log.v(TAG, "first instance state ");
        }else {
            Log.v(TAG, "existed instance state ");
        }
    }
}
