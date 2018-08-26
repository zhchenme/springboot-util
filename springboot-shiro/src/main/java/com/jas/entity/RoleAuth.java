package com.jas.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 角色-权限关联表
 * </p>
 *
 * @author zchen
 * @since 2018-08-26
 */
@TableName("t_role_auth")
public class RoleAuth extends Model<RoleAuth> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键 id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 角色 id
     */
    @TableField("role_id")
    private Integer roleId;
    /**
     * 权限 id
     */
    @TableField("auth_id")
    private Integer authId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getAuthId() {
        return authId;
    }

    public void setAuthId(Integer authId) {
        this.authId = authId;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "RoleAuth{" +
        ", id=" + id +
        ", roleId=" + roleId +
        ", authId=" + authId +
        "}";
    }
}
