package com.alsocity.equipment.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Account
 */
@Data
@ApiModel("设备参数")
public class EquipmentParam implements Serializable {

    @ApiModelProperty(example = "0", notes = "id")
    private Integer id;
    @ApiModelProperty(example = "0", notes = "公司ID")
    private Integer cid;
    @ApiModelProperty(example = "0", notes = "设备ID")
    private Integer eid;
    @ApiModelProperty(example = "0", notes = "参数名称")
    private String paramName;
    @ApiModelProperty(example = "0", notes = "参数备注")
    private String remark;
    @ApiModelProperty(example = "0", notes = "OSS 中 对象ID")
    private String ossId;
    @ApiModelProperty(example = "0", notes = "是否启用")
    private Integer enabled;
    @ApiModelProperty(example = "0", notes = "当前使用")
    private Integer useFlag;
    @ApiModelProperty(example = "2021-7-27 11:35:00", notes = "创建时间")
    private LocalDateTime createTime;

}
