package com.alsocity.common.redis.json;

import com.alibaba.fastjson.parser.ParserConfig;

/**
 * 配置fastJson AutoType的类
 * @author ZhangYuting
 */
public class InitParserConfig {
    /**
     * 初始化序列化,反序列化类白名单配置
     * @return
     */
    public static ParserConfig init(){
        ParserConfig config = new ParserConfig();
        //自定义oauth2序列化：DefaultOAuth2RefreshToken 没有setValue方法，会导致JSON序列化为null
        ////开启AutoType
        config.setAutoTypeSupport(true);

        return config;
    }
}
