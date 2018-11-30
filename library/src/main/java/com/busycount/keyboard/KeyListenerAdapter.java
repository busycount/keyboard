package com.busycount.keyboard;

import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;

/**
 * KeyListener Adapter
 * <p>
 * 2018/11/26 | Count.C | Created
 */
public class KeyListenerAdapter implements OnNumKeyListener, KeyboardView.OnKeyboardActionListener {

    private OnNumKeyListener onNumKeyListener;
    private KeyboardView.OnKeyboardActionListener onKeyboardActionListener;

    @Override
    public void onPress(int primaryCode) {
        if (onKeyboardActionListener != null) {
            onKeyboardActionListener.onPress(primaryCode);
        }
    }

    @Override
    public void onRelease(int primaryCode) {
        if (onKeyboardActionListener != null) {
            onKeyboardActionListener.onRelease(primaryCode);
        }
    }

    @Override
    public void onKey(int primaryCode, int[] keyCodes) {
        if (primaryCode == Keyboard.KEYCODE_DELETE) {
            onKeyDelete();
        } else if (primaryCode == Keyboard.KEYCODE_DONE) {
            onKeyDone();
        } else {
            onKeyNum((char) primaryCode);
        }
        if (onKeyboardActionListener != null) {
            onKeyboardActionListener.onKey(primaryCode, keyCodes);
        }
    }

    @Override
    public void onKeyNum(char num) {
        if (onNumKeyListener != null) {
            onNumKeyListener.onKeyNum(num);
        }
    }

    @Override
    public void onKeyDelete() {
        if (onNumKeyListener != null) {
            onNumKeyListener.onKeyDelete();
        }
    }

    @Override
    public void onKeyDone() {
        if (onNumKeyListener != null) {
            onNumKeyListener.onKeyDone();
        }
    }

    @Override
    public void onText(CharSequence text) {
        if (onKeyboardActionListener != null) {
            onKeyboardActionListener.onText(text);
        }
    }

    @Override
    public void swipeLeft() {
        if (onKeyboardActionListener != null) {
            onKeyboardActionListener.swipeLeft();
        }
    }

    @Override
    public void swipeRight() {
        if (onKeyboardActionListener != null) {
            onKeyboardActionListener.swipeRight();
        }
    }

    @Override
    public void swipeDown() {
        if (onKeyboardActionListener != null) {
            onKeyboardActionListener.swipeDown();
        }
    }

    @Override
    public void swipeUp() {
        if (onKeyboardActionListener != null) {
            onKeyboardActionListener.swipeUp();
        }
    }

    public OnNumKeyListener getOnNumKeyListener() {
        return onNumKeyListener;
    }

    public void setOnNumKeyListener(OnNumKeyListener onNumKeyListener) {
        this.onNumKeyListener = onNumKeyListener;
    }

    public KeyboardView.OnKeyboardActionListener getOnKeyboardActionListener() {
        return onKeyboardActionListener;
    }

    public void setOnKeyboardActionListener(KeyboardView.OnKeyboardActionListener onKeyboardActionListener) {
        this.onKeyboardActionListener = onKeyboardActionListener;
    }
}
