package by.tsarionok.entity;

public class Sweet {

	private String name;
	private boolean chocolate;

	public Sweet(String name, boolean chocolate) {
		this.name = name;
		this.chocolate = chocolate;
	}

	public Sweet(String name) {
		this.name = name;
		this.chocolate = true;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isChocolate() {
		return chocolate;
	}

	public void setChocolate(boolean chocolate) {
		this.chocolate = chocolate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (chocolate ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Sweet other = (Sweet) obj;
		if (chocolate != other.chocolate)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sweets [name=" + name + ", chocolate=" + chocolate + "]";
	}

}
