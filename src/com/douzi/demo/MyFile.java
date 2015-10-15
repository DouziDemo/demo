package com.douzi.demo;

public class MyFile
{
	private String fileName;
	private int imageId;
	public MyFile(String fileName, int imageId)
	{
		super();
		this.fileName = fileName;
		this.imageId = imageId;
	}
	public String getFileName()
	{
		return fileName;
	}
	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}
	public int getImageId()
	{
		return imageId;
	}
	public void setImageId(int imageId)
	{
		this.imageId = imageId;
	}
}
