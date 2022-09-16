package com.alsocity.equipment.mapper;

import com.alsocity.equipment.domain.EquipmentParam;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @author : 小凡
 * @date : create in 2021/7/26 17:35
 * description :
 **/
@Mapper
public interface EquipmentParamMapper extends BaseMapper<EquipmentParam> {

    /**
     * 根据设备ID 修改其他的启用状态为不启用
     *
     * @param eid 设备ID
     */
    @Update("update equipment_param set enabled = 0 where eid = #{eid}")
    void disabledOtherEidEnabledParam(@Param("eid") Integer eid);
}
