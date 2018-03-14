package com.ty.dagger.daggerdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.ty.dagger.daggerdemo.mvp.widget.statuslayout.StatusBarUtils;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


//    @BindView(R.id.dnv)
//    DanceNumView mDnv;
//    @BindView(R.id.et)
//    EditText mEt;
//    @BindView(R.id.button)
//    Button mButton;
//    @BindView(R.id.atv)
//    AnimationTextView mAtv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bbsjstep);
        ButterKnife.bind(this);
        StatusBarUtils.setTranslucentStatusBar(this,null,0);
//        mAtv.setStaticText("3520928429.908",2);
//        mAtv.setAnimationText("13214.43",3);
//
//        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(MainActivity.this, GankActivity.class));
//
//
//            }
//        });
//        mDnv = findViewById(R.id.dnv);
//        mAtv = findViewById(R.id.atv);

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
