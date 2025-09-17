package org.pythonsogood.factories;

import org.pythonsogood.interfaces.DeviceFactory;
import org.pythonsogood.interfaces.Laptop;
import org.pythonsogood.interfaces.Phone;
import org.pythonsogood.products.IPhone;
import org.pythonsogood.products.MacBook;

public class AppleDeviceFactory implements DeviceFactory {
	public Laptop createLaptop() {
		return new MacBook();
	}

	public Phone createPhone() {
		return new IPhone();
	}
}
