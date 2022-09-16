package com.alsocity.gateway.domain;

/**
 * @author : 小凡
 * @date : create in 2021/7/27 18:57
 * description :
 **/
public class Whitelist {

    private String path;
    private String desc;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Whitelist{" +
                "path='" + path + '\'' +
                ", describe='" + desc + '\'' +
                '}';
    }
}
