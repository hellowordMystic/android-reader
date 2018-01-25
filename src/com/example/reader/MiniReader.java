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
        
         
         
        
    	/* ����button���¼���Ϣ */ 
        LoginButn.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v)
			{
				
				/* �½�һ��Intent���� */
				Intent intent = new Intent();
				/* ָ��intentҪ�������� */
				intent.setClass(MiniReader.this, NovelMenu.class);
				/* ����һ���µ�Activity */
				startActivity(intent);
				/* �رյ�ǰ��Activity */
				MiniReader.this.finish();
				
			}
		});
    }
    
    /*����menu*/
	public boolean onCreateOptionsMenu(Menu menu)
	{
		MenuInflater inflater = getMenuInflater();
		//����menu����Ϊres/menu/menu.xml
		inflater.inflate(R.layout.menu, menu);
		return true;
	}

	/*����˵��¼�*/
	public boolean onOptionsItemSelected(MenuItem item)
	{
		//�õ���ǰѡ�е�MenuItem��ID,
		int item_id = item.getItemId(); 

		switch (item_id)
		{
			case R.id.about:
				/* �½�һ��Intent���� */
				Intent intent = new Intent();
				/* ָ��intentҪ�������� */
				intent.setClass(MiniReader.this, AboutUs.class);
				/* ����һ���µ�Activity */
				startActivity(intent);
				/* �رյ�ǰ��Activity */
				MiniReader.this.finish();
				break;
			case R.id.exit:
				
				Dialog dialog = new AlertDialog.Builder(MiniReader.this)
				.setTitle("�˳���ʾ")
				.setMessage("�����Ҫ�˳���")//��������
				.setPositiveButton("ȷ��",
			      new DialogInterface.OnClickListener() 
				   {
					  public void onClick(DialogInterface dialog, int whichButton)
					 {//����ȷ����ť
						  MiniReader.this.finish();
					 }
				   })
				   .setNeutralButton("ȡ��",  
			      new DialogInterface.OnClickListener() 
			       {
			          public void onClick(DialogInterface dialog, int whichButton)
			          {
				        //���"�˳�"��ť֮���Ƴ�����
			        	  dialog.dismiss();
			          }
		          }).create();//������ť

		         // ��ʾ�Ի���
		           dialog.show();
				  break;
		}
		return true;
	}
}
 