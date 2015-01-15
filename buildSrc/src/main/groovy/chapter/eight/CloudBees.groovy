package chapter.eight;

public class CloudBees implements PlatformAsAService {
    private String appId, url, key, secret, version, format;

    @Override
    void setAppId(String appId) {
        this.appId = appId
    }

    @Override
    void setURL(String url) {
        this.url = url
    }

    @Override
    void setKey(String key) {
        this.key = key
    }

    @Override
    void setVersion(String version) {
        this.version = version
    }

    @Override
    void apiFormat(String format) {
        this.format = format
    }

    @Override
    Map<String, String> applicationInfo(String appId) {
        [
                url    : url,
                key    : key,
                version: version,
                format : format

        ]
    }

    @Override
    void applicationDeployWar(String appId) {
        println 'War Deployed on cloudBees'
    }


}