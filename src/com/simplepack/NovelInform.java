package com.simplepack;

public class NovelInform {	
	
		private int totalChapter;		 
		private String novelName;
		 
		 public void SetTotalChapter(int total)    //����С˵�½�����
		 {
			 totalChapter=total;
		 }
		 public void SetNovelName(String novelname)    //����С˵��
		 {
			 novelName=novelname;
		 }
		 
	
      
     public static NovelInform[] novel=new NovelInform[4];
     
     public void NovelInform()
     {     	     	
    	 novel[0].novelName="������";novel[0].totalChapter=10;
    	 novel[1].novelName="������ʷ";novel[1].totalChapter=10;
    	 novel[2].novelName="ˮ䰴�";novel[2].totalChapter=5;
    	 novel[3].novelName="���μ�";novel[3].totalChapter=5; 	 
     }
     
}
