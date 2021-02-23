package com.huangwei.springcloud.entities;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Hw
 * 21/01/22 10:25
 */
@Data
public class Rkson implements Serializable {

    private String id;


    private String product;


    private Integer quantity;

    private String parentId;
}
