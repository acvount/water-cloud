package com.alsocity.equipment.service;

import com.alsocity.common.core.exception.BaseException;
import com.alsocity.common.core.exception.config.ExceptionType;
import com.alsocity.equipment.domain.Equipment;
import com.alsocity.equipment.domain.vo.EquipmentElectricTestVO;
import com.alsocity.equipment.domain.vo.EquipmentParamStatusVO;
import com.alsocity.equipment.domain.vo.EquipmentResultVO;
import com.alsocity.equipment.mapper.EquipmentMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author : 小凡
 * @date : create in 2021/7/26 18:02
 * description :
 **/
@DubboService
@Component
@Slf4j
public class EquipmentServiceImpl implements EquipmentService {

    @Resource
    private EquipmentMapper equipmentMapper;
    @Resource
    private EquipmentParameterService equipmentParameterService;


    @Override
    @Transactional(rollbackFor = {Exception.class, BaseException.class})
    public EquipmentResultVO<EquipmentParamStatusVO> equipmentElectricTest(EquipmentElectricTestVO equipmentElectricTestVO) throws BaseException {
        long startTime = System.currentTimeMillis();
        if (equipmentElectricTestVO.getCid() == null) {
            ExceptionType exceptionType = ExceptionType.Parameter_Error.setMessage("公司ID不能为空");
            exceptionType.setCode(999);
            throw new BaseException(exceptionType);
        }

        // 检查参数
        EquipmentParamStatusVO equipmentParamStatusVO = checkParam(equipmentElectricTestVO);

        EquipmentResultVO<EquipmentParamStatusVO> equipmentResultVO = new EquipmentResultVO<>();
        equipmentResultVO.setData(equipmentParamStatusVO);

        //查询在库中是否有这个SN的设备 如果有则不新增
        Equipment equipment = equipmentMapper.selectOne(new QueryWrapper<Equipment>().eq("sn", equipmentElectricTestVO.getChpSn()));

        if (equipment == null) {
            //DB中没有这个设备. 开始新增!
            electricNotEquipment(equipmentResultVO, equipmentElectricTestVO);
        } else {
            //DB中有 检查是否有参数更新
            equipmentResultVO.setParamUpdFlag(equipmentParameterService.checkParamUpdateStatus(equipment.getId()));
            //是否有动作. 如拍照等.
            equipmentResultVO.setActionFlag(false);
            equipmentResultVO.setEid(equipment.getId());
        }
        log.info("EID-{} : 处理一次通电测试完成, 共耗时 {} ms", equipmentResultVO.getEid(), System.currentTimeMillis() - startTime);
        return equipmentResultVO;
    }

    /**
     * 新增设备
     *
     * @param equipment 设备
     */
    public Integer insertEquipment(Equipment equipment) {
        return equipmentMapper.insert(equipment);
    }

    /**
     * 通电测试检查参数并返回给主机
     *
     * @param equipmentElectricTestVO 通电测试VO
     * @return vo
     */
    private EquipmentParamStatusVO checkParam(EquipmentElectricTestVO equipmentElectricTestVO) {
        EquipmentParamStatusVO equipmentParamStatusVO = new EquipmentParamStatusVO();
        equipmentParamStatusVO.setChpPin(StringUtils.isBlank(equipmentElectricTestVO.getChpPin()) ? 1 : 0);
        equipmentParamStatusVO.setChpSn(StringUtils.isBlank(equipmentElectricTestVO.getChpSn()) ? 1 : 0);
        equipmentParamStatusVO.setChpIp(StringUtils.isBlank(equipmentElectricTestVO.getChpIp()) ? 1 : 0);
        equipmentParamStatusVO.setPrdDt(StringUtils.isBlank(equipmentElectricTestVO.getPrdDt()) ? 1 : 0);
        equipmentParamStatusVO.setPrdr(StringUtils.isBlank(equipmentElectricTestVO.getPrdr()) ? 1 : 0);
        return equipmentParamStatusVO;
    }

    /**
     * 通电测试中 没有设备情况下
     *
     * @param equipmentResultVO       返回结果类
     * @param equipmentElectricTestVO 接收的参数
     */
    private void electricNotEquipment(EquipmentResultVO<EquipmentParamStatusVO> equipmentResultVO, EquipmentElectricTestVO equipmentElectricTestVO) {
        //是否有动作.
        equipmentResultVO.setActionFlag(false);
        //是否有更改主机使用参数.
        equipmentResultVO.setParamUpdFlag(false);

        //新增设备
        Equipment equipment = new Equipment();
        equipment.setCid(equipmentElectricTestVO.getCid());
        equipment.setPin(equipmentElectricTestVO.getChpPin());
        equipment.setSn(equipmentElectricTestVO.getChpSn());
        equipment.setVendor(equipmentElectricTestVO.getPrdr());
        equipment.setIp(equipmentElectricTestVO.getChpIp());
        insertEquipment(equipment);
        equipmentResultVO.setEid(equipment.getId());
    }


}
