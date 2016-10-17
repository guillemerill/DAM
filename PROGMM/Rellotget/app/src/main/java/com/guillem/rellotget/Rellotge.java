package com.guillem.rellotget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import java.util.GregorianCalendar;
import java.util.Calendar;
/**
 * Created by DAM on 17/10/16.
 */

public class Rellotge extends View {

    private Paint boleta;
    private Paint hores, minuts, segons;

    public Rellotge(Context context) { this(context, null, 0); }
    public Rellotge(Context context, AttributeSet attrs) { this(context, null, 0); }
    public Rellotge(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        boleta = new Paint();
        boleta.setColor(Color.LTGRAY);
        hores = new Paint();
        hores.setColor(Color.LTGRAY);
        hores.setStrokeWidth(25f);
        hores.setStrokeCap(Paint.Cap.ROUND);
    }

    @Override public void onMeasure(int widthSpec, int heightSpec) {
        int w = MeasureSpec.getSize(widthSpec);
        int h = MeasureSpec.getSize(heightSpec);
        int size = Math.min(w, h);
        setMeasuredDimension(size, size);
    }

    @Override public void onDraw(Canvas canvas) {
        int size = this.getWidth() / 2;
        canvas.translate(size, size);
        for (int i = 0; i < 360; i += 30) {
            canvas.save();
            canvas.rotate(i);
            canvas.drawCircle(0, -0.95f * size, 0.05f * size, boleta);
            canvas.restore();
        }

        GregorianCalendar ara = new GregorianCalendar();
        int h = ara.get(Calendar.HOUR);
        canvas.save();
        canvas.rotate(h*30);
        canvas.drawLine(0, 0, 0, -0.6f*size, hores);
        canvas.restore();
    }
}
