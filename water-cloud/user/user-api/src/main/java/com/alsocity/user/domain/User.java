package com.alsocity.user.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Account
 */
@ApiModel(value = "用户类", description = "系统用户")
@Data
@ToString
public class User implements Serializable {

    /**
     * 用户ID
     */
    @ApiModelProperty(notes = "用户ID", example = "1")
    private Long id;


    /**
     * 公司ID
     */
    @ApiModelProperty(notes = "公司ID", example = "1")
    private Long cid;


    /**
     * 用户名称
     */
    @ApiModelProperty(notes = "用户名称", example = "张三")
    private String userName;

    /**
     * 用户昵称
     */
    @ApiModelProperty(notes = "用户昵称", example = "爷傲丶奈我何灬")
    private String userNick;

    /**
     * 用户手机号
     */
    @ApiModelProperty(notes = "用户手机号", example = "爷傲丶奈我何灬")
    private String phone;


    /**
     * 用户密码
     */
    @ApiModelProperty(notes = "用户密码")
    private String password;


    /**
     * 用户状态  0 停用 1正常
     */
    @ApiModelProperty(notes = "用户状态  0 停用 1正常", example = "1")
    private Integer status;


    /**
     * 用户住址
     */
    @ApiModelProperty(notes = "用户住址", example = "北京,北京,海淀")
    private String address;


    /**
     * 创建时间
     */
    @ApiModelProperty(notes = "创建时间")
    private LocalDateTime createTime;


    /**
     * 创建时间
     */
    @ApiModelProperty(notes = "修改时间")
    private LocalDateTime updateTime;


}
