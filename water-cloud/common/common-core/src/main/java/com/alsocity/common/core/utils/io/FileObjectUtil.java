package com.alsocity.common.core.utils.io;

import lombok.extern.slf4j.Slf4j;

import java.io.*;

/**
 * @author : 小凡
 * @date : create in 2021/7/28 13:38
 * description :
 **/
@Slf4j
public class FileObjectUtil<T> {
    public byte[] getBytesFromFile(File f) {
        if (f == null) {
            return null;
        }
        try {
            FileInputStream stream = new FileInputStream(f);
            ByteArrayOutputStream out = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            int n;
            while ((n = stream.read(b)) != -1) {
                out.write(b, 0, n);
            }
            stream.close();
            out.close();
            return out.toByteArray();
        } catch (IOException e) {
            log.error("获取文件字节数组失败", e);
        }
        return null;
    }

    /**
     * byte[] 转 file
     *
     * @param bytes byte
     * @param path  path
     * @see [类、类#方法、类#成员]
     */
    public void byteToFile(byte[] bytes, String path) {
        try {
            // 根据绝对路径初始化文件
            File localFile = new File(path);
            if (!localFile.exists()) {
                localFile.createNewFile();
            }
            // 输出流
            OutputStream os = new FileOutputStream(localFile);
            os.write(bytes);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 从字节数组获取对象
     *
     * @param objBytes 文件字节
     * @return Obj
     * @throws Exception exc
     */
    public T getObjectFromBytes(byte[] objBytes) throws Exception {
        if (objBytes == null || objBytes.length == 0) {
            return null;
        }
        ByteArrayInputStream bi = new ByteArrayInputStream(objBytes);
        ObjectInputStream oi = new ObjectInputStream(bi);
        return (T) oi.readObject();
    }


    /**
     * 从对象获取一个字节数组
     *
     * @param obj obj
     * @return byte
     * @throws Exception exc
     */
    public byte[] getBytesFromObject(Serializable obj) throws Exception {
        if (obj == null) {
            return null;
        }
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream o = new ObjectOutputStream(bo);
        o.writeObject(obj);
        return bo.toByteArray();
    }
}
