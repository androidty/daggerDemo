package com.ty.dagger.daggerdemo.dagger;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

import com.ty.dagger.daggerdemo.R;

/**
 * Created by ty on 2017/12/9.
 */

public class PendulumView extends View {
    //线束上面的圆心点横纵坐标
    private float dotX, dotY;
    private float ballRadius;
    //画球的画笔
    private Paint ballPaint;
    private int ballColor;
    //画线的画笔
    private Paint linePaint;
    private int lineColor;

    private int totalNums;
    private boolean isEvenNo;
    private int minNo, maxNo;

    private int time = 300;

    private float lineLength;

    private float firstBallX, firstBallY, lastBallX, lastBallY;

    //刚进去时候 判断是否要画first或者last小球的初始位置
    private boolean flag;
    private float amplitude;
    private float mRadians;
    private float initialRadians = (float) (Math.PI / 2);


    public PendulumView(Context context) {
        this(context, null);
    }

    public PendulumView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PendulumView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }


    private void init(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.PendulumView);
        totalNums = typedArray.getInteger(R.styleable.PendulumView_totalNum, 5);
        ballColor = typedArray.getColor(R.styleable.PendulumView_ballColor, Color.BLACK);
        lineColor = typedArray.getColor(R.styleable.PendulumView_lineColor, Color.BLACK);
        ballRadius = typedArray.getFloat(R.styleable.PendulumView_ballRadius, 22f);
        amplitude = typedArray.getFloat(R.styleable.PendulumView_amplitude, 45);
        typedArray.recycle();

        setMinMaxNo();

        ballPaint = new Paint();
        ballPaint.setAntiAlias(true);
        ballPaint.setDither(true);
        ballPaint.setStyle(Paint.Style.FILL);
        ballPaint.setColor(ballColor);
        linePaint = new Paint();
        linePaint.setAntiAlias(true);
        linePaint.setDither(true);
        linePaint.setStyle(Paint.Style.FILL);
        linePaint.setColor(lineColor);
        linePaint.setStrokeWidth(3);

        mRadians = (float) (amplitude / 180 * Math.PI);
    }

    private void setMinMaxNo() {
        if (totalNums % 2 == 0) {
            //todo
            isEvenNo = true;
            maxNo = totalNums / 2 - 1;
            minNo = -totalNums / 2;
        } else {
            isEvenNo = false;
            maxNo = (int) Math.floor(totalNums / 2);
            minNo = -maxNo;
        }
    }

    /**
     * 第一个小球摆动的动画
     */
    private void firstBallAnim() {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(initialRadians, initialRadians + mRadians);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float radian = (float) valueAnimator.getAnimatedValue();

                firstBallX = (float) (lineLength * Math.cos(radian)) + dotX;
                firstBallY = (float) (lineLength * Math.sin(radian)) + dotY;

            }
        });

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(time);
        animatorSet.setInterpolator(new DecelerateInterpolator());
//        valueAnimator.start();
        valueAnimator.setRepeatCount(1);
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        animatorSet.play(valueAnimator);

        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                flag = true;
                lastBallAnim();
            }
        });
        animatorSet.start();
    }


    /**
     * 最后一个小球摆动的动画
     */
    private void lastBallAnim() {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(initialRadians, initialRadians - mRadians);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float radian = (float) valueAnimator.getAnimatedValue();

                lastBallX = (float) (lineLength * Math.cos(radian)) + dotX;
                lastBallY = (float) (lineLength * Math.sin(radian)) + dotY;

            }
        });
        valueAnimator.setDuration(time);
        valueAnimator.setInterpolator(new DecelerateInterpolator());
//        valueAnimator.start();
        valueAnimator.setRepeatCount(1);
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(valueAnimator);
        animatorSet.start();
        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                flag = false;
                firstBallAnim();
            }
        });
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Log.d("firstX", "onSizeChanged: ");
        dotX = w / 2;
        dotY = h / 3;
        lineLength = h / 3;
//        ballRadius = 22f;
        firstBallAnim();

//        lastBallAnim();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawCircle(dotX,dotY,ballRadius,ballPaint);
//        canvas.drawCircle(dotX, 2 * dotY, ballRadius, ballPaint);
//        canvas.drawLine(dotX, dotY, dotX, 2 * dotY, ballPaint);
//        canvas.drawCircle(dotX - 2 * ballRadius, 2 * dotY, ballRadius, ballPaint);
//        canvas.drawLine(dotX - 2 * ballRadius, dotY, dotX - 2 * ballRadius, 2 * dotY, ballPaint);
//        canvas.drawCircle(dotX + 2 * ballRadius, 2 * dotY, ballRadius, ballPaint);
//        canvas.drawLine(dotX + 2 * ballRadius, dotY, dotX + 2 * ballRadius, 2 * dotY, ballPaint);
        if (isEvenNo) {
            //TODO
        } else {
            for (int i = minNo; i <= maxNo; i++) {
                if (i == minNo && !flag) {
                    canvas.drawLine(dotX + i * 2 * ballRadius, dotY, firstBallX + i * 2 * ballRadius, firstBallY,
                            linePaint);
                    canvas.drawCircle(firstBallX + i * 2 * ballRadius, firstBallY, ballRadius, ballPaint);
                } else if (i == maxNo && flag) {
                    canvas.drawLine(dotX + i * 2 * ballRadius, dotY, lastBallX + i * 2 * ballRadius, lastBallY,
                            linePaint);
                    canvas.drawCircle(lastBallX + i * 2 * ballRadius, lastBallY, ballRadius, ballPaint);
                } else {
                    canvas.drawLine(dotX + i * 2 * ballRadius, dotY, dotX + i * 2 * ballRadius, 2 * dotY, linePaint);
                    canvas.drawCircle(dotX + i * 2 * ballRadius, 2 * dotY, ballRadius, ballPaint);
                }

            }
        }
        invalidate();
    }
}
