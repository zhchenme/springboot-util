package com.jas.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 用户权限表
 * </p>
 *
 * @author zchen
 * @since 2018-08-27
 */
@TableName("t_auth")
public class Auth extends Model<Auth> {

    private static final long serialVersionUID = 1L;

    /**
     * 权限 id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 权限名称
     */
    @TableField("auth_name")
    private String authName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Auth{" +
        ", id=" + id +
        ", authName=" + authName +
        "}";
    }
}
