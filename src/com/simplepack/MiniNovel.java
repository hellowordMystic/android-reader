package com.simplepack;

import java.util.ArrayList;
import java.util.List;  

public class MiniNovel {
	
	//ͨ��List�б������С˵�� ͨ������ID��ʵ�ֵ�������
   public static List<String> NovelName=new ArrayList<String>();      //�������С˵��
   private static int novelID;               	//��ѡ�е�С˵ID
   public static int[] totalChapters=new int[4]; //����ÿ��С˵��Ӧ���ܵ��½���
   
   public void setNovelID(int id)
   {
	   novelID=id;
   }
   public int getNovelID()
   {
	   return novelID;
   }
   
   public MiniNovel()//��ʼ��
   {
	   NovelName.add("������");
	   NovelName.add("������ʷ");
	   NovelName.add("ˮ䰴�");
	   NovelName.add("���μ�");
	   
	   totalChapters[0]=5;
	   totalChapters[1]=9;
	   totalChapters[2]=5;
	   totalChapters[3]=5;
   }
}