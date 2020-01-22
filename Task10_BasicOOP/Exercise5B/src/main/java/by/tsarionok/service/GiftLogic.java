package by.tsarionok.service;

import by.tsarionok.entity.Gift;
import by.tsarionok.entity.Sweet;

import java.util.ArrayList;

public class GiftLogic {

	public boolean addCandy(Gift gift, Sweet sweet, int count) {

		for (int i = 0; i != count; i++) {

			int index = getIndex(gift, sweet);

			if (index == -1) {
				gift.getSweets().add(new ArrayList<Sweet>());
				gift.getSweets().get(gift.getSweets().size() - 1).add(sweet);

			} else {
				gift.getSweets().get(index).add(sweet);
			}
		}
		return true;
	}

	private int getIndex(Gift gift, Sweet sweet) {

		for (int i = 0; i < gift.getSweets().size(); i++) {
			if (gift.getSweets().get(i).contains(sweet)) {
				return i;
			}
		}
		return -1;
	}
}
