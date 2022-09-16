package com.alsocity.equipment.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author : 小凡
 * @date : create in 2021/7/23 9:35
 * description :
 **/
@ApiModel("设备第一次通电测试传来的VO")
@Data
public class EquipmentElectricTestVO implements Serializable {

    @ApiModelProperty(example = "", notes = "公司ID")
    private Integer cid;
    @ApiModelProperty(example = "", notes = "主机pin码")
    private String chpPin;
    @ApiModelProperty(example = "", notes = "芯片串号")
    private String chpSn;
    @ApiModelProperty(example = "", notes = "prdr")
    private String prdr;
    @ApiModelProperty(example = "", notes = "出场日期")
    private String prdDt;
    @ApiModelProperty(example = "", notes = "主机IP")
    private String chpIp;

    @ApiModelProperty(example = "", notes = "主机批次")
    private String chpBatch;
    @ApiModelProperty(example = "", notes = "固件版本号")
    private String firmwareVersion;
    @ApiModelProperty(example = "", notes = "创建者id")
    private String createId;


}
