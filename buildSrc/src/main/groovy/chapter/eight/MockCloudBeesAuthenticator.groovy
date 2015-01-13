package chapter.eight;

public class MockCloudBeesAuthenticator implements ApiAuthenticator {
    private String url, key, secret, version, format;

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

    def applicationInfo(String appId) throws Exception {
        [
                url    : url,
                key    : key,
                version: version,
                format : format

        ]
    }

}