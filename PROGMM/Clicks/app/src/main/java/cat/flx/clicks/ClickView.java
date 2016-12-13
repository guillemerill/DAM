package cat.flx.clicks;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class ClickView extends View {

    private Paint paint, paintCella;
    private float x, y;
    private boolean contacte;

    public ClickView(Context context) { this(context, null, 0); }
    public ClickView(Context context, AttributeSet attrs) { this(context, attrs, 0); }
    public ClickView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10f);
        paintCella = new Paint();
        paintCella.setColor(Color.LTGRAY);
        paintCella.setStyle(Paint.Style.FILL_AND_STROKE);
        contacte = false;
    }

    @Override public void onMeasure(int widthSpec, int heightSpec) {
        int x = MeasureSpec.getSize(widthSpec);
        int y = MeasureSpec.getSize(heightSpec);
        int size = Math.min(x,y);
        setMeasuredDimension(size, size);
    }

    @Override public void draw(Canvas canvas) {
        float midaBloc = getWidth() / 5.0f;
        int fila = (int)(y / midaBloc);
        int columna = (int)(x / midaBloc);
        canvas.drawRect(0.5f, 0.5f, getWidth()-0.5f, getHeight()-0.5f, paint);
        if (contacte) {
            canvas.drawRect(columna*midaBloc, fila*midaBloc, (columna+1)*midaBloc, (fila+1)*midaBloc, paintCella);
            canvas.drawLine(0f, y, getWidth(), y, paint);
            canvas.drawLine(x, 0f, x, getHeight(), paint);
        }
    }

    @Override public boolean onTouchEvent(MotionEvent event) {
        x = event.getX();
        y = event.getY();
        int action = event.getAction();
        switch(action) {
            case MotionEvent.ACTION_DOWN:
                Log.d("flx", "DOWN en " + x + "," + y);
                contacte = true;
                break;
            case MotionEvent.ACTION_UP:
                Log.d("flx", "UP en " + x + "," + y);
                contacte = false;
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("flx", "MOVE en " + x + "," + y);
                contacte = true;
                break;
        }
        this.invalidate();
        return true;
    }
}
