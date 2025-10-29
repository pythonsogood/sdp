package org.pythonsogood;

import java.util.List;

import org.pythonsogood.enums.StoreNotificationType;
import org.pythonsogood.products.customer.Customer;
import org.pythonsogood.products.store.Store;
import org.pythonsogood.products.store.StoreItem;

public class Main {
    public static void main(String[] args) {
		Store sevenElevenStore = new Store();

		Customer customerBob = new Customer("Bob");
		Customer customerAlice = new Customer("Alice");

		customerBob.setStoreNotificationFilter(List.of(StoreNotificationType.NewItem, StoreNotificationType.ItemRemoved));

		customerBob.subscribeStoreNotifications(sevenElevenStore);
		customerAlice.subscribeStoreNotifications(sevenElevenStore);

		StoreItem adidasSocks = sevenElevenStore.addNewItem("Adidas Socks", "The real socks designed by Adidas.", 2.5f);
		StoreItem farmMilk = sevenElevenStore.addNewItem("Farm Milk", "Milk from a real farm.", 2.5f);

		customerAlice.setStoreNotificationFilter(List.of(StoreNotificationType.ItemPriceUpdate));

		sevenElevenStore.setItemPriceDollars(adidasSocks, 2.3f);
		sevenElevenStore.removeItem(farmMilk);
    }
}