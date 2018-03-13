package test.domain;

/**
 * This class represents a single discount
 */
public class Discount {

	/**
	 * Number of unit of discount pack
	 */
	private Long units;
	
	/**
	 * Price for the discount pack
	 */
	private Double price;

	/**
	 * Gets the number of unit of discount pack
	 * 
	 * @return the number of units
	 */
	public Long getUnits() {
		return units;
	}

	/**
	 * Sets the number of unit of discount pack
	 * 
	 * @param units, new value of discount pack units
	 */
	public void setUnits(Long units) {
		this.units = units;
	}

	/**
	 * Gets price for the discount pack
	 * 
	 * @return price for the discount pack
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * Sets the price discount pack
	 * 
	 * @param price, new price
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	
}
