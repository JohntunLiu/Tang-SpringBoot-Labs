package com.tang.dao.redis;


import com.tang.bo.UserCacheObject;

import com.tang.util.JSONUtil;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class UserCacheDao {

    private static final String KEY_PATTERN = "user:%d"; // user:用户编号 <1>

    @Resource(name = "redisTemplate")
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private ValueOperations<String, String> operations; // <2>

    private static String buildKey(Integer id) { // <3>
        return String.format(KEY_PATTERN, id);
    }

    public UserCacheObject get(Integer id) {
        String key = buildKey(id);
        String value = operations.get(key);
        return JSONUtil.parseObject(value, UserCacheObject.class);
    }

    public void set(Integer id, UserCacheObject object) {
        String key = buildKey(id);
        String value = JSONUtil.toJSONString(object);
        operations.set(key, value);
    }

}
