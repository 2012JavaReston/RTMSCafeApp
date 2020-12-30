package com.cafe.service;

import java.io.PrintWriter;

import com.cafe.model.CafeMenu;

public class CafeMenuService {
	
	public static CafeMenu[] cafe = new CafeMenu[10];

	public Boolean createItem(CafeMenu item) {
		for (int i = 0; i < cafe.length; i++) {
			if (cafe[i] == null) {
				cafe[i] = item;
				return true;
			}
		}
		return false;
	}

	public Boolean updateItem(CafeMenu item) {
		for (int i = 0; i < cafe.length; i++) {
			if (cafe[i] != null) {
				if(cafe[i].getItemName().equals(item.getItemName())) {
					cafe[i] = item;
					return true;
				}
			}
		}
		return false;
	}

	public Boolean deleteItem(String itemName) {
		for (int i = 0; i < cafe.length; i++) {
			if (cafe[i] != null) {
				if(cafe[i].getItemName().equals(itemName)) {
					cafe[i] = null;
					return true;
				}
			}
		}
		return false;
	}

	public CafeMenu[] getMenu() {
		return cafe;
	}	
}
