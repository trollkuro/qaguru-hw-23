package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.AuthConfig;
import config.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {

    protected static BrowserstackConfig mobileConfig = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());
    protected static AuthConfig authConfig = ConfigFactory.create(AuthConfig.class, System.getProperties());

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", authConfig.userName());
        caps.setCapability("browserstack.key", authConfig.accessKey());

        // Set URL of the application under test
        caps.setCapability("app", mobileConfig.app());

        // Specify device and os_version for testing
        caps.setCapability("device", mobileConfig.device());
        caps.setCapability("os_version", mobileConfig.osVersion());

        // Set other BrowserStack capabilities
        caps.setCapability("project", authConfig.project());
        caps.setCapability("build", authConfig.build());
        caps.setCapability("name", authConfig.name());

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        try {
            return new RemoteWebDriver(
                    new URL("https://hub.browserstack.com/wd/hub"), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}