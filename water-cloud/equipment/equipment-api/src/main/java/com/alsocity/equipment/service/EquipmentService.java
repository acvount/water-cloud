package com.alsocity.equipment.service;

import com.alsocity.common.core.exception.BaseException;
import com.alsocity.equipment.domain.vo.EquipmentElectricTestVO;
import com.alsocity.equipment.domain.vo.EquipmentParamStatusVO;
import com.alsocity.equipment.domain.vo.EquipmentResultVO;

/**
 * @author : 小凡
 * @date : create in 2021/7/22 14:27
 * description : 设备服务类
 **/
public interface EquipmentService {

    /**
     * 主机通电测试
     *
     * @param equipmentElectricTestVO 参数VO
     * @return R
     * @throws BaseException 基础异常
     */
    EquipmentResultVO<EquipmentParamStatusVO> equipmentElectricTest(EquipmentElectricTestVO equipmentElectricTestVO) throws BaseException;

}
