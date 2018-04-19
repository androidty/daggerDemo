package com.ty.dagger.daggerdemo.mvp.widget;

/**
 * Created by ty on 2018/2/1.
 */

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.ty.dagger.daggerdemo.R;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DanceNumView extends android.support.v7.widget.AppCompatTextView {
    public static final String INTREGEX = "%1$01.0f";//不保留小数，整数
    public static final String FLOATREGEX2 = "%1$01.2f";//保留2位小数
    public static final String FLOATREGEX1 = "%1$01.1f";//保留1位小数
    public static final String PLACEHOLDER = "@@@";
    private int duration;
    private String format = "%.0f";
    private float factor;
    private ArrayList<Float> numbers;
    private float[] numberTemp;
    private String text;
    private String textPattern;

    public DanceNumView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.DanceNumView);
        this.duration = ta.getInteger(R.styleable.DanceNumView_dnv_duration, 1500);
        if (ta.hasValue(R.styleable.DanceNumView_dnv_format)) {
            this.format = ta.getString(R.styleable.DanceNumView_dnv_format);
        }

    }

    public void dance() {
        this.text = this.getText().toString();
        this.numbers = new ArrayList();
        Pattern pattern = Pattern.compile("\\d+(\\.\\d+)?");
        Matcher matcher = pattern.matcher(this.text);

        while (matcher.find()) {
            this.numbers.add(Float.valueOf(Float.parseFloat(matcher.group())));
        }


        this.textPattern = this.text.replaceAll("\\d+(\\.\\d+)?", "@@@");
        this.numberTemp = new float[this.numbers.size()];
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(this, "factor", new float[]{0.0F, 1.0F});
        objectAnimator.setDuration((long) this.duration);
        objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimator.start();
    }

    public float getFactor() {
        return this.factor;
    }

    public void setFactor(float factor) {
        String textNow = this.textPattern;
        this.factor = factor;
        for (int i = 0; i < this.numberTemp.length; ++i) {
            this.numberTemp[i] = ((Float) this.numbers.get(i)).floatValue() * factor;
            String s = "";
            if (i == this.numberTemp.length - 1) {
                s = String.format(FLOATREGEX1, new Object[]{Float.valueOf
                        (this.numberTemp[i])});
            } else {
                s = String.format(this.format, new Object[]{Float.valueOf
                        (this.numberTemp[i])});
            }
            if (numberTemp[i] < 10 && i != 0) {
                s = "00" + s;
            }else if(numberTemp[i] < 100 && i != 0){
                s="0"+s;
            }
            textNow = textNow.replaceFirst("@@@", s);
        }
        this.setText(textNow);
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getFormat() {
        return this.format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
