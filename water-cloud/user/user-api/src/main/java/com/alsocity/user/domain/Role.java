package com.alsocity.user.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;


/**
 * @author Account
 */
@Getter
@Setter
@ApiModel(value = "角色管理类", description = "角色管理")
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    @ApiModelProperty(example = "1", notes = "角色ID")
    private Long id;

    @ApiModelProperty(notes = "角色原名称", example = "管理员")
    private String originalName;
    /**
     * 角色名称
     */
    @ApiModelProperty(example = "超级管理员", notes = "角色名称")
    private String name;
    /**
     *
     */
    @ApiModelProperty(example = "0", notes = "公司id")
    private Long companyId;
    /**
     * 排序
     */
    @ApiModelProperty(example = "99", notes = "排序")
    private Integer sortId;
    /**
     * 状态 0=正常1=异常2=停用
     */
    @ApiModelProperty(example = "1", notes = "状态(0=正常1=异常2=停用)")
    private Integer status;
    /**
     * 备注
     */
    @ApiModelProperty(example = "", notes = "备注")
    private String remark;
    /**
     * 创建人
     */
    @ApiModelProperty(example = "1", notes = "创建人")
    private Long createBy;
    /**
     * 创建时间
     */
    @ApiModelProperty(example = "2020-10-02 12:00:00", notes = "创建时间")
    private LocalDateTime createTime;
    /**
     * 修改人
     */
    @ApiModelProperty(example = "1", notes = "修改人")
    private Long updateBy;
    /**
     * 修改时间
     */
    @ApiModelProperty(example = "2020-10-02 12:00:00", notes = "修改时间")
    private LocalDateTime updateTime;
    /**
     * 删除标识 0未删除 1已删除
     */
    @ApiModelProperty(example = "0", notes = "删除标识 0未删除 1已删除")
    private String delFlag;

    @ApiModelProperty(notes = "角色菜单权限列表", example = "[]")
    private List<Menu> menuList;

}
