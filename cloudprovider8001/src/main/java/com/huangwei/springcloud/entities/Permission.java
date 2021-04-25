package com.huangwei.springcloud.entities;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * Created by Hw
 * 21/03/08 15:42
 */
@Data
@TableName("t_permission")
public class Permission {
    @TableId
    private Integer id;

    private String permissionname;

    private Integer roleId;
}
