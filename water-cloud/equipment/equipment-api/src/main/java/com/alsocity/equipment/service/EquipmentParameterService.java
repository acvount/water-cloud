package com.alsocity.equipment.service;

import com.alsocity.common.core.exception.BaseException;
import com.alsocity.equipment.domain.EquipmentParam;

/**
 * @author : 小凡
 * @date : create in 2021/7/22 14:27
 * description : 设备参数服务类
 **/
public interface EquipmentParameterService {

    /***
     * 插入一条设备参数信息
     * @param equipmentParam 设备参数Obj
     * @throws BaseException 基础异常类型
     */
    void insertParam(EquipmentParam equipmentParam) throws BaseException;


    /**
     * 根据EID 检查参数更新状态
     *
     * @param eid eid
     * @return true or flase
     * @throws BaseException 基础异常类型如 eid 不可为空
     */
    boolean checkParamUpdateStatus(int eid) throws BaseException;

    /**
     * 根据EID 获取启用的参数
     * @param eid Eid
     * @return OSS Object
     */
    Object getEnabledParamByEid(int eid);
}
