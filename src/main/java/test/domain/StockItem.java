package test.domain;

public class StockItem {
	
	private Item item;
	
	private Long qty;

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Long getQty() {
		return qty;
	}

	public void setQty(Long qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "StockItem [item=" + item + ", qty=" + qty + "]";
	}

}
