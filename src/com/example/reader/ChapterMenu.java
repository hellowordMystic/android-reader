package com.example.reader;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;  
import java.util.ArrayList;
import java.util.List;  
import com.simplepack.*;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter; 
import android.widget.ListView;  



public class ChapterMenu extends Activity{ 
	    MiniNovel novel=new MiniNovel();
	    private ListView listview;  
     
	    Bundle bd = new Bundle();                    //用于Activity之间传值
	    int chapter;                                  
	    int pos;  //小说
		 /** Called when the activity is first created. */
	   @Override
	   public void onCreate(Bundle savedInstanceState){
	       super.onCreate(savedInstanceState);
	       
	       Bundle bu = this.getIntent().getExtras();
	       pos=bu.getInt("filename");
	       
	       listview = new ListView(this);
	       listview.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1, getData(pos)));
	       setContentView(listview);  //显示章回列表
	       
	      
	       
	       listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){                 // 监听事件
	    	   
	       	public void onItemClick(AdapterView<?> parent,View v,int position,long id) 
	       	{
	       		 
	       	    
	       		Intent in = new Intent();
				/* 指定intent要启动的类 */
				bd.putInt("chapter", position); //将数据传递到ShowNovel
				in.putExtras(bd);
				in.setClass(ChapterMenu.this,ReadContent.class);
				/* 启动一个新的Activity */
				startActivity(in );					  
				/* 关闭当前的Activity */
				ChapterMenu.this.finish();	    	    
	       	}
	       });
	   }
	   private List<String> getData(int id){                     //设置章回列表
	   	  int i=0;
	   	  int Len=0;
	   	  String str;
	   	  int chapterid=0;
	   	  
	   	  switch(id)
	   	  {
	   	    case 0:   chapterid=R.string.nhchapter1;Len=MiniNovel.totalChapters[0];break;
	   	    case 1:   chapterid=R.string.rlchapter1;Len=MiniNovel.totalChapters[1];break;
	   	    case 2:   chapterid=R.string.shchapter1;Len=MiniNovel.totalChapters[2];break;
	   	    case 3:   chapterid=R.string.xychapter1;Len=MiniNovel.totalChapters[3];break;
	   	  }
	 	  List<String> data=new ArrayList<String>();
	 	   for(i=0;i<Len;i++)
	 	   {
	 		   str=getString(chapterid+i);	 		    
	 		   data.add(str);
	 	   }
	 	   return data;
	  }

}
