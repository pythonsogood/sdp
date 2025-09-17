package org.pythonsogood;

import org.pythonsogood.interfaces.Application;
import org.pythonsogood.interfaces.ApplicationFactory;

public class Developer {
	private ApplicationFactory applicationFactory;

	public Developer(ApplicationFactory applicationFactory) {
		this.applicationFactory = applicationFactory;
	}

	public Application developApplication() {
		return applicationFactory.developApplication();
	}
}
