package by.tsarionok.controller;

import by.tsarionok.entity.Pack;
import by.tsarionok.entity.Shop;
import by.tsarionok.entity.Sweet;
import by.tsarionok.service.GiftCreator;

public class Main {

	public static void main(String[] args) {

		Shop shop = new Shop();
		shop.getPacks().add(new Pack("multi-colored package"));
		shop.getPacks().add(new Pack("standard package"));
		shop.getSweets().add(new Sweet("plate", true));
		shop.getSweets().add(new Sweet("biscuits", true));
		shop.getSweets().add(new Sweet("candy", false));
		shop.getSweets().add(new Sweet("lollipop", false));

		new GiftCreator(shop).run();

	}
}
