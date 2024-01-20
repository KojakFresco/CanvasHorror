package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

import androidx.annotation.NonNull;

public class MyView extends View {
    public MyView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.YELLOW); // цвет маркера
        paint.setStyle(Paint.Style.FILL); // тип заливки
        paint.setStrokeWidth(10);
        paint.setTextSize(100);
        paint.setAntiAlias(true); // сглаживание

        canvas.drawColor(Color.WHITE); // фон
        canvas.drawCircle(50, 50, 100, paint);

        for (double i = -1; i < 4; i += 0.1) {
            canvas.drawLine(50, 50, (float) (Math.sin(i) * 400), (float) (Math.cos(i) * 400), paint);
        }


        for (int i = 0; i < 1000; i += 100) {
            int yStart = Math.min(2000 - i, 1800);
            canvas.drawLine(Math.min(800, 650 + i * 0.75f), yStart, Math.max(500,i * 0.75f), Math.max(1600 - i, 900), paint);
        }

        Path path = new Path();
        path.moveTo(100, 100);
        path.lineTo(500, 500);
        path.lineTo(100, 400);
        paint.setColor(Color.GREEN);
        canvas.drawPath(path, paint);


    }
}
