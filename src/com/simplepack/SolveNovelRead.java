package com.simplepack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader; 
import android.content.Context;
import android.widget.Toast; 
import java.io.*; 

public class SolveNovelRead {
	BufferedReader Readin;
	InputStream is;
	private Context myContext; 
	public SolveNovelRead(Context c) { this.myContext = c; } 
	public void Read_in_Novel(int position)
	{
		 try
	     { 	   	 
	       String Str;
	       String content="";
	       
	  	   //is = getResources().openRawResource(R.raw.hlchapter_1+1);   	   
	  	   Readin=new BufferedReader(new InputStreamReader(is,"GBK")); 
	  	    
	  	   while((Str=Readin.readLine())!=null)
	  		   content+=Str;
	     }      
	     catch(IOException ex)
	     {   
	    	 
	     }    
	}
}

