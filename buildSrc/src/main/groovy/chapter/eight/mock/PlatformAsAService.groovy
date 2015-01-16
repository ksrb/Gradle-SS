package chapter.eight.mock;

public interface PlatformAsAService {

    void setURL(String url)

    void setKey(String key)

    void setSecret(String secret)

    void setVersion(int version)

    void setFormat(String format)

    Map<String, String> applicationInfo(String appId)

    void applicationDeployWar(String appId) throws Exception
}