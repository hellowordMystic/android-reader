package com.example.reader;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent; 
import android.view.View;
import android.widget.ImageButton;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;

public class MiniReader extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        ImageButton LoginButn=(ImageButton) findViewById(R.id.button);
        
         
         
        
    	/* 监听button的事件信息 */ 
        LoginButn.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v)
			{
				
				/* 新建一个Intent对象 */
				Intent intent = new Intent();
				/* 指定intent要启动的类 */
				intent.setClass(MiniReader.this, NovelMenu.class);
				/* 启动一个新的Activity */
				startActivity(intent);
				/* 关闭当前的Activity */
				MiniReader.this.finish();
				
			}
		});
    }
    
    /*创建menu*/
	public boolean onCreateOptionsMenu(Menu menu)
	{
		MenuInflater inflater = getMenuInflater();
		//设置menu界面为res/menu/menu.xml
		inflater.inflate(R.layout.menu, menu);
		return true;
	}

	/*处理菜单事件*/
	public boolean onOptionsItemSelected(MenuItem item)
	{
		//得到当前选中的MenuItem的ID,
		int item_id = item.getItemId(); 

		switch (item_id)
		{
			case R.id.about:
				/* 新建一个Intent对象 */
				Intent intent = new Intent();
				/* 指定intent要启动的类 */
				intent.setClass(MiniReader.this, AboutUs.class);
				/* 启动一个新的Activity */
				startActivity(intent);
				/* 关闭当前的Activity */
				MiniReader.this.finish();
				break;
			case R.id.exit:
				
				Dialog dialog = new AlertDialog.Builder(MiniReader.this)
				.setTitle("退出提示")
				.setMessage("你真的要退出吗！")//设置内容
				.setPositiveButton("确定",
			      new DialogInterface.OnClickListener() 
				   {
					  public void onClick(DialogInterface dialog, int whichButton)
					 {//设置确定按钮
						  MiniReader.this.finish();
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
 