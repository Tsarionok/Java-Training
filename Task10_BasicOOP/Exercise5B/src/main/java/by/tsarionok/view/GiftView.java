package by.tsarionok.view;

import by.tsarionok.entity.Gift;

public class GiftView {

	public void GiftContent(Gift gift) {

		if (gift.getPack().getType() == null) {
			System.out.println("The gift has no packaging");
		} else {
			System.out.println("The gift has " + gift.getPack().getType());
		}

		if (!gift.getSweets().isEmpty()) {

			System.out.println("Gift has next sweets:");
			for (int i = 0; i < gift.getSweets().size(); i++) {

				System.out.println(
						gift.getSweets().get(i).get(0).getName() + " quantity - " + gift.getSweets().get(i).size());

			}
		} else {
			System.out.println("There are no sweets in the gift");
		}
		System.out.println();
	}
}
