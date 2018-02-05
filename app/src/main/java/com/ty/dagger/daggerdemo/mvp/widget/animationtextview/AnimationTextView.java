package com.ty.dagger.daggerdemo.mvp.widget.animationtextview;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import java.text.DecimalFormat;

/**
 * Created by ty on 2018/2/2.
 */

public class AnimationTextView extends android.support.v7.widget.AppCompatTextView {
    public AnimationTextView(Context context) {
        this(context, null);
    }

    public AnimationTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AnimationTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    static class DoubleEValuetor implements TypeEvaluator<Double> {
        @Override
        public Double evaluate(float v, Double aDouble, Double t1) {
            double x = v * t1;
            return x;
        }
    }

    double res;

    public void startAnimations() {
        String textNum = this.getText().toString();


        res = Double.parseDouble(this.getText().toString());

        ValueAnimator animator = ValueAnimator
                .ofObject(new DoubleEValuetor(), 0.1, res);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                res = ((Double) animation.getAnimatedValue());
                invalidate();
            }
        });
        animator.setDuration(3000);
        animator.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.setText(formatTosepara(res));
    }

    public static String formatTosepara(Object data) {
        DecimalFormat df;
        if (data instanceof Double && !(data + "").split("\\.")[1].equals("0")) {
            df = new DecimalFormat("#,###.0");
        } else {
            df = new DecimalFormat("#,###");
        }
        return df.format(data);
    }
}
