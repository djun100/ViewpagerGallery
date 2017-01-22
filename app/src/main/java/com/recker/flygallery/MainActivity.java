package com.recker.flygallery;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity {
    ClipViewPagerLayout mClipViewPagerLL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mClipViewPagerLL= (ClipViewPagerLayout) findViewById(R.id.mClipViewPagerLL);
        mClipViewPagerLL.mViewPager.setAdapter(new MyPagerAdapter());
/*        final ClipViewPager viewPager = (ClipViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new MyPagerAdapter());
        viewPager.setOffscreenPageLimit(4);
        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());
        LinearLayout mll= (LinearLayout) findViewById(R.id.mll);
        mll.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return viewPager.dispatchTouchEvent(event);
            }
        });*/
    }


    private class MyPagerAdapter extends PagerAdapter {

        private int[] images = {R.drawable.img_1, R.drawable.img_2,
                R.drawable.img_3, R.drawable.img_4};

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView = new ImageView(MainActivity.this);
            imageView.setImageResource(images[position]);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            container.addView(imageView);

            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((ImageView) object);
        }
    }
}
