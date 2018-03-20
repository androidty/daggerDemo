package com.ty.dagger.daggerdemo.mvp.widget.animationtextview;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;

import java.text.DecimalFormat;

/**
 * Created by ty on 2018/2/2.
 */

public class AnimationNumView extends android.support.v7.widget.AppCompatTextView {

    //默认保留整数位
    private int keepFigures = 0;
    private final String KEEP_INTEGER = "#,###";
    private final String KEEP_ONE_FIGURE = "#,###.0";
    private final String KEEP_TWO_FIGURE = "#,###.00";
    private final String KEEP_THREE_FIGURE = "#,###.000";
    private final String KEEP_FOUR_FIGURE = "#,###.0000";

    private String KEEPFIGURE = KEEP_INTEGER;

    private boolean openAnimation = false;


    public AnimationNumView(Context context) {
        this(context, null);
    }

    public AnimationNumView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AnimationNumView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    static class DoubleEValuetor implements TypeEvaluator<Double> {
        @Override
        public Double evaluate(float fraction, Double startValue, Double endValue) {
            double startDouble = startValue.doubleValue();
            return startDouble + fraction * (endValue.doubleValue() - startDouble);
        }
    }

    double res;


    public void setAnimationText(String text) {
        if (!isNum(text)) {
            this.setText("请设置纯数字文本");
            return;
        }
        res = Double.parseDouble(text);
        openAnimation = true;
        ValueAnimator animator = ValueAnimator
                .ofObject(new DoubleEValuetor(), 0.1, res);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                res = ((Double) animation.getAnimatedValue());
                setText(formatTosepara(res));
            }

        });
        animator.setDuration(5000);
        animator.start();
    }


    public void setAnimationText(String text, int keepFigures) {
        this.setKeepFigures(keepFigures);
        setAnimationText(text);
    }

    int numInt = 0;

    public void setIntegerAnimationNum(int num) {
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, num);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                numInt = (int) animation.getAnimatedValue();
                setText(formatTosepara(numInt));
            }
        });
        valueAnimator.setDuration(1000);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.start();
    }


    public String formatTosepara(Object data) {
        DecimalFormat df;
        switch (getKeepFigures()) {
            case 0:
                KEEPFIGURE = KEEP_INTEGER;
                break;
            case 1:
                KEEPFIGURE = KEEP_ONE_FIGURE;
                break;
            case 2:
                KEEPFIGURE = KEEP_TWO_FIGURE;
                break;
            case 3:
                KEEPFIGURE = KEEP_THREE_FIGURE;
                break;
            case 4:
                KEEPFIGURE = KEEP_FOUR_FIGURE;
                break;
        }
        df = new DecimalFormat(KEEPFIGURE);
        return df.format(data);
    }

    public void setStaticText(String text) {
        if (!isNum(text)) {
            this.setText("请设置纯数字文本");
        } else {
            this.setText(formatTosepara(Double.parseDouble(text)));
        }
    }

    public void setStaticText(String text, int keepFigures) {
        this.setKeepFigures(keepFigures);
        this.setStaticText(text);
    }


    private void setKeepFigures(int keepFigures) {
        this.keepFigures = keepFigures;
    }

    private int getKeepFigures() {
        return keepFigures;
    }

    private boolean isNum(String str) {
        String reg = "^[0-9]+(.[0-9]+)?$";
        return str.matches(reg);
    }


}
