package com.tw.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.tw.db.BookMarksDB;
import com.tw.model.BookMark;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class BookMarksService {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	public List<BookMark> getBookListByPage(String path, Integer pageNum){
		List<BookMark> allBooks = new BookMarksDB().initBookMarks(path);
		
		List<BookMark> bookList = new ArrayList<BookMark>();
		for (int i = (pageNum-1)*10; i < pageNum*10-1; i++) {
			
			if (i >= BookMarksDB.bookCount) {
				break;
			}
			bookList.add(allBooks.get(i));
		}
		return bookList;
	}
	
	public Integer getPageCount(){
		return BookMarksDB.bookCount/10 + 1;
	}
	
	public void addBookMark(String bookname, String bookaddr){
		List<BookMark> allBooks = BookMarksDB.allBooks;
		BookMark bookMark = new BookMark();
		bookMark.setTitle(bookname);
		bookMark.setDate(sdf.format(new Date()));
		allBooks.add(bookMark);
		BookMarksDB.bookCount++;
	}
	
	public void deleteBookMark(int index){
		List<BookMark> allBooks = BookMarksDB.allBooks;
		allBooks.remove(index);
		BookMarksDB.bookCount--;
	}
	
	public Integer getBookCount(){
		return BookMarksDB.bookCount;
	}

}
