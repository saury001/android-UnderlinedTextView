package test.badola.saurabh.underlinedtextview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

public class UnderlinedTextView extends AppCompatTextView {

    private Paint paint = new Paint();
    private static final int DEFAULT_UNDERLINE_HEIGHT=2;
    private float underlineHeight = DEFAULT_UNDERLINE_HEIGHT;
    private int underLineColor;

    public UnderlinedTextView(Context context) {
        super(context);
        init();
    }

    public void setUnderlineHeight(int height){
        underlineHeight = height;
        invalidate();

    }

    public void setUnderLineColor(int color){
        underLineColor = color;
        invalidate();
    }

    public UnderlinedTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.UnderlinedTextView,0,0);
        try {
            underlineHeight = array.getDimension(R.styleable.UnderlinedTextView_underlineHeight, DEFAULT_UNDERLINE_HEIGHT);
            underLineColor = array.getColor(R.styleable.UnderlinedTextView_underlineColor, getCurrentTextColor());
        }finally {
            if(array!=null)
                array.recycle();
        }
        init();
    }

    public UnderlinedTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.UnderlinedTextView,0,0);
        try {
            underlineHeight = array.getInt(R.styleable.UnderlinedTextView_underlineHeight, DEFAULT_UNDERLINE_HEIGHT);
            underLineColor = array.getColor(R.styleable.UnderlinedTextView_underlineColor, getCurrentTextColor());
        }finally {
            if(array!=null)
                array.recycle();
        }
        init();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(0,getHeight()-underlineHeight,getWidth(),getHeight(),paint);
    }

    @Override
    public void setPadding(int left, int top, int right, int bottom) {
        super.setPadding(left, top, right, bottom+(int)underlineHeight);
    }


    private void init(){
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(underLineColor);
    }

}