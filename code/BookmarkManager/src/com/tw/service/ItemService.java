package com.tw.service;

import java.util.ArrayList;
import java.util.List;

import com.tw.db.ItemInfo;
import com.tw.model.Item;

/**
 * 
 * @author lijin
 *
 */
public class ItemService {
	
	ItemInfo itemInfo = new ItemInfo();
	/**
	 * @param list request items 
	 * @return items information after calculate
	 */
	public List<Item> getItemInfo(List<Item> list){
		itemInfo.cleanItemList();
		List<Item> newList = new ArrayList<Item>();
		for (int i = 0; i < list.size(); i++) {
			Item item = list.get(i);
			item.setName(itemInfo.getItemInfo(item.getId()).getName());
			item.setSpecial(itemInfo.getItemInfo(item.getId()).getSpecial());
			if (item.getIsImport()) {
				if (item.getSpecial() == 0) {
				//	item.setCurPrice(Util.getFormat(item.getOriPrice()  * (1 + TaxValInter.importTax)));
					
				}else if (item.getSpecial() == 1) {
				//	item.setCurPrice(Util.getFormat(item.getOriPrice() * (1 + TaxValInter.normalTax + TaxValInter.importTax)));
				}
			}else {
				if (item.getSpecial() == 0) {
					item.setCurPrice(item.getOriPrice());
				}else if (item.getSpecial() == 1) {
		//			item.setCurPrice(Util.getFormat(item.getOriPrice() * (1 + TaxValInter.normalTax)));
				}
			}
			
			newList.add(item);
			Item.oriTotal += item.getOriPrice();
			Item.curTotal += item.getCurPrice();
			
		}
		return newList;
	}
	
	public List<Item> getAllItemInfo(){
		return itemInfo.getAllItemInfo();
	}
	
	/**
	 * @return total tax
	 */
	public double getTax(){
	//	return Util.getFormatNumber(Item.curTotal-Item.oriTotal);
		return 0;
	}
	
	/**
	 * @return total after-tax price
	 */
	
	public double getTotal(){
		return Item.curTotal;
	}

}
