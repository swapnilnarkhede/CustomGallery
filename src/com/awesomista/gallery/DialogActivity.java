package com.awesomista.gallery;

import com.awesomista.customdialog.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class DialogActivity extends Activity {

	Gallery myGallery;
	TextView mySelection;
    @SuppressWarnings("deprecation")
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        myGallery = (Gallery) findViewById(R.id.gallary);

		myGallery.setAdapter(new ImageAdapter(this));
		
//		myGallery.setOnItemSelectedListener(new OnItemSelectedListener() {
//
//			public void onItemSelected(AdapterView<?> parent, View v,
//					int position, long id) {
//				mySelection.setText(" selected option: " + position );
//				
//			}
//
//			public void onNothingSelected(AdapterView<?> parent) {
//				mySelection.setText("Nothing selected");
//				
//			}
//
//
//		});
	}// onCreate

	public class ImageAdapter extends BaseAdapter {
		/** The parent context */
		private Context myContext;
		// Put some images to project-folder: /res/drawable/
		// format: jpg, gif, png, bmp, ...
		private int[] myImageIds = { R.drawable.image1, R.drawable.image2,
				       R.drawable.image3, R.drawable.ic_launcher };

		/** Simple Constructor saving the 'parent' context. */
		public ImageAdapter(Context c) {
			this.myContext = c;
		}

		// inherited abstract methods - must be implemented
		// Returns count of images, and individual IDs
		public int getCount() {
			return this.myImageIds.length;
		}

		public Object getItem(int position) {
			return position;
		}

		public long getItemId(int position) {
			return position;
		}
		// Returns a new ImageView to be displayed,
		public View getView(int position, View convertView, 
				ViewGroup parent) {

			// Get a View to display image data 					
			ImageView iv = new ImageView(this.myContext);
			iv.setImageResource(this.myImageIds[position]);

			// Image should be scaled somehow
//			iv.setScaleType(ImageView.ScaleType.CENTER);
			//iv.setScaleType(ImageView.ScaleType.CENTER_CROP);			
			//iv.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
			//iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
//			iv.setScaleType(ImageView.ScaleType.FIT_XY);
			iv.setScaleType(ImageView.ScaleType.FIT_END);
			
			// Set the Width & Height of the individual images
			iv.setLayoutParams(new Gallery.LayoutParams(95, 70));

			return iv;
		}
	}// ImageAdapter



    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_dialog, menu);
        return true;
    }

    
}
