package com.alsocity.equipment.controller;

import com.alsocity.common.core.exception.BaseException;
import com.alsocity.common.core.response.Response;
import com.alsocity.equipment.config.mqtt.MQTTClient;
import com.alsocity.equipment.domain.vo.EquipmentElectricTestVO;
import com.alsocity.equipment.domain.vo.EquipmentParamStatusVO;
import com.alsocity.equipment.domain.vo.EquipmentResultVO;
import com.alsocity.equipment.service.EquipmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author : 小凡
 * @date : create in 2021/7/26 18:00
 * description :
 **/

@RestController
@RequestMapping("equipment")
@Api(value = "equipment", tags = "设备 API")
public class EquipmentController {

    @Resource
    MQTTClient mqttClient;

    @Resource
    private EquipmentService equipmentService;

    @GetMapping("electric")
    @ApiOperation(value = "设备通电测试 {设备端,拦截白名单}")
    public Response<EquipmentResultVO<EquipmentParamStatusVO>> equipmentElectricTest(EquipmentElectricTestVO equipmentElectricTestVO) throws BaseException {
        EquipmentResultVO<EquipmentParamStatusVO> equipmentParamStatusVOEquipmentResultVO = equipmentService.equipmentElectricTest(equipmentElectricTestVO);
        return new Response<>(equipmentParamStatusVOEquipmentResultVO);
    }
}
