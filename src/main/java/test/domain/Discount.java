package test.domain;

/**
 * This class represents a single discount
 */
public class Discount {

	private Long units;
	
	private Double price;

	public Long getUnits() {
		return units;
	}

	public void setUnits(Long units) {
		this.units = units;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
}
