package com.alsocity.common.core.utils.io;

import lombok.extern.slf4j.Slf4j;

import java.io.*;

/**
 * @author : 小凡
 * @date : create in 2021/7/28 13:07
 * description :
 **/
@Slf4j
public class FileObjectFormat<T> {

    /**
     * Object 转文件
     *
     * @param o    Object
     * @param path 文件落盘地址
     * @throws Exception 异常
     * @see FileObjectUtil
     */
    public void parseFile(Serializable o, String path) throws Exception {
        FileObjectUtil<T> fileObjectUtil = new FileObjectUtil<>();
        fileObjectUtil.byteToFile(fileObjectUtil.getBytesFromObject(o), path);
    }

    /**
     * 文件转Object
     *
     * @param file 文件
     * @return Obj
     * @throws Exception 异常
     * @see FileObjectUtil
     */
    public T parseObject(File file) throws Exception {
        FileObjectUtil<T> fileObjectUtil = new FileObjectUtil<>();
        return fileObjectUtil.getObjectFromBytes(fileObjectUtil.getBytesFromFile(file));
    }
}
