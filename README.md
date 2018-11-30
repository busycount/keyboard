# Numkeyboard

## Use

1. In your xml 

```xml
<com.busycount.keyboard.NumKeyboard
  android:id="@+id/numKeyboard"
  android:layout_width="wrap_content"
  android:layout_height="wrap_content"
  android:background="@color/color_D2D5DB"
  android:keyBackground="@drawable/key"
  android:keyTextColor="@color/color_000000"
  android:shadowRadius="0"
  app:iconDelete="@drawable/ic_delete"
  app:iconDone="@drawable/ic_submit" />
```

2. In your Activity

```java
numKeyboard.setOnNumKeyListener(new OnNumKeyListener() {
    @Override
  public void onKeyNum(char num) {
    }

    @Override
  public void onKeyDelete() {
    }

    @Override
  public void onKeyDone() {
    }
});
```

  

## implementation
Step 1. Add the JitPack repository to your build file Add it in your root build.gradle at the end of repositories:
```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Step 2. Add the dependency, [Lastest release](https://github.com/busycount/keyboard/releases)
```
dependencies {
    implementation 'com.github.busycount:keyboard:lastest'
}
```

