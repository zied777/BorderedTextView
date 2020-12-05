package customViews;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.Nullable;

// We extend the standard class TextView, so our class will behave like a standard TextView by default and we will extend its behavior

@SuppressLint("AppCompatCustomView")
public class BorderedTextView extends TextView {

    // our brush to draw with it
    private Paint paint;

    // There are other constructors, but we'll focus on this one, don't mind about AttributeSet it just represent the parameters defined on the XML.
    public BorderedTextView(Context context, @Nullable AttributeSet attrs) {
        // just pass those parameters to parent class
        super(context, attrs);

        //Init and Customize our Brush
        paint = new Paint();
        //Set Black as Color
        paint.setColor(Color.BLACK);
        //This is the style of the brush, we will talk about this in a hole next lesson, for now use STROKE
        paint.setStyle(Paint.Style.STROKE);
        // We set a stroke width, i.e. the width of borders in our case, as said leave those to next lessons
        paint.setStrokeWidth(10);
    }

    // to customize our view, we must override the onDraw method

    @Override
    protected void onDraw(Canvas canvas) {
        //must call super onDraw
        super.onDraw(canvas);

        //draw a border around the TextView
        // getWidth() and getHeight() returns the size of the view
        // You can think of paint as your brush, you can customize it with different methods, primarily you need to define style and color
        //But never never never do it in this method as it will decrease you app performance significantly, we will do that in cosntructor
        canvas.drawRect(0,0,getWidth(), getHeight(), paint);
    }
}
