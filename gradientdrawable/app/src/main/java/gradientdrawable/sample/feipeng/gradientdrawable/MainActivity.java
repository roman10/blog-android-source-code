package gradientdrawable.sample.feipeng.gradientdrawable;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

  private static final int[] drawableResIds = new int[] {
    // solid
    R.drawable.shape_rectangle_solid,
    R.drawable.shape_oval_solid,
    R.drawable.shape_ring_solid,
    R.drawable.shape_line_solid,
    // stroke
    R.drawable.shape_rectangle_stroke,
    R.drawable.shape_oval_stroke,
    R.drawable.shape_ring_stroke,
    R.drawable.shape_line_stroke,
    // specific
    R.drawable.shape_rectangle_specific,
    R.drawable.shape_oval_size,
    R.drawable.shape_ring_specific,
    R.drawable.shape_line_size,
    // linear gradient
    R.drawable.shape_rectangle_gradient_linear,
    R.drawable.shape_oval_gradient_linear,
    R.drawable.shape_ring_gradient_linear,
    R.drawable.shape_line_gradient_linear,
    // radial gradient
    R.drawable.shape_rectangle_gradient_radial,
    R.drawable.shape_oval_gradient_radial,
    R.drawable.shape_ring_gradient_radial,
    R.drawable.shape_line_gradient_radial,
    // sweep gradient
    R.drawable.shape_rectangle_gradient_sweep,
    R.drawable.shape_oval_gradient_sweep,
    R.drawable.shape_ring_gradient_sweep,
    R.drawable.shape_line_gradient_sweep,
   };

  private static final String[] strings = new String[] {
    "Rect solid",
    "Oval solid",
    "Ring solid",
    "Line solid",
    "Rect stroke",
    "Oval stroke",
    "Ring stroke",
    "Line stroke",
    "Rect specific",
    "Oval size",
    "Ring specific",
    "Line size",
    "Rect linear gradient",
    "Oval linear gradient",
    "Ring linear gradient",
    "Line linear gradient",
    "Rect radial gradient",
    "Oval radial gradient",
    "Ring radial gradient",
    "Line radial gradient",
    "Rect sweep gradient",
    "Oval sweep gradient",
    "Ring sweep gradient",
    "Line sweep gradient",
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    GridView gridView = (GridView) findViewById(R.id.grid);
    DrawableAdapter adapter = new DrawableAdapter(this, drawableResIds, strings);
    gridView.setAdapter(adapter);
  }


}
