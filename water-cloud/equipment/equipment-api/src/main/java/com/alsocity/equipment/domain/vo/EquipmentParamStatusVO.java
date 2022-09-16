package com.alsocity.equipment.domain.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;

/**
 * @author : 小凡
 * @date : create in 2021/7/23 10:18
 * description :参数状态
 **/


@Getter
@Setter
@ToString
@ApiModel("设备值通用响应设备类")
public class EquipmentParamStatusVO implements Serializable {
    @ApiModelProperty(example = "", notes = "chpPin")
    private Integer chpPin;
    @ApiModelProperty(example = "", notes = "芯片串号")
    private Integer chpSn;
    @ApiModelProperty(example = "", notes = "prdr")
    private Integer prdr;
    @ApiModelProperty(example = "", notes = "出场日期")
    private Integer prdDt;
    @ApiModelProperty(example = "", notes = "主机IP")
    private Integer chpIp;
}
