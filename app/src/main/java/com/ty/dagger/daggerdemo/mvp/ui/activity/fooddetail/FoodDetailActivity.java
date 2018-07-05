package com.ty.dagger.daggerdemo.mvp.ui.activity.fooddetail;

import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.ty.dagger.daggerdemo.R;
import com.ty.dagger.daggerdemo.mvp.entity.FoodDetail;
import com.ty.dagger.daggerdemo.mvp.ui.base.BaseActivity;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by ty on 2018/6/29.
 */

public class FoodDetailActivity extends BaseActivity implements FoodDetailContract.View {

    @Inject
    FoodDetailPresenter<FoodDetailContract.View> mFoodDetailPresenter;


    @Override
    protected void initInjector() {
        getActivityComponent().inject(this);
        mFoodDetailPresenter.onAttach(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mFoodDetailPresenter.onDetach();
    }

    @Override
    public void initView() {
        int foodId = getIntent().getIntExtra("foodId", 0);
        if (foodId > 0) {
            mFoodDetailPresenter.requestFoodDetailById(foodId);
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_fooddetail;
    }

    @Override
    public void returnFoodDetail(FoodDetail foodDetail) {
        if (foodDetail != null) {
            String detail = foodDetail.getDetail();
            Gson gson = new Gson();
            Map<String, String> zhuLiaoMap = new HashMap<>();
            Map<String, String> fuliaoMap = new HashMap<>();
            JsonParser parser = new JsonParser();
            JsonObject jsonObject = parser.parse(detail).getAsJsonObject();
            zhuLiaoMap = gson.fromJson(jsonObject.get("zhuliao").toString(), new TypeToken<Map<String,
                    String>>() {
            }.getType());
            fuliaoMap = gson.fromJson(jsonObject.get("fuliao").toString(), new TypeToken<Map<String, String>>
                    () {
            }.getType());
            String s = "主料:\n";
            for (String key : zhuLiaoMap.keySet()) {
                Log.d("returnFoodDetail", "returnFoodDetail: " + key + ":" + zhuLiaoMap.get(key));
                s +=key+":"+zhuLiaoMap.get(key)+"\n";
            }
            Log.d("returnFoodDetail", "returnFoodDetail: ");
            s +="\n辅料:\n";
            for (String key : fuliaoMap.keySet()) {
                Log.d("returnFoodDetail", "returnFoodDetail: " + key + ":" + fuliaoMap.get(key));
                s +=key+":"+fuliaoMap.get(key)+"\n";
            }
            Log.d("returnFoodDetail", "returnFoodDetail: ");
            Toast.makeText(mContext, s, Toast.LENGTH_LONG).show();
        }
    }
}
