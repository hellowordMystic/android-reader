package com.example.reader;
 
 
import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.content.Intent; 
import android.view.Menu;
import android.view.MenuItem;

public class AboutUs extends Activity{
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aboutus);
        
        ImageView UsIamge=(ImageView) findViewById(R.id.image); 
        UsIamge.setImageResource(R.drawable.usmassage); 
         
	}
	/*����menu*/
	public boolean onCreateOptionsMenu(Menu menu)
	{
		//Ϊmenu�������
		menu.add(0, 0, 0, R.string.ok);
		menu.add(0, 1, 1, R.string.back);
		return true;
	}

	/*����menu���¼�*/
	public boolean onOptionsItemSelected(MenuItem item)
	{
		//�õ���ǰѡ�е�MenuItem��ID,
		int item_id = item.getItemId();
		
		switch (item_id)
		{
			case 0:
			case 1:
				/* �½�һ��Intent���� */
				Intent intent = new Intent();
				/* ָ��intentҪ�������� */
				intent.setClass(AboutUs.this, MiniReader.class);
				/* ����һ���µ�Activity */
				startActivity(intent);
				/* �رյ�ǰ��Activity */
				AboutUs.this.finish();
				break;
		}
		return true;
	}

}
