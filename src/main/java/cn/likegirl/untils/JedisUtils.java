package cn.likegirl.untils;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;

public class JedisUtils {
    /**
     * 过期时间（秒）
     */
    private static int expire = 600;

    private static RedisTemplate<String, Object> redisTemplate;

    /**
     * 设置
     *
     * @param key   键
     * @param value 值
     */
    public static void set(String key, String value) {
        setObject(key, value);
    }

    /**
     * 设置
     *
     * @param key    键
     * @param value  值
     * @param expire 过期时间（秒）
     */
    public static void set(String key, String value, int expire) {
        setObject(key, value, expire);
    }

    /**
     * 设置 对象
     *
     * @param key   键
     * @param value 值
     */
    public static void setObject(String key, Object value) {
        ValueOperations<String, Object> v = redisTemplate.opsForValue();
        v.set(key, value);
        redisTemplate.expire(key, expire, TimeUnit.SECONDS);
    }

    /**
     * 设置
     *
     * @param key    键
     * @param value  值
     * @param expire 过期时间（秒）
     */
    public static void setObject(String key, Object value, int expire) {
        ValueOperations<String, Object> v = redisTemplate.opsForValue();
        v.set(key, value);
        redisTemplate.expire(key, expire, TimeUnit.SECONDS);
    }

    /**
     * 获取
     *
     * @param key 键
     * @return 值
     */
    public static String get(String key) {
        Object obj = getObject(key);
        return obj == null ? null : obj.toString();
    }


    /**
     * 获取 对象
     *
     * @param key 键
     * @return 值
     */
    public static Object getObject(String key) {
        if (!exists(key)) {
            return null;
        }
        ValueOperations<String, Object> v = redisTemplate.opsForValue();
        return v.get(key);
    }

    /**
     * 是否存在
     *
     * @param key 键
     * @return 是否存在
     */
    public static boolean exists(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 删除
     *
     * @param key 键
     */
    public static void delete(String key) {
        redisTemplate.delete(key);
    }

    /**
     * 清空
     */
    public static void flushAll() {
        //
    }

    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        setRedisTemplateStatic(redisTemplate);
    }

    public static void setRedisTemplateStatic(RedisTemplate<String, Object> redisTemplate) {
        JedisUtils.redisTemplate = redisTemplate;
    }

    public void setJedisConfig(JedisConfig jedisConfig) {
        setJedisConfigStatic(jedisConfig);
    }

    private static void setJedisConfigStatic(JedisConfig jedisConfig) {
        expire = jedisConfig.getExpire();
    }

}
