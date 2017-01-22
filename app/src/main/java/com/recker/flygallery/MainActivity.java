package com.recker.flygallery;

import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.cy.DataStructure.UtilArray;
import com.cy.DataStructure.UtilList;
import com.pacific.adapter.PagerAdapterHelper;
import com.pacific.adapter.ViewPagerAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ClipViewPagerLayout mClipViewPagerLL;
    private Integer[] images = {R.drawable.img_1, R.drawable.img_2,
            R.drawable.img_3, R.drawable.img_4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mClipViewPagerLL= (ClipViewPagerLayout) findViewById(R.id.mClipViewPagerLL);

        ArrayList<Integer> beans= (ArrayList<Integer>) UtilList.convert_arrayToList(images);

        mClipViewPagerLL.mViewPager.setAdapter(new ViewPagerAdapter<Integer>(this,beans,R.layout.item) {
            @Override
            protected void convert(PagerAdapterHelper helper, Integer item) {
                helper.setImageResource(R.id.imageView,item);
            }
        });
    }
}
