package test.domain;

/**
 * This class represent stock item
 */
public class Item {

	/**
	 * The id of the item
	 */
	private Long id;
	
	/**
	 * Item designation
	 */
	private String designation;
	
	/**
	 * Item price
	 */
	private Double price;

	/**
	 * Gets the id of the item
	 * 
	 * @return the id of this item
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id of the item
	 * 
	 * @param id, new id of the item
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the desigantion of the item
	 * 
	 * @return the designation of this item
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 * Sets a new designation of the item
	 * 
	 * @param designation, new designation value
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	/**
	 * Gets the item price
	 * 
	 * @return the price of this item
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * Sets the price of the item
	 * 
	 * @param price, new price of this item
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Item other = (Item) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
