package com.example.reader;

 
import android.content.Context;
import android.widget.Gallery;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter{
	    private Context myContext; 
	    
	    
	    private int[] myImageIds =
	                  { 
	                     R.drawable.nhh,
	                     R.drawable.rlws,
	                     R.drawable.sh,
	                     R.drawable.xyj,
	                  }; 
	     
	    public ImageAdapter(Context c) { this.myContext = c; } 

	    
	    public int getCount() 
	    { 
	    	return this.myImageIds.length; 
	    } 

	    
	    public Object getItem(int position)
	    { 
	    	return position; 
	    } 
	    public long getItemId(int position) 
	    { 
	    	return position; 
	    }
	    
	    
	    public View getView(int position, View convertView, ViewGroup parent)
	    { 	       
	      ImageView i = new ImageView(this.myContext);
	      
	      i.setImageResource(this.myImageIds[position]);
	      i.setScaleType(ImageView.ScaleType.FIT_XY); 	      
	      i.setLayoutParams(new Gallery.LayoutParams(140, 190)); 
	      
	      return i; 
	    } 
	    
	    public float getScale(boolean focused, int offset)
	    { 	       
	      return Math.max(0,1.0f/(float)Math.pow(2,Math.abs(offset)));
	    } 

}
