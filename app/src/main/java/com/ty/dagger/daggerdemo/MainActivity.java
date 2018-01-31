package com.ty.dagger.daggerdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.ty.dagger.daggerdemo.mvp.ui.activity.photo.PhotoActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ButterKnife.bind(this);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PhotoActivity.class));
                Toast.makeText(MainActivity.this, "test", Toast.LENGTH_SHORT).show();


            }
        });


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
