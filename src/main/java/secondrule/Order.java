package secondrule;

import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrate a rules engine that calculates total price and sales tax whenever
 * items are added or removed to/from an order.
 * 
 * @author ranichol
 *
 */
public class Order {

	private Double subTotal;
	private Double salesTax;
	private String description;
	private List<Item> items;

	public Order(String description) {
		super();
		this.description = description;
		items = new ArrayList<>();
		subTotal = 0.0;
		salesTax = 0.0;
	}

	/**
	 * @return the subTotal
	 */
	public Double getSubTotal() {
		return subTotal;
	}

	/**
	 * @param subTotal
	 *            the subTotal to set
	 */
	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	/**
	 * @return the salesTax
	 */
	public Double getSalesTax() {
		return salesTax;
	}

	/**
	 * @param salesTax
	 *            the salesTax to set
	 */
	public void setSalesTax(Double salesTax) {
		this.salesTax = salesTax;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the items
	 */
	public List<Item> getItems() {
		return items;
	}

	/**
	 * @param items
	 *            the items to set
	 */
	public void addItem(Item item) {
		items.add(item);
	}

	public void removeItem(Item item) {
		items.remove(item);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format(
				"Order [subTotal=%s, salesTax=%s, description=%s, items=%s]",
				subTotal, salesTax, description, items);
	}
}
