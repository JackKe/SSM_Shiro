package cn.likegirl.untils;

/**
 * Created by Z.
 */
public class JedisConfig {
    /**
     * 服务器地址
     */
    private String host;
    /**
     * 密码
     */
    private String password;
    /**
     * 过期时间（秒）
     */
    private int expire;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getExpire() {
        return expire;
    }

    public void setExpire(int expire) {
        this.expire = expire;
    }
}
