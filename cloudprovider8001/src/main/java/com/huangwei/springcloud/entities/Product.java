package com.huangwei.springcloud.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by Hw
 * 21/02/02 15:06
 */
@Data
@TableName("iv9pp_product")
public class Product implements Serializable {
    @TableId(type = IdType.AUTO)
    private String id;

    @TableField(value = "Number1612246638107")
    private Integer quantity;
}
