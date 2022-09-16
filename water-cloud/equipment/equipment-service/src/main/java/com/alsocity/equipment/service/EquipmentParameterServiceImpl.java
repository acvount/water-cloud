package com.alsocity.equipment.service;

import com.alsocity.common.core.exception.BaseException;
import com.alsocity.common.core.exception.config.ExceptionType;
import com.alsocity.equipment.domain.EquipmentParam;
import com.alsocity.equipment.mapper.EquipmentParamMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;


/**
 * @author : 小凡
 * @date : create in 2121/7/22 14:25
 * description :
 **/
@DubboService
@Component
public class EquipmentParameterServiceImpl implements EquipmentParameterService {

    @Resource
    private EquipmentParamMapper equipmentParamMapper;

    @Override
    @Transactional(rollbackFor = {BaseException.class, Exception.class})
    public void insertParam(@RequestBody EquipmentParam equipmentParam) throws BaseException {
        try {
            if (equipmentParam.getEnabled() == 1) {
                setParamDisabledByEid(equipmentParam.getEid());
            }
        } catch (NullPointerException nullPointerException) {
            throw new BaseException(ExceptionType.Parameter_Error.setMessage("enabled 为空或 eid为空"));
        }
        equipmentParamMapper.insert(equipmentParam);
    }

    @Override
    public boolean checkParamUpdateStatus(int eid) {
        Integer count = equipmentParamMapper.selectCount(new QueryWrapper<EquipmentParam>()
                .eq("use_flag", "1")
                .eq("enabled", "1"));
        //查看use_flag 和 enabled 同时为1的 则是没有更新
        return count != 1;
    }

    @Override
    public Object getEnabledParamByEid(int eid) {
        return null;
    }

    private void setParamDisabledByEid(Integer eid) {
        equipmentParamMapper.disabledOtherEidEnabledParam(eid);
    }
}
