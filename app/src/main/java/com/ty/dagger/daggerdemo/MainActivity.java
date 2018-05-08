package com.ty.dagger.daggerdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ty.dagger.daggerdemo.mvp.wallet.huobi.HuoBiSign;
import com.ty.dagger.daggerdemo.mvp.ui.activity.gank.GankActivity;
import com.ty.dagger.daggerdemo.mvp.utils.LambdaStudy;
import com.ty.dagger.daggerdemo.mvp.widget.animationtextview.AnimationNumView;
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
    AnimationNumView mAtv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        StatusBarUtils.setTranslucentStatusBar(this, null, 0);
        mAtv.setStaticText("3520928429.908", 2);
        mAtv.setAnimationText("13214.43", 3);
        Toast.makeText(this, HuoBiSign.getUTCTime(), Toast.LENGTH_SHORT).show();
//        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(MainActivity.this, GankActivity.class));
//            }
//        });
        findViewById(R.id.button).setOnClickListener((view) -> {
            new LambdaStudy().study1("Lambda");
            startActivity(new Intent(this, GankActivity.class));
//            Intent intent = new Intent(MainActivity.this, X5WebViewActivity.class);
//            intent.putExtra("url","https://androidty.github" +
//                    ".io/2018/03/20/%E6%97%8B%E6%B6%A1%E7%9F%A9%E9%98%B5/");
//            startActivity(intent);
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
