package com.example.reader;

 
import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.AdapterView.OnItemClickListener;
import com.simplepack.*;

 

public class NovelMenu extends Activity {
	MiniNovel novel=new MiniNovel();
	Bundle bd = new Bundle();
	int filename;
	 /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.novelmenu);
        
        Gallery g=(Gallery) findViewById(R.id.myGallery1);
        g.setAdapter(new ImageAdapter(this));//Gallery ͼƬ�ؼ�
        g.setBackgroundResource(R.drawable.bg0);
        g.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v, int position, long id)
			{					
				novel.setNovelID(position);
				Intent intent =new Intent();
				/* ָ��intentҪ�������� */
				bd.putInt("filename", position);				
				
				intent.putExtras(bd);
				intent.setClass(NovelMenu.this,ChapterMenu.class);
				/* ����һ���µ�Activity */
				startActivity(intent);					  
				/* �رյ�ǰ��Activity */
				NovelMenu.this.finish(); 		         
			}
       });
    }

}
