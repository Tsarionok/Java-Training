package by.tsarionok.view;

import by.tsarionok.entity.Pack;
import by.tsarionok.entity.Shop;
import by.tsarionok.entity.Sweet;

public class ShopView {

	public void printSweets(Shop shop) {

		if (shop.getSweets() == null) {
			System.out.println("shop has no sweets");
			return;
		}
		int i = 1;
		System.out.println("shop has next sweets:");

		for (Sweet x : shop.getSweets()) {

			if (x.isChocolate()) {
				System.out.println("Press " + i++ + " to add chocolate " + x.getName());
			} else {
				System.out.println("Press " + i++ + " to add " + x.getName());
			}
		}
	}

	public void printPacks(Shop shop) {

		if (shop.getPacks() == null) {
			System.out.println("shop has no packeges");
			return;
		}
		int i = 1;
		System.out.println("shop has next packeges:");

		for (Pack x : shop.getPacks()) {
			System.out.println("Press " + i++ + " to add " + x.getType());
		}
	}

	public void sucflyAddPack(Shop shop, int i) {
		System.out.println("pack \"" + shop.getPacks().get(i).getType() + "\" successfully purchased\n");
	}

	public void sucflyAddCandy(Shop shop, int i, int count) {
		System.out.println("you have successfully bought candy " + shop.getSweets().get(i).getName() + ", quantity "
				+ count + "\n");
	}
}
