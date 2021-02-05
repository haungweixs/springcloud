package com.huangwei.springcloud.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * Created by Hw
 * 21/02/04 9:58
 */
@Data
@TableName("ioilu_Sheet1612347196406")
public class Ckson {
    @TableId(type = IdType.AUTO)
    private String id;

    @TableField(value = "RelevanceForm1612347209187")
    private String product;

    @TableField(value = "Number1612347244654")
    private Integer quantity;

    @TableField(value = "parentId")
    private String parentId;
}
