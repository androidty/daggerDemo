package com.ty.dagger.daggerdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.ty.dagger.daggerdemo.mvp.ui.activity.gank.GankActivity;
import com.ty.dagger.daggerdemo.mvp.widget.animationtextview.AnimationTextView;
import com.ty.dagger.daggerdemo.mvp.widget.dancenumview.DanceNumView;

public class MainActivity extends AppCompatActivity {
    DanceNumView mDancingNumberView;
    EditText mEditText;
    AnimationTextView mAnimationTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText = findViewById(R.id.et);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, GankActivity.class));
//                if(mEditText.getText().toString().equals("")){
//                    mDancingNumberView.setText("92000000");
//                    mAnimationTextView.setText("96000000");
//                }else{
//                    mDancingNumberView.setText(mEditText.getText().toString());
//                    mAnimationTextView.setText(mEditText.getText().toString());
//                }
//
//                mDancingNumberView.setDuration(3000);
//                mDancingNumberView.setFormat("%.0f");
////                mDancingNumberView.dance();
//                mAnimationTextView.startAnimations();
            }
        });
        mDancingNumberView = findViewById(R.id.dnv);
        mAnimationTextView = findViewById(R.id.atv);

    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE, 0, 3, "tianyao");
        menu.add(Menu.NONE, 1, 2, "TIANYAO");
        menu.add(Menu.NONE, 2, 1, "zhongtuobang");
        menu.add(Menu.NONE, 3, 4, "ZHONGTUOBANG");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, "" + item.getTitle().toString(), Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
}
