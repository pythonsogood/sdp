package org.pythonsogood.factories;

import org.pythonsogood.interfaces.Application;
import org.pythonsogood.interfaces.ApplicationFactory;
import org.pythonsogood.products.IOSApplication;

public class IOSApplicationFactory implements ApplicationFactory {
	public Application developApplication() {
		return new IOSApplication();
	}
}
