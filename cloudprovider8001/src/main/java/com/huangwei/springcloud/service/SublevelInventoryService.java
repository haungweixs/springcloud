package com.huangwei.springcloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huangwei.springcloud.entities.Ckson;
import com.huangwei.springcloud.entities.SublevelInventory;

/**
 * Created by Hw1
 * 21/04/07 11:09
 */
public interface SublevelInventoryService extends IService<SublevelInventory> {
    void  updateInventory(Ckson ckson,String warehouse);
}
