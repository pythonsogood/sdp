package org.pythonsogood.products;

public class StoreItem {
	private String title;
	private String description;
	private float priceDollars;

	public StoreItem(String title, String description, float priceDollars) {
		this.title = title;
		this.description = description;
		this.priceDollars = priceDollars;
	}

	public String getTitle() {
		return this.title;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPriceDollars() {
		return this.priceDollars;
	}

	public void setPriceDollars(float priceDollars) {
		this.priceDollars = priceDollars;
	}
}
