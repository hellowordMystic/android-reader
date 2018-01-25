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
	
	/*��������*/
	 MiniNovel novelID=new MiniNovel();
	 Bundle bd = new Bundle();       //����Activity֮�����ݴ���
	 int position;
	 int count;                       //�������ڷ�ҳ
	 int pos;  //С˵
	 
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
     
     /*����TextView����*/     
     tv=(TextView) findViewById(R.id.text1);
     tv.setBackgroundColor(Color.WHITE);
	 tv.setTextColor(Color.BLACK);
     
	 /*��ȡ����Activity���������ݣ�С˵�½ڣ�*/     
	 Bundle bd = this.getIntent().getExtras(); 
     position=bd.getInt("chapter");
      
     pos=novelID.getNovelID();
     
     /*��ȡ��Ӧ�½ڵ�����*/  
     count=position;           //count���ڵ������һҳ����һҳʱ���ж��Ƿ�Ϊ��һҳ�����һҳ
	 
     ReadInNovel(position,pos);
     
 } 
 
 
 /**
  * ��ת1��Ӧ�¼�
  * 
  *
  */
	public class MyListener implements OnClickListener{

		/**
		 * ����ť�������ʱ����õķ���
		 */
		public void onClick(View v) {
			/*����TextView����*/     
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
 
 
    /*����menu*/
	public boolean onCreateOptionsMenu(Menu menu)
	{
		MenuInflater inflater = getMenuInflater();
		
		//����menu����Ϊres/menu/menu.xml
		inflater.inflate(R.layout.menu1, menu);
		return true;		
	}
	
    /*��ȡС˵�½����ݷ���ʵ��*/
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
		//Toast.makeText(ReadContent.this,"��ѡ����"+pos+" ��С˵",Toast.LENGTH_SHORT).show();
		 try
	     {  		   
	       String Str;
	       String content="";
	       
	  	   is = getResources().openRawResource(novel+position);   	   
	  	   Readin=new BufferedReader(new InputStreamReader(is,"GBK")); 
	  	    
	  	   while((Str=Readin.readLine())!=null)
	  		   content+=Str;
	  	   tv.setText(content);  	  //ֱ��ͨ����д�ֽ�������ʽ ��ȡ.txt�ļ������Դ
	     }      
	     catch(IOException ex)
	     {    	    
	     }    
	}
 
	/*����˵��¼�*/
	public boolean onOptionsItemSelected(MenuItem item)
	{
		//�õ���ǰѡ�е�MenuItem��ID,
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
			     Toast.makeText(ReadContent.this, "�Զ��͵�����빺����ʽ�棡��", Toast.LENGTH_SHORT).show();break;	
		        
			case R.id.back:
				/* �½�һ��Intent���� */
				Intent intent1 = new Intent();
				/* ָ��intentҪ�������� */
				intent1.setClass(ReadContent.this, NovelMenu.class);
				/* ����һ���µ�Activity */
				startActivity(intent1);
				
				/* �رյ�ǰ��Activity */
				ReadContent.this.finish();
				break;
			case R.id.exit:
				
				Dialog dialog = new AlertDialog.Builder(ReadContent.this)
				.setTitle("�˳���ʾ")
				.setMessage("�����Ҫ�˳���")//��������
				.setPositiveButton("ȷ��",
			      new DialogInterface.OnClickListener() 
				   {
					  public void onClick(DialogInterface dialog, int whichButton)
					 {//����ȷ����ť
						  ReadContent.this.finish();
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
