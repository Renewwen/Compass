package com.laioffer.matrix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity implements
        EventFragment.OnItemSelectListener,
        CommentFragment.OnItemSelectListener {

    private EventFragment listFragment;
    private CommentFragment gridFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // rotate: 保持了之前fragment的stack，但没有保存具体的数据
        // add list view
        if (getSupportFragmentManager().findFragmentById(R.id.event_container) == null) {
            listFragment = new EventFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.event_container, listFragment).commit();
        } else {
            listFragment = (EventFragment) getSupportFragmentManager().findFragmentById(R.id.event_container);
        }


        // add Gridview
        if (getSupportFragmentManager().findFragmentById(R.id.comment_container) == null && isTablet()) {
            gridFragment = new CommentFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.comment_container, gridFragment).commit();
        } else {
            gridFragment = (CommentFragment) getSupportFragmentManager().findFragmentById(R.id.comment_container);
        }

    }

    private boolean isTablet() {
        return (getApplicationContext().getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK) >=
                Configuration.SCREENLAYOUT_SIZE_LARGE;
    }

    @Override
    public void onItemSelected(int position) {
        gridFragment.onItemSelected(position);
    }

    @Override
    public void onCommentSelected(int position) {
        listFragment.onItemSelected(position);
    }

}
