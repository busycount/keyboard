package com.busycount.keyboard;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;

import java.util.List;

/**
 * NumKeyboard
 * <p>
 * 2018/11/26 | Count.C | Created
 */
public class NumKeyboard extends KeyboardView {

    public NumKeyboard(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public NumKeyboard(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public NumKeyboard(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private KeyListenerAdapter keyListenerAdapter = new KeyListenerAdapter();

    private Drawable bgDelete;
    private Drawable bgDone;
    private Drawable icDelete;
    private Drawable icDone;

    private void init(Context context, AttributeSet attrs) {
        initKeyboard(context);
        initAttr(context, attrs);
    }

    private void initAttr(Context context, AttributeSet attrs) {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.NumKeyboard);
        bgDelete = ta.getDrawable(R.styleable.NumKeyboard_bgDelete);
        bgDone = ta.getDrawable(R.styleable.NumKeyboard_bgDone);
        icDelete = ta.getDrawable(R.styleable.NumKeyboard_iconDelete);
        icDone = ta.getDrawable(R.styleable.NumKeyboard_iconDone);
        ta.recycle();
    }

    private void initKeyboard(Context context) {
        Keyboard keyboard = new Keyboard(context, R.xml.numkeyboard);
        setKeyboard(keyboard);
        //不展示预览
        setPreviewEnabled(false);
        setOnKeyboardActionListener(null);
    }


    @Override
    public void setOnKeyboardActionListener(OnKeyboardActionListener listener) {
        keyListenerAdapter.setOnKeyboardActionListener(listener);
        super.setOnKeyboardActionListener(keyListenerAdapter);
    }

    @Override
    public OnKeyboardActionListener getOnKeyboardActionListener() {
        return keyListenerAdapter;
    }

    public OnNumKeyListener getOnNumKeyListener() {
        return this.keyListenerAdapter.getOnNumKeyListener();
    }

    public void setOnNumKeyListener(OnNumKeyListener onNumKeyListener) {
        this.keyListenerAdapter.setOnNumKeyListener(onNumKeyListener);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        List<Keyboard.Key> keyList = getKeyboard().getKeys();
        for (Keyboard.Key key : keyList) {
            if (key.codes[0] == Keyboard.KEYCODE_DELETE) {
                drawKeyBackground(canvas, key, bgDelete);
                drawKeyIcon(canvas, key, icDelete, 0.4f);
            } else if (key.codes[0] == Keyboard.KEYCODE_DONE) {
                drawKeyBackground(canvas, key, bgDone);
                drawKeyIcon(canvas, key, icDone, 0.7f);
            }
        }
    }

    private void drawKeyBackground(Canvas canvas, Keyboard.Key key, Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setBounds(key.x, key.y + getPaddingTop(), key.x + key.width, key.y + getPaddingTop() + key.height);
        int[] drawableState = key.getCurrentDrawableState();
        drawable.setState(drawableState);
        drawable.draw(canvas);
    }

    private void drawKeyIcon(Canvas canvas, Keyboard.Key key, Drawable drawable, float factor) {
        if (drawable == null) {
            return;
        }
        int imgWidth = drawable.getIntrinsicWidth();
        int imgHeight = drawable.getIntrinsicHeight();
        if (imgWidth > key.width * factor || imgHeight > key.height * factor) {
            float scale;
            if (imgWidth / imgHeight > key.width / key.height) {
                scale = key.width * factor / imgWidth;
            } else {
                scale = key.height * factor / imgHeight;
            }
            int nWidth = (int) (imgWidth * scale);
            int nHeight = (int) (imgHeight * scale);
            int startX = (key.width - nWidth) / 2 + key.x;
            int startY = (key.height - nHeight) / 2 + key.y + getPaddingTop();
            drawable.setBounds(startX, startY, startX + nWidth, startY + nHeight);
        } else {
            int startX = (key.width - imgWidth) / 2 + key.x;
            int startY = (key.height - imgHeight) / 2 + key.y + getPaddingTop();
            drawable.setBounds(startX, startY, startX + imgWidth, startY + imgHeight);
        }
        int[] drawableState = key.getCurrentDrawableState();
        drawable.setState(drawableState);
        drawable.draw(canvas);
    }
}
