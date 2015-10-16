package com.douzi.demo.menu;
/**
 * 选项
 * @author administrator
 *
 */
public class Item
{
	//选项图片ID
	private int itemImg;
	//选项文字
	private String itemTitle;

	public Item(int itemImg, String itemTitle)
	{
		super();
		this.itemImg = itemImg;
		this.itemTitle = itemTitle;
	}

	public int getItemImg()
	{
		return itemImg;
	}

	public void setItemImg(int itemImg)
	{
		this.itemImg = itemImg;
	}

	public String getItemTitle()
	{
		return itemTitle;
	}

	public void setItemTitle(String itemTitle)
	{
		this.itemTitle = itemTitle;
	}

}
