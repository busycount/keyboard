package com.busycount.keyboard;

import android.content.Context;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;

/**
 * LetterKeyboard
 * <p>
 * 2018/12/13 | Count.C | Created
 */
public class LetterKeyboard extends KeyboardView {
    public LetterKeyboard(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public LetterKeyboard(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public LetterKeyboard(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        initKeyboard(context);
        initAttr(context, attrs);
    }

    private void initAttr(Context context, AttributeSet attrs) {

    }

    private void initKeyboard(Context context) {
        Keyboard keyboard = new Keyboard(context, R.xml.letterkeyboard);
        setKeyboard(keyboard);
        setPreviewEnabled(false);
        setOnKeyboardActionListener(new OnKeyboardActionListener() {
            @Override
            public void onPress(int primaryCode) {

            }

            @Override
            public void onRelease(int primaryCode) {

            }

            @Override
            public void onKey(int primaryCode, int[] keyCodes) {

            }

            @Override
            public void onText(CharSequence text) {

            }

            @Override
            public void swipeLeft() {

            }

            @Override
            public void swipeRight() {

            }

            @Override
            public void swipeDown() {

            }

            @Override
            public void swipeUp() {

            }
        });
    }

}
