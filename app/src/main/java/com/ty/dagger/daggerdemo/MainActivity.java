package com.ty.dagger.daggerdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ty.dagger.daggerdemo.mvp.ui.activity.gank.GankActivity;
import com.ty.dagger.daggerdemo.mvp.widget.animationtextview.AnimationTextView;
import com.ty.dagger.daggerdemo.mvp.widget.dancenumview.DanceNumView;
import com.ty.dagger.daggerdemo.mvp.widget.statuslayout.StatusBarUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.dnv)
    DanceNumView mDnv;
    @BindView(R.id.et)
    EditText mEt;
    @BindView(R.id.button)
    Button mButton;
    @BindView(R.id.atv)
    AnimationTextView mAtv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        StatusBarUtils.setStatusAlpha(this,0);
        mAtv.setText("3520928429");
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, GankActivity.class));
//                if(mEt.getText().toString().equals("")){
//                    mDnv.setText("96000000");
//                    mAtv.setText("96000000");
//                }else{
//                    mDnv.setText(mEt.getText().toString());
//                    mAtv.setText(mEt.getText().toString());
//                }
//
//                mDnv.setDuration(3000);
//                mDnv.setFormat("%.0f");
////                mDancingNumberView.dance();
//                mAtv.startAnimations();
            }
        });
        mDnv = findViewById(R.id.dnv);
        mAtv = findViewById(R.id.atv);

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
