package by.tsarionok.service;


import by.tsarionok.entity.Gift;
import by.tsarionok.entity.Shop;
import by.tsarionok.view.GiftView;
import by.tsarionok.view.MenuView;
import by.tsarionok.view.ShopView;

import static by.tsarionok.service.ScannerLogic.*;

public class GiftCreator {

	private boolean run = true;
	private MenuView mView = new MenuView();
	private Gift gift;
	private Shop shop;

	public GiftCreator(Shop shop) {
		super();
		this.shop = shop;
	}

	public Gift run() {

		gift = new Gift();

		while (run) {

			mView.mainMenu();
			setChoice(getMainMenuChoice());

		}
		return gift;
	}

	private void setChoice(String choice) {

		GiftView gView = new GiftView();
		ShopView sView = new ShopView();
		GiftLogic gLogic = new GiftLogic();

		switch (choice) {
			case "1":
				sView.printSweets(shop);
				if (shop.getSweets() != null) {
					int sweet = getSweetChoice(shop);
					mView.howMany();
					int count = getNumberChoice();
					gLogic.addCandy(gift, shop.getSweets().get(sweet), count);
					sView.sucflyAddCandy(shop, sweet, count);
				}
				break;
			case "2":
				sView.printPacks(shop);
				if (shop.getPacks() != null) {
					int pack = getPackChoice(shop);
					gift.setPack(shop.getPacks().get(pack));
					sView.sucflyAddPack(shop, pack);
				}
				break;
			case "3":
				gView.GiftContent(gift);
				break;
			case "q":
				this.run = false;
				break;
			default:
				break;
		}
	}
}
