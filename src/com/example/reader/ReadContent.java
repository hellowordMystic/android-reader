package com.example.reader; 

 
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle; 
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.graphics.Color;
import android.widget.Toast;
import java.io.*; 
import com.simplepack.*;


public class ReadContent extends Activity {
	
	/*变量声明*/
	 MiniNovel novelID=new MiniNovel();
	 Bundle bd = new Bundle();       //用于Activity之间数据传递
	 int position;
	 int count;                       //计数用于翻页
	 int pos;  //小说
	 
	 private Button bt_1=null;
	 private Button bt_2=null;
	 private Button bt_3=null;
	 private Button bt_4=null;
	 
	 TextView tv;
	 BufferedReader Readin;
	 InputStream is;
	     
	 /** Called when the activity is first created. */
 @Override
 public void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     setContentView(R.layout.readcontent); 
     
     bt_1=(Button) this.findViewById(R.id.button1);        
	 bt_1.setOnClickListener(new MyListener());
	 
	 bt_2=(Button) this.findViewById(R.id.button2);        
	 bt_2.setOnClickListener(new MyListener());
	 
	 bt_3=(Button) this.findViewById(R.id.button3);        
	 bt_3.setOnClickListener(new MyListener());
	 
	 bt_4=(Button) this.findViewById(R.id.button4);        
	 bt_4.setOnClickListener(new MyListener());
     
     /*设置TextView属性*/     
     tv=(TextView) findViewById(R.id.text1);
     tv.setBackgroundColor(Color.WHITE);
	 tv.setTextColor(Color.BLACK);
     
	 /*获取其它Activity传来的数据（小说章节）*/     
	 Bundle bd = this.getIntent().getExtras(); 
     position=bd.getInt("chapter");
      
     pos=novelID.getNovelID();
     
     /*读取对应章节的内容*/  
     count=position;           //count用于当点击上一页或下一页时，判断是否为第一页或最后一页
	 
     ReadInNovel(position,pos);
     
 } 
 
 
 /**
  * 跳转1响应事件
  * 
  *
  */
	public class MyListener implements OnClickListener{

		/**
		 * 当按钮被点击的时候调用的方法
		 */
		public void onClick(View v) {
			/*设置TextView属性*/     
		     tv=(TextView) findViewById(R.id.text1);
			if(v==bt_1){				
				tv.setBackgroundColor(Color.WHITE);
				tv.setTextColor(Color.RED);
				tv.setTextSize(20);
			}else if(v == bt_2){
				tv.setBackgroundColor(Color.WHITE);
				tv.setTextColor(Color.BLACK);
				tv.setTextSize(10);
			}else if(v == bt_3){
				tv.setBackgroundColor(Color.BLUE);
				tv.setTextColor(Color.BLACK);
				tv.setTextSize(20);
			}else if(v == bt_4){
				tv.setBackgroundColor(Color.WHITE);
				tv.setTextColor(Color.BLACK);
				tv.setTextSize(15);
			}
			
		     
			 ReadInNovel(position,pos);
			
			
		}
		
	}
 
 
    /*创建menu*/
	public boolean onCreateOptionsMenu(Menu menu)
	{
		MenuInflater inflater = getMenuInflater();
		
		//设置menu界面为res/menu/menu.xml
		inflater.inflate(R.layout.menu1, menu);
		return true;		
	}
	
    /*读取小说章节内容方法实现*/
	void ReadInNovel(int position,int pos)
	{
		int novel=0;
		switch(pos)
		{
		  case 0:  novel=R.raw.nhchapter_1; break;    
		  case 1:  novel=R.raw.rlchapter_1; break;    
		  case 2:  novel=R.raw.shchapter_1; break;
		  case 3:  novel=R.raw.xychapter_1; break;    
		}
		//Toast.makeText(ReadContent.this,"你选择了"+pos+" 号小说",Toast.LENGTH_SHORT).show();
		 try
	     {  		   
	       String Str;
	       String content="";
	       
	  	   is = getResources().openRawResource(novel+position);   	   
	  	   Readin=new BufferedReader(new InputStreamReader(is,"GBK")); 
	  	    
	  	   while((Str=Readin.readLine())!=null)
	  		   content+=Str;
	  	   tv.setText(content);  	  //直接通过读写字节流的形式 读取.txt文件里的资源
	     }      
	     catch(IOException ex)
	     {    	    
	     }    
	}
 
	/*处理菜单事件*/
	public boolean onOptionsItemSelected(MenuItem item)
	{
		//得到当前选中的MenuItem的ID,
		int item_id = item.getItemId(); 
        
 		switch (item_id)
		{  
		    case R.id.orgi:
		    	if(count>=1)
		        {
		    	  count--;
		    	  ReadInNovel(count,pos);		           	         
		        } 		    	
		    	 break;
		  
			case R.id.next:
				if(count<novelID.totalChapters[pos]-1)
		        {
				  count++;
				  ReadInNovel(count,pos);		
		        } 
				else
			     Toast.makeText(ReadContent.this, "试读就到这里，请购买正式版！！", Toast.LENGTH_SHORT).show();break;	
		        
			case R.id.back:
				/* 新建一个Intent对象 */
				Intent intent1 = new Intent();
				/* 指定intent要启动的类 */
				intent1.setClass(ReadContent.this, NovelMenu.class);
				/* 启动一个新的Activity */
				startActivity(intent1);
				
				/* 关闭当前的Activity */
				ReadContent.this.finish();
				break;
			case R.id.exit:
				
				Dialog dialog = new AlertDialog.Builder(ReadContent.this)
				.setTitle("退出提示")
				.setMessage("你真的要退出吗！")//设置内容
				.setPositiveButton("确定",
			      new DialogInterface.OnClickListener() 
				   {
					  public void onClick(DialogInterface dialog, int whichButton)
					 {//设置确定按钮
						  ReadContent.this.finish();
					 }
				   })
				   .setNeutralButton("取消",  
			      new DialogInterface.OnClickListener() 
			       {
			          public void onClick(DialogInterface dialog, int whichButton)
			          {
				        //点击"退出"按钮之后推出程序
			        	  dialog.dismiss();
			          }
		          }).create();//创建按钮

		         // 显示对话框
		           dialog.show();
				  break;
		}
		return true;
	}
}
