package com.alsocity.equipment.controller;

import com.alsocity.common.core.exception.BaseException;
import com.alsocity.common.core.exception.config.ExceptionType;
import com.alsocity.common.core.response.Response;
import com.alsocity.equipment.domain.EquipmentParam;
import com.alsocity.equipment.service.EquipmentParameterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author : 小凡
 * @date : create in 2021/7/21 13:10
 * description :
 **/

@RestController
@RequestMapping("param")
@Api(value = "equipment_param", tags = "设备参数相关API")
public class EquipmentParameterController {

    @Resource
    private EquipmentParameterService equipmentParameterService;

    @PostMapping("addParam")
    @ApiOperation(value = "新增设备参数")
    public Response<String> equipmentElectricTest(EquipmentParam equipmentParam) throws BaseException {
        equipmentParameterService.insertParam(equipmentParam);
        return new Response<>("ok");
    }

    @GetMapping("getEnabledParamByEid")
    @ApiOperation(value = "获取启用的参数对象 {设备端,拦截白名单}")
    public Response<Object> getEnabledParamByEid(@RequestParam("id") Integer id) throws BaseException {
        if (id == null) {
            throw new BaseException(ExceptionType.Parameter_Error.setMessage("id不可为空"));
        }
        return new Response<>(equipmentParameterService.getEnabledParamByEid(id));
    }

}
