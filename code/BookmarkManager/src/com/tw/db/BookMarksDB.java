package com.tw.db;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.tw.model.BookMark;
import com.tw.util.FileHelper;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class BookMarksDB {
	public static Integer bookCount = 0;
	public static List<BookMark> allBooks = new LinkedList<BookMark>();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	public List<BookMark> initBookMarks(String path){
		if (allBooks.size() != 0) {
			bookCount = allBooks.size();
			return allBooks;
		}
		String jsonContext = FileHelper.readFile(path+"\\data\\bookmarks.json");
		JSONArray jsonArray = JSONArray.fromObject(jsonContext);
		int size = jsonArray.size();
		bookCount = size;
		
		for(int  i = 0; i < size; i++){
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			
			BookMark bookMark = new BookMark();
			bookMark.setTitle(jsonObject.get("title").toString());
			long date = Long.parseLong(jsonObject.get("created").toString());
			
			bookMark.setDate(sdf.format(new Date(date)));
			allBooks.add(bookMark);
			
		//	System.out.println("[" + i + "]name=" + jsonObject.get("title"));
			//System.out.println("[" + i + "]package_name=" + jsonObject.get("created"));
		}
		return allBooks;
	}
	
	

}
