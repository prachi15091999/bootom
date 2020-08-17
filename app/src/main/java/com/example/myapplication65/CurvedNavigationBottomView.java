package com.example.myapplication65;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CurvedNavigationBottomView extends BottomNavigationView {
    private Path mpath;
    private Paint mpaint;
    public final int Curve_Circle_Radius=90;
    public Point mfirstcurvedstrtingpoint=new Point();
    public Point mfirstcurvedendpoint=new Point();
    public Point mfirstcurvedcontrolpoint1=new Point();
    public Point mfirstcurvedcontrolpoint2=new Point();
    public Point msecondcurvedstrtingpoint=new Point();
    public Point msecondcurvedendpoint=new Point();
    public Point msecondcurvedcontrolpoint1=new Point();
    public Point msecondcurvedcontrolpoint2=new Point();

    public int mNavigationBarWidth,mNavigationBarHeight;

    public CurvedNavigationBottomView(Context context) {
        super(context);
        initView();
    }

    public CurvedNavigationBottomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public CurvedNavigationBottomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        mpath=new Path();
        mpaint=new Paint();
        mpaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mpaint.setColor(Color.YELLOW);
        setBackgroundColor(Color.TRANSPARENT);
    }
    protected void onSizeChanged(int w,int h,int oldw,int oldh)
    {
        super.onSizeChanged(w,h,oldw,oldh);
        mNavigationBarWidth=getWidth();
        mNavigationBarHeight=getHeight();
        mfirstcurvedstrtingpoint.set((mNavigationBarWidth/2)
                -(Curve_Circle_Radius*2)
                -(Curve_Circle_Radius/3),0);
        mfirstcurvedendpoint.set((mNavigationBarWidth/2),Curve_Circle_Radius+(Curve_Circle_Radius/4));
        msecondcurvedstrtingpoint=mfirstcurvedendpoint;
    msecondcurvedendpoint.set((mNavigationBarWidth/2)
            +(Curve_Circle_Radius*2)
            +(Curve_Circle_Radius/3),0);
    mfirstcurvedcontrolpoint1.set(mfirstcurvedstrtingpoint.x+(Curve_Circle_Radius/4)+Curve_Circle_Radius,mfirstcurvedstrtingpoint.y);
    mfirstcurvedcontrolpoint2.set(mfirstcurvedendpoint.x-(Curve_Circle_Radius*2)+Curve_Circle_Radius,mfirstcurvedendpoint.y);
    msecondcurvedcontrolpoint1.set(msecondcurvedstrtingpoint.x+(Curve_Circle_Radius*2)-Curve_Circle_Radius,msecondcurvedstrtingpoint.y);
    msecondcurvedcontrolpoint2.set(msecondcurvedendpoint.x-(Curve_Circle_Radius+(Curve_Circle_Radius/4)),msecondcurvedendpoint.y);

    }
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        mpath.reset();
        mpath.moveTo(0,0);
        mpath.lineTo(mfirstcurvedstrtingpoint.x,mfirstcurvedstrtingpoint.y);
        mpath.cubicTo(mfirstcurvedcontrolpoint1.x,mfirstcurvedcontrolpoint1.y,mfirstcurvedcontrolpoint2.x,mfirstcurvedcontrolpoint2.y,mfirstcurvedendpoint.x,mfirstcurvedendpoint.y);
        mpath.cubicTo(msecondcurvedcontrolpoint1.x,msecondcurvedcontrolpoint1.y,msecondcurvedcontrolpoint2.x,msecondcurvedcontrolpoint2.y,msecondcurvedendpoint.x,msecondcurvedendpoint.y);
        mpath.lineTo(mNavigationBarWidth,0);
        mpath.lineTo(mNavigationBarWidth,mNavigationBarHeight);
        mpath.lineTo(0,mNavigationBarHeight);
        mpath.close();
        canvas.drawPath(mpath,mpaint);
    }
}
