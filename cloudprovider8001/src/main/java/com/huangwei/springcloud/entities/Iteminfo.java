package com.huangwei.springcloud.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.print.attribute.standard.MediaSize;

/**
 * Created by Hw
 * 21/01/22 10:25
 */
@Data
@TableName("item_info")
public class Iteminfo {

    @TableId(type = IdType.AUTO)
    private String id;

    private String memo;
}
