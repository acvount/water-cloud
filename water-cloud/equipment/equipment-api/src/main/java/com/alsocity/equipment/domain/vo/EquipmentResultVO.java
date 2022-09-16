package com.alsocity.equipment.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author : 小凡
 * @date : create in 2021/7/23 9:14
 * description :
 **/

@ApiModel("通用响应设备类")
@Data
public class EquipmentResultVO<T> implements Serializable {

    @ApiModelProperty(example = "", notes = "设备ID")
    private Integer eid;

    @ApiModelProperty(example = "", notes = "参数更新状态 true 为有更新 false 没有")
    private Boolean paramUpdFlag;

    @ApiModelProperty(example = "", notes = "是否有动作 true 为有更新 false 没有")
    private Boolean actionFlag;

    @ApiModelProperty(example = "", notes = "通用响应数据")
    private T data;
}
