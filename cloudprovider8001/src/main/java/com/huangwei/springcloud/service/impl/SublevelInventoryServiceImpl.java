package com.huangwei.springcloud.service.impl;

import cn.hutool.json.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huangwei.springcloud.dao.SublevelInventoryDao;
import com.huangwei.springcloud.entities.Ckson;
import com.huangwei.springcloud.entities.SublevelInventory;
import com.huangwei.springcloud.service.SublevelInventoryService;
import com.huangwei.springcloud.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by Hw
 * 21/04/07 11:11
 */
@Service
public class SublevelInventoryServiceImpl extends ServiceImpl<SublevelInventoryDao,SublevelInventory> implements SublevelInventoryService{

    @Autowired
    SublevelInventoryService inventoryService;

    @Override
    public void updateInventory(Ckson ckson,String warehouse) {
        QueryWrapper<SublevelInventory>  inventoryQueryWrapper=new QueryWrapper<>();
        inventoryQueryWrapper.eq("warehouse",warehouse);
        inventoryQueryWrapper.eq("product",ckson.getProduct());
        SublevelInventory inventory=inventoryService.getOne(inventoryQueryWrapper);
        SublevelInventory sublevelInventory=new SublevelInventory();
        if (inventory!=null){
            sublevelInventory.setId(inventory.getId());
            sublevelInventory.setQuantity(inventory.getQuantity().add(BigDecimal.valueOf(ckson.getQuantity())));
            inventoryService.updateById(sublevelInventory);
        }else {
            sublevelInventory.setId(MD5.barCode());
            sublevelInventory.setQuantity(BigDecimal.valueOf(ckson.getQuantity()));
            sublevelInventory.setProduct(ckson.getProduct());
            sublevelInventory.setWarehouse(warehouse);
            inventoryService.save(sublevelInventory);
        }
    }
}
