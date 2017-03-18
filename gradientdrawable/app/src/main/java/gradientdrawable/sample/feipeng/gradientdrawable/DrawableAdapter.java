package gradientdrawable.sample.feipeng.gradientdrawable;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public final class DrawableAdapter extends BaseAdapter {

  private final class ViewHolder {
    private final ImageView imageView;
    private final TextView textView;

    public ViewHolder(View rootView) {
      imageView = (ImageView) rootView.findViewById(R.id.image);
      textView = (TextView) rootView.findViewById(R.id.text);
    }
  }

  private final int[] drawableResIds;
  private final String[] strings;
  private final Context context;
  private final LayoutInflater inflater;

  public DrawableAdapter(Context context, int[] drawableResIds, String[] strings) {
    this.drawableResIds = drawableResIds;
    this.strings = strings;
    this.context = context;
    inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
  }

  @Override
  public int getCount() {
    return drawableResIds.length;
  }

  @Override
  public Object getItem(int position) {
    return drawableResIds[position];
  }

  @Override
  public long getItemId(int position) {
    return position;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    ViewHolder viewHolder;
    View gridView;
    if (convertView == null) {
      gridView = inflater.inflate(R.layout.grid_item, parent, false);
      viewHolder = new ViewHolder(gridView);
    } else {
      gridView = convertView;
      viewHolder = (ViewHolder) convertView.getTag();
    }
    gridView.setTag(viewHolder);
    viewHolder.textView.setText(strings[position]);
    viewHolder.imageView.setImageResource(drawableResIds[position]);
    // For line shape, it won't work properly because of the bug:
    // https://code.google.com/p/android/issues/detail?id=29944, so we disable hardware acceleration
    viewHolder.imageView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
//    viewHolder.imageView.setBackgroundResource(drawableResIds[position]);
    return gridView;
  }
}
