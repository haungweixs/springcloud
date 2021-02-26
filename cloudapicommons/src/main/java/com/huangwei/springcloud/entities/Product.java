package com.huangwei.springcloud.entities;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Hw
 * 21/02/24 13:50
 */
@Data
public class Product implements Serializable {
    private String id;

    private Integer quantity;
}
