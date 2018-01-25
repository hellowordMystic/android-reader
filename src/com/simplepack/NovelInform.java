package com.simplepack;

public class NovelInform {	
	
		private int totalChapter;		 
		private String novelName;
		 
		 public void SetTotalChapter(int total)    //设置小说章节总数
		 {
			 totalChapter=total;
		 }
		 public void SetNovelName(String novelname)    //设置小说名
		 {
			 novelName=novelname;
		 }
		 
	
      
     public static NovelInform[] novel=new NovelInform[4];
     
     public void NovelInform()
     {     	     	
    	 novel[0].novelName="孽海花";novel[0].totalChapter=10;
    	 novel[1].novelName="儒林外史";novel[1].totalChapter=10;
    	 novel[2].novelName="水浒传";novel[2].totalChapter=5;
    	 novel[3].novelName="西游记";novel[3].totalChapter=5; 	 
     }
     
}
