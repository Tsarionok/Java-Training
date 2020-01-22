package by.tsarionok.entity;

import java.util.ArrayList;
import java.util.List;

public class Shop {

	private List<Pack> packs;
	private List<Sweet> sweets;

	public Shop() {
		this.packs = new ArrayList<Pack>();
		this.sweets = new ArrayList<Sweet>();
	}

	public List<Pack> getPacks() {
		return packs;
	}

	public void setPacks(List<Pack> packs) {
		this.packs = packs;
	}

	public List<Sweet> getSweets() {
		return sweets;
	}

	public void setSweets(List<Sweet> sweets) {
		this.sweets = sweets;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((packs == null) ? 0 : packs.hashCode());
		result = prime * result + ((sweets == null) ? 0 : sweets.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shop other = (Shop) obj;
		if (packs == null) {
			if (other.packs != null)
				return false;
		} else if (!packs.equals(other.packs))
			return false;
		if (sweets == null) {
			if (other.sweets != null)
				return false;
		} else if (!sweets.equals(other.sweets))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Shop [packs=" + packs + ", sweets=" + sweets + "]";
	}

}
