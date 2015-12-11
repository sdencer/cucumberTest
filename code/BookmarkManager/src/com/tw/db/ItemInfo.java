package com.tw.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.tw.model.Item;
/**
 * item DB information
 * @author lijin
 *
 */
public class ItemInfo {
	private Map<Integer, Item> map = new HashMap<Integer, Item>();
	/**
	 * get item by id
	 * @param id item id
	 * @return item
	 */
	public Item getItemInfo(Integer id){
		if (map.isEmpty()) {
			initItemDb();
		}
		return map.get(id);
	}
	/**
	 * @return all the items
	 */
	public List<Item> getAllItemInfo(){
		if (map.isEmpty()) {
			initItemDb();
		}
		List<Item> list = new ArrayList<Item>();
		Iterator it=map.keySet().iterator();
		while(it.hasNext()){
			Integer key=Integer.parseInt(it.next().toString());
			list.add(map.get(key));
		}
 		return list;
	}
	
	/**
	 * item DB
	 */
	private void initItemDb(){
		Item item1 = new Item();
		item1.setId(1);
		item1.setName("book");
		item1.setSpecial(0);
		map.put(item1.getId(), item1);
		
		Item item2 = new Item();
		item2.setId(2);
		item2.setName("music CD");
		item2.setSpecial(1);
		map.put(item2.getId(), item2);
		
		Item item3 = new Item();
		item3.setId(3);
		item3.setName("chocolate bar");
		item3.setSpecial(0);
		map.put(item3.getId(), item3);
		
		
		Item item4 = new Item();
		item4.setId(4);
		item4.setName("box of chocolates");
		item4.setSpecial(0);
		map.put(item4.getId(), item4);
		
		Item item5 = new Item();
		item5.setId(5);
		item5.setName("bottle of perfume");
		item5.setSpecial(1);
		map.put(item5.getId(), item5);
		
		Item item6 = new Item();
		item6.setId(6);
		item6.setName("packet of headache pills");
		item6.setSpecial(0);
		map.put(item6.getId(), item6);
		

	}
	
	/**
	 * initialize the static value
	 */
	public void cleanItemList(){
		Item.tax = 0;
		Item.oriTotal = 0;
		Item.curTotal = 0;
	}
}
