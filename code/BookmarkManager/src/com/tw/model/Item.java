package com.tw.model;
/**
 * item model
 * @author lijin
 *
 */
public class Item {
	private Integer id;
	private String name;
	private double oriPrice;   //price before tax
	private double curPrice;   //price after tax
	private boolean isImport;  //yes-true  no-false   
	private Integer special;   //0-free  1-10% tax
	
	public static double tax = 0;
	public static double oriTotal = 0;  //total price before tax
	public static double curTotal = 0;   //total price after tax
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public double getOriPrice() {
		return oriPrice;
	}
	public void setOriPrice(double oriPrice) {
		this.oriPrice = oriPrice;
	}
	public double getCurPrice() {
		return curPrice;
	}
	public void setCurPrice(double curPrice) {
		this.curPrice = curPrice;
	}
	public boolean getIsImport() {
		return isImport;
	}
	public void setIsImport(boolean isImport) {
		this.isImport = isImport;
	}
	public Integer getSpecial() {
		return special;
	}
	public void setSpecial(Integer special) {
		this.special = special;
	}
	

}
