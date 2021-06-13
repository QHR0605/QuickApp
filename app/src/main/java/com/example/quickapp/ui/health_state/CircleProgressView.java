package com.example.quickapp.ui.health_state;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.example.quickapp.R;

/**
 * Created by dell on 2017/5/29.
 */

public class CircleProgressView extends View {

    private int mInnerColor = Color.BLUE; //不动 的圆的画笔的颜色
    private int mOutColor = Color.RED;   //外面动的圆的画笔的颜色
    private Paint mInnerPaint; //不动圆的画笔
    private Paint mOutPaint; //动的圆弧的画笔
    private Paint mTextPaint;
    private int mRoundWidth = 7;
    private int mTextColor = Color.BLACK;
    private int mTextSize = 20; //sp
    private int mCurrentProgress = 0; //当前进度
    private int mMax = 100; //总进度

    public CircleProgressView(Context context) {
         this(context,null);
    }

    public CircleProgressView(Context context, AttributeSet attrs) {
         this(context,attrs,0);
    }

    //获取属性
    public CircleProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CircleProgressView);
        mInnerColor = a.getColor(R.styleable.CircleProgressView_innerCicleColor,mInnerColor);
        mOutColor = a.getColor(R.styleable.CircleProgressView_outCicleColor,mOutColor);
        mRoundWidth = (int)a.getDimension(R.styleable.CircleProgressView_roundWidth,dp2px(mRoundWidth));
        mTextSize = a.getDimensionPixelSize(R.styleable.CircleProgressView_progressTextSize,sp2px(mTextSize));
        a.recycle();
        mInnerPaint = new Paint();
        mInnerPaint.setColor(mInnerColor);
        mInnerPaint.setAntiAlias(true); //抗锯齿
        mInnerPaint.setStrokeWidth(mRoundWidth);
        mInnerPaint.setStyle(Paint.Style.STROKE); //空心圆

        mOutPaint = new Paint();
        mOutPaint.setColor(mOutColor);
        mOutPaint.setAntiAlias(true); //抗锯齿
        mOutPaint.setStrokeWidth(mRoundWidth);
        mOutPaint.setStyle(Paint.Style.STROKE); //空心圆

        mTextPaint = new Paint();
        mTextPaint.setTextSize(mTextSize);
        mTextPaint.setColor(mTextColor);
    }

    private int sp2px(int size) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,size,getResources().getDisplayMetrics());
    }

    private float dp2px(int roundWith) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,roundWith,getResources().getDisplayMetrics());
    }

    //测量
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(Math.min(width, height), Math.min(width, height)); //宽高一致，保证是一个正方形
    }

    //绘制
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制内圆
        int center = getWidth()/2;
        canvas.drawCircle(center,center,center-mRoundWidth/2,mInnerPaint);
        //绘制外圆
        RectF rectF = new RectF(mRoundWidth/2,mRoundWidth/2,getWidth()-mRoundWidth/2,getHeight()-mRoundWidth/2);
        if (mCurrentProgress == 0){
            return;
        }

        float percent = (float)mCurrentProgress/mMax;
        canvas.drawArc(rectF,0,percent*360,false,mOutPaint); //false 表示不包括圆心

        //绘制文字
        String textString = ((int)(percent*100))+"%";
        Rect bounds = new Rect();
        mTextPaint.getTextBounds(textString,0,textString.length(),bounds);
        int dy = (mTextPaint.getFontMetricsInt().bottom-mTextPaint.getFontMetricsInt().top)/2-mTextPaint.getFontMetricsInt().bottom;
        int baseLine = getHeight()/2 + dy;
        canvas.drawText(textString,getWidth()/2-bounds.width()/2,baseLine,mTextPaint);
    }

    public synchronized void setMax(int max) {
        this.mMax = max;
    }

    //暴露给外面调用 设置当前值 不断调用ondraw方法
    public synchronized void setCurrentProgress(int currentProgress) {
        this.mCurrentProgress = currentProgress;
        invalidate();
    }
}
