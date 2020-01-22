package by.tsarionok.entity;

import java.util.ArrayList;
import java.util.List;

public class Gift {

	private List<List<Sweet>> sweets;
	private Pack pack;

	public Gift() {
		super();
		this.sweets = new ArrayList<List<Sweet>>();
		this.pack = new Pack();
	}

	public Gift(Pack pack) {
		super();
		this.sweets = new ArrayList<List<Sweet>>();
		this.pack = pack;
	}

	public List<List<Sweet>> getSweets() {
		return sweets;
	}

	public void setSweets(List<List<Sweet>> sweets) {
		this.sweets = sweets;
	}

	public Pack getPack() {
		return pack;
	}

	public void setPack(Pack pack) {
		this.pack = pack;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pack == null) ? 0 : pack.hashCode());
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
		Gift other = (Gift) obj;
		if (pack == null) {
			if (other.pack != null)
				return false;
		} else if (!pack.equals(other.pack))
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
		return "Gift [sweets=" + sweets + ", pack=" + pack + "]";
	}

}
