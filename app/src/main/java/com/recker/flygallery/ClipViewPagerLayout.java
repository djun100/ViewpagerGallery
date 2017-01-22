package com.recker.flygallery;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewManager;
import android.widget.LinearLayout;


/**
 * Created by wangxuechao on 2017/1/22.
 */

public class ClipViewPagerLayout extends LinearLayout {
    public ClipViewPager mViewPager;
    public ClipViewPagerLayout(Context context) {
        super(context);
        init();
    }

    public ClipViewPagerLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ClipViewPagerLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        setGravity(Gravity.CENTER);
        setOrientation(VERTICAL);
        setClipChildren(false);
        mViewPager= new ClipViewPager(getContext());
//        mViewPager.setAdapter(new MainActivity.MyPagerAdapter());
        mViewPager.setOffscreenPageLimit(4);
        mViewPager.setPageTransformer(true, new ZoomOutPageTransformer());

        LinearLayout.LayoutParams layoutParams=new LinearLayout
                .LayoutParams((int) dpToPx(250), ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.topMargin= (int) dpToPx(50);
        layoutParams.bottomMargin= (int) dpToPx(50);
        mViewPager.setLayoutParams(layoutParams);
        mViewPager.setOverScrollMode(ViewPager.OVER_SCROLL_NEVER);
        addView(mViewPager);
        setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return mViewPager.dispatchTouchEvent(event);
            }
        });

    }

    public float dpToPx( float dp) {
        return dp * getContext().getResources().getDisplayMetrics().density;
    }

}
