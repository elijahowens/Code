package commonExam2Practice;
import java.util.Scanner;
//Elijah Owens
// CS 113 014
// Professor Spirollari

public class Book {
	
	private int pages;
	private String title;
	
	public Book(int pages, String title)
	{
		this.pages = pages;
		this.title = title;
	}
	
	public int getPages()
	{
		return pages;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public void setPages(int pages)
	{
	this.pages = pages;	
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public String toString()
	{
		return ""+title+""+pages;
	}
	
	public int compareTo(int otherPages)
	{
		
		if (pages < otherPages)
			return -1;
		if (pages > otherPages)
			return 1;
		else
			return 0;
	}

}
