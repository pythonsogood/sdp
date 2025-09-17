package org.pythonsogood;

import org.pythonsogood.factories.AndroidApplicationFactory;
import org.pythonsogood.factories.IOSApplicationFactory;
import org.pythonsogood.interfaces.Application;

public class Main {
    public static void main(String[] args) {
		AndroidApplicationFactory androidApplicationFactory = new AndroidApplicationFactory();
		IOSApplicationFactory iOSApplicationFactory = new IOSApplicationFactory();

        Developer androidDeveloper = new Developer(androidApplicationFactory);
		Developer iOSDeveloper = new Developer(iOSApplicationFactory);

		Application androidApplication = androidDeveloper.developApplication();
		androidApplication.run();

		Application iOSApplication = iOSDeveloper.developApplication();
		iOSApplication.run();
    }
}