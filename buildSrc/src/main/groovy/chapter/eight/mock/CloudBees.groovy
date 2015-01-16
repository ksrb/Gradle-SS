package chapter.eight.mock;

public class CloudBees implements PlatformAsAService {
    private String key
    private String secret
    private String url
    private int version
    private String format

    @Override
    void setURL(String url) {
        this.url = url
    }

    @Override
    void setKey(String key) {
        this.key = key
    }

    @Override
    void setSecret(String secret) {
        this.secret = secret
    }

    @Override
    void setVersion(int version) {
        this.version = version
    }

    @Override
    void setFormat(String format) {
        this.format = format
    }

    @Override
    Map<String, String> applicationInfo(String appId) {
        [
                appId  : appId,
                key    : key,
                url    : url,
                secret : secret,
                version: version,
                format : format

        ]
    }

    @Override
    void applicationDeployWar(String appId) {
        println "$appId deployed on cloudBees as a WAR"
    }


}