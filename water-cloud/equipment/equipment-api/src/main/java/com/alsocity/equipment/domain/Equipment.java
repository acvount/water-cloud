package com.alsocity.equipment.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author : 小凡
 * @date : create in 2021/7/22 14:26
 * description :
 **/
@Data
@ApiModel("设备参数")
public class Equipment implements Serializable {

    @ApiModelProperty(example = "0", notes = "id")
    private Integer id;

    @ApiModelProperty(example = "0", notes = "cid")
    private Integer cid;

    @ApiModelProperty(example = "0", notes = "pin")
    private String pin;

    @ApiModelProperty(example = "0", notes = "sn")
    private String sn;

    @ApiModelProperty(example = "0", notes = "vendor")
    private String vendor;

    @ApiModelProperty(example = "0", notes = "ip")
    private String ip;

    @ApiModelProperty(example = "0", notes = "name")
    private String name;

    @ApiModelProperty(example = "0", notes = "remark")
    private String remark;

    @ApiModelProperty(example = "2020-11-11 11:11:11", notes = "createTime")
    private LocalDateTime createTime;
}
