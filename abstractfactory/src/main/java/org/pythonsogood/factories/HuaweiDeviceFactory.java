package org.pythonsogood.factories;

import org.pythonsogood.interfaces.DeviceFactory;
import org.pythonsogood.interfaces.Laptop;
import org.pythonsogood.interfaces.Phone;
import org.pythonsogood.products.MateBook;
import org.pythonsogood.products.MatePhone;

public class HuaweiDeviceFactory implements DeviceFactory {
	public Laptop createLaptop() {
		return new MateBook();
	}

	public Phone createPhone() {
		return new MatePhone();
	}
}
