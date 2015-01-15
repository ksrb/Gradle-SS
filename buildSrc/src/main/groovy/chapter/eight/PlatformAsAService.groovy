package chapter.eight;

public interface PlatformAsAService {
    void setAppId(String appId)

    void setURL(String url)

    void setKey(String key)

    void setVersion(String version)

    void apiFormat(String format)

    Map<String, String> applicationInfo(String appId)

    void applicationDeployWar(String appId) throws Exception
}