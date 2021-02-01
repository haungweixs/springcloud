package com.huangwei.springcloud.service;

import com.huangwei.springcloud.entities.Iteminfo;

/**
 * Created by Hw
 * 21/02/01 15:07
 */
public interface OrderService {
     Iteminfo queryIteminfo(String id);
}
