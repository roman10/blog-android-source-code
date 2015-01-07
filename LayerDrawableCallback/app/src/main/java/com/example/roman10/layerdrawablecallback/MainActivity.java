package com.example.roman10.layerdrawablecallback;

import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends ActionBarActivity {

  private ActionBar actionBar;
  private Drawable launcherIconDrawable;
  private ColorDrawable colorLayer;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Button btn1 = (Button) findViewById(R.id.button1);
    btn1.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        // 1. This sets launcherIconDrawable.callback to actionBar
        actionBar.setBackgroundDrawable(launcherIconDrawable);
        animateActionBarWorking();
      }
    });
    Button btn2 = (Button) findViewById(R.id.button2);
    btn2.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        // 1. This sets launcherIconDrawable.callback to actionBar
        actionBar.setBackgroundDrawable(launcherIconDrawable);
        animateActionBarNotWorking();
      }
    });
    actionBar = getSupportActionBar();
    launcherIconDrawable = getResources().getDrawable(R.drawable.launcher_repeat);
    colorLayer = new ColorDrawable(Color.rgb(0, 255, 0));
    actionBar.setBackgroundDrawable(colorLayer);
  }

  private void animateActionBarNotWorking() {
    Drawable[] layers = new Drawable[] { colorLayer, launcherIconDrawable };
    // 2. This sets launcherIconDrawable.callback to layerDrawable
    LayerDrawable layerDrawable = new LayerDrawable(layers);
    // 3. This sets launcherIconDrawable.callback to null
    actionBar.setBackgroundDrawable(layerDrawable);
    ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 255);
    valueAnimator.setDuration(1000);
    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
      @Override
      public void onAnimationUpdate(ValueAnimator animation) {
        // 4. Updates launcherIconDrawable will not trigger action bar background to update
        // as launcherIconDrawable.callback is null
        launcherIconDrawable.setAlpha((Integer) animation.getAnimatedValue());
      }
    });
    valueAnimator.start();
  }

  private void animateActionBarWorking() {
    actionBar.setBackgroundDrawable(null);
    animateActionBarNotWorking();
  }



}
