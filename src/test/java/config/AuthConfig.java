package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:auth.properties"
})

public interface AuthConfig extends Config {

    @Key("user_name")
    String userName();

    @Key("access_key")
    String accessKey();

    @Key("project")
    String project();

    @Key("build")
    String build();

    @Key("name")
    String name();

}
