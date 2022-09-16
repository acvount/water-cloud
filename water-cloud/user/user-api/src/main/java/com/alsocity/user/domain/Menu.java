package com.alsocity.user.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 菜单管理
 *
 * @author zyt
 * @date 2020-12-31 21:17:29
 */
@TableName(value = "sys_menu")
@Getter
@Setter
@ApiModel(value = "菜单管理类", description = "菜单管理")
public class Menu implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @ApiModelProperty(example = "0", notes = "")
    private Integer id;
    /**
     * 父ID
     */
    @ApiModelProperty(example = "0", notes = "父ID")
    private Integer pid;
    /**
     * id集合逗号间隔
     */
    @ApiModelProperty(example = "", notes = "id集合逗号间隔")
    private String idPath;
    /**
     * 菜单名称
     */
    @ApiModelProperty(example = "", notes = "菜单名称")
    private String title;
    /**
     * 权限标识
     */
    @ApiModelProperty(example = "", notes = "权限标识")
    private String permission;
    /**
     * 请求路由
     */
    @ApiModelProperty(example = "", notes = "请求路由")
    private String url;
    /**
     * 类型 0菜单 1按钮 2目录
     */
    @ApiModelProperty(example = "0", notes = "类型 0菜单 1按钮 2目录")
    private Integer menuType;

    @ApiModelProperty(example = "99", notes = "排序")
    private Integer sortId;
    /**
     * 类型 0业务模块  1系统 2开发
     */
    @ApiModelProperty(example = "0", notes = "类型 0业务模块  1系统 2开发")
    private Integer type;
    /**
     * 图标
     */
    @ApiModelProperty(example = "", notes = "图标")
    private String icon;
    /**
     * 权重
     */
    @ApiModelProperty(example = "0", notes = "权重")
    private Integer weigh;
    /**
     * 菜单状态 0->启用  1->禁用
     */
    @ApiModelProperty(example = "0", notes = "菜单状态 0->启用  1->禁用")
    private Integer status;
    /**
     * 显示状态 0-> 隐藏 1-> 显示
     */
    @ApiModelProperty(example = "false", notes = "显示状态 0-> 隐藏 1-> 显示")
    private Boolean hidden;
    /**
     * vue router name
     */
    @ApiModelProperty(example = "", notes = "vue router name")
    private String name;
    /**
     * 路由地址
     */
    @ApiModelProperty(example = "", notes = "路由地址")
    private String path;
    /**
     * 组件路径
     */
    @ApiModelProperty(example = "", notes = "组件路径")
    private String component;
    /**
     * 是否外链 1是 0否
     */
    @ApiModelProperty(example = "false", notes = "是否外链 1是 0否")
    private Boolean isFrame;
    /**
     * 外链地址
     */
    @ApiModelProperty(example = "", notes = "外链地址")
    private String frameUrl;
    /**
     * 重定向
     */
    @ApiModelProperty(example = "", notes = "重定向")
    private String redirect;
    /**
     * 备注
     */
    @ApiModelProperty(example = "", notes = "备注")
    private String remark;
    /**
     * 创建时间
     */
    @ApiModelProperty(example = "2020-10-10 12:00:00", notes = "创建时间")
    private LocalDateTime createTime;
    /**
     * 修改时间
     */
    @ApiModelProperty(example = "2020-10-10 12:00:00", notes = "修改时间")
    private LocalDateTime updateTime;

}
