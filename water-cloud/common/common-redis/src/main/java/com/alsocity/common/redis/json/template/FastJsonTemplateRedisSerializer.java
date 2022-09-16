package com.alsocity.common.redis.json.template;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.IOUtils;
import com.alsocity.common.redis.json.InitParserConfig;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

/**
 * redis
 *
 * @author ZhangYuting
 */
public class FastJsonTemplateRedisSerializer<T> implements RedisSerializer<T> {

    private static ParserConfig config;

    static {
        config = InitParserConfig.init();
    }

    private Class<T> clazz;

    public FastJsonTemplateRedisSerializer(Class<T> clazz) {
        super();
        this.clazz = clazz;
    }

    /**
     * 序列化对象转json转byte
     *
     * @param t
     * @return
     * @throws SerializationException
     */
    @Override
    public byte[] serialize(T t) throws SerializationException {
        if (t == null) {
            return new byte[0];
        }
        return JSON.toJSONBytes(t, SerializerFeature.WriteClassName, SerializerFeature.DisableCircularReferenceDetect);
    }

    /**
     * @param bytes
     * @return
     * @throws SerializationException
     */
    @Override
    public T deserialize(byte[] bytes) throws SerializationException {
        if (null == bytes || bytes.length <= 0) {
            return null;
        }
        String str = new String(bytes, IOUtils.UTF8);
        return JSON.parseObject(str, clazz, config);
    }
}
