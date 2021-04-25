package com.huangwei.springcloud.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.math.BigDecimal;

/**
 * Created by Hw
 * 21/04/07 11:03
 */
@Data
@TableName("ioilu_sublevel_inventory")
public class SublevelInventory {

    @TableId(type = IdType.INPUT)
    private String id;
    private String warehouse;
    private String product;
    private BigDecimal quantity;
}
