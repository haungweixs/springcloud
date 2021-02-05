package com.huangwei.springcloud.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * Created by Hw
 * 21/01/22 10:25
 */
@Data
@TableName("ioilu_Sheet1612246972886")
public class Rkson {

    @TableId(type = IdType.AUTO)
    private String id;

    @TableField(value = "RelevanceForm1612246982739")
    private String product;

    @TableField(value = "Number1612246984596")
    private Integer quantity;

    @TableField(value = "parentId")
    private String parentId;
}
