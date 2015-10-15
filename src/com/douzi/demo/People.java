package com.douzi.demo;

public class People
{
	private String peopleName;
	private int imageId;
	private String PeopleNumber;

	public People(String peopleName, int imageId, String peopleNumber)
	{
		super();
		this.peopleName = peopleName;
		this.imageId = imageId;
		PeopleNumber = peopleNumber;
	}

	public String getPeopleName()
	{
		return peopleName;
	}

	public void setPeopleName(String peopleName)
	{
		this.peopleName = peopleName;
	}

	public int getImageId()
	{
		return imageId;
	}

	public void setImageId(int imageId)
	{
		this.imageId = imageId;
	}

	public String getPeopleNumber()
	{
		return PeopleNumber;
	}

	public void setPeopleNumber(String peopleNumber)
	{
		PeopleNumber = peopleNumber;
	}

}
