package org.pythonsogood;

import org.pythonsogood.factories.AppleDeviceFactory;
import org.pythonsogood.factories.HuaweiDeviceFactory;
import org.pythonsogood.interfaces.DeviceFactory;
import org.pythonsogood.interfaces.Laptop;
import org.pythonsogood.interfaces.Phone;

public class Main {
    public static void main(String[] args) {
        DeviceFactory appleDeviceFactory = new AppleDeviceFactory();
		DeviceFactory huaweiDeviceFactory = new HuaweiDeviceFactory();

		Laptop appleLaptop = appleDeviceFactory.createLaptop();
		appleLaptop.run();

		Phone applePhone = appleDeviceFactory.createPhone();
		applePhone.call();

		Laptop huaweiLaptop = huaweiDeviceFactory.createLaptop();
		huaweiLaptop.run();

		Phone huaweiPhone = huaweiDeviceFactory.createPhone();
		huaweiPhone.call();
    }
}