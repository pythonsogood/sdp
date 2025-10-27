package org.pythonsogood.products;

public class StoreItem {
	private String title;
	private String description;

	public StoreItem(String title, String description) {
		this.title = title;
		this.description = description;
	}

	public String getTitle() {
		return this.title;
	}

	public String getDescription() {
		return this.description;
	}
}
