package com.simplepack;

import java.util.ArrayList;
import java.util.List;  

public class MiniNovel {
	
	//通过List列表来存放小说名 通过设置ID来实现单击操作
   public static List<String> NovelName=new ArrayList<String>();      //存放所有小说名
   private static int novelID;               	//被选中的小说ID
   public static int[] totalChapters=new int[4]; //保存每部小说对应的总的章节数
   
   public void setNovelID(int id)
   {
	   novelID=id;
   }
   public int getNovelID()
   {
	   return novelID;
   }
   
   public MiniNovel()//初始化
   {
	   NovelName.add("孽海花");
	   NovelName.add("儒林外史");
	   NovelName.add("水浒传");
	   NovelName.add("西游记");
	   
	   totalChapters[0]=5;
	   totalChapters[1]=9;
	   totalChapters[2]=5;
	   totalChapters[3]=5;
   }
}