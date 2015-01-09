package com.example.roman10.layerdrawabledimension;

import android.app.Activity;
import android.graphics.Matrix;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends Activity {

  private ImageView imageView;
  private LayerDrawable layerDrawable;
  private Drawable layerTwo;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    imageView = (ImageView) findViewById(R.id.imageview);
    Button button1 = (Button) findViewById(R.id.button1);
    button1.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        notWorking();
      }
    });
    Button button2 = (Button) findViewById(R.id.button2);
    button2.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        working();
      }
    });
    Button button3 = (Button) findViewById(R.id.button3);
    button3.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        reset();
      }
    });
    reset();
  }

  private void reset() {
    Drawable layerOne = new ColorDrawable(0x88FF0000);
    layerTwo = new ColorDrawable(0x88FFFFFF);
    Drawable[] layers = { layerOne, layerTwo };
    layerDrawable = new LayerDrawable(layers);
    layerDrawable.setId(0, android.R.id.background);
    imageView.setImageDrawable(layerDrawable);
    imageView.setImageMatrix(null);
  }

  private void notWorking() {
    layerTwo = getResources().getDrawable(R.drawable.ic_launcher);
    layerDrawable.setDrawableByLayerId(android.R.id.background, layerTwo);
    // This is no-op if not calling imageView.setImageDrawable(null) first
    imageView.setImageDrawable(layerDrawable);
    Matrix matrix = new Matrix();
    matrix.postRotate(60);
    imageView.setImageMatrix(matrix);
    Log.d("xxx", "matrix: " + matrix + "\n" + imageView.getImageMatrix());
  }

  private void working() {
    imageView.setImageDrawable(null); // Set the cached drawable at ImageView to null
    notWorking();
  }

}
