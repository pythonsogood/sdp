package org.pythonsogood.factories;

import org.pythonsogood.interfaces.Application;
import org.pythonsogood.interfaces.ApplicationFactory;
import org.pythonsogood.products.AndroidApplication;

public class AndroidApplicationFactory implements ApplicationFactory {
	public Application developApplication() {
		return new AndroidApplication();
	}
}
