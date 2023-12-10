package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${platform}.properties"
})

public interface BrowserstackConfig extends Config {

    @Key("user_name")
    String userName();

    @Key("access_key")
    String accessKey();

    @Key("device")
    String device();

    @Key("os_version")
    String osVersion();

    @Key("application")
    String app();
}
