package org.pythonsogood;

import java.util.List;

import org.pythonsogood.enums.StoreNotificationType;
import org.pythonsogood.products.Customer;
import org.pythonsogood.products.Store;
import org.pythonsogood.products.StoreItem;

public class Main {
    public static void main(String[] args) {
		Store store = new Store();

		Customer customer1 = new Customer(store);
		Customer customer2 = new Customer(store);

		customer1.setStoreNotificationFilter(List.of(StoreNotificationType.NewItem));

		customer1.subscribeStoreNotifications();

		StoreItem socks1 = store.addNewItem("socks", "they are cool", 2.5f);

		customer2.subscribeStoreNotifications();

		StoreItem socks2 = store.addNewItem("another socks", "they are better than previous ones", 2.5f);

		store.setItemPriceDollars(socks1, 2.3f);
    }
}