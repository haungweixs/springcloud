package com.huangwei.springcloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huangwei.springcloud.dao.CksonDao;
import com.huangwei.springcloud.entities.Ckson;
import com.huangwei.springcloud.entities.Product;
import com.huangwei.springcloud.entities.Req;
import com.huangwei.springcloud.service.CksonService;
import com.huangwei.springcloud.service.ProductService;
import com.huangwei.springcloud.service.SublevelInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Hw
 * 21/02/04 10:02
 */
@Service
public class CksonServiceImpl extends ServiceImpl<CksonDao,Ckson> implements CksonService {

    @Resource
    CksonService cksonService;
    @Resource
    ProductService productService;
    @Resource
    SublevelInventoryService inventoryService;

    @Override
    @Transactional
    public List<Ckson> updateProduct(Req req) {
        Ckson ckson=new Ckson();
        QueryWrapper<Ckson> rksonWrapper=new QueryWrapper<>();
        rksonWrapper.eq("parentId", req.getId());
        List<Ckson> cksonList= cksonService.list(rksonWrapper);
        for (Ckson ck:cksonList){
            Product product=productService.getById(ck.getProduct());
            if (product.getQuantity()!=null){
                product.setQuantity(product.getQuantity()-ck.getQuantity());
            }else {
                product.setQuantity(0-ck.getQuantity());
            }
            productService.updateById(product);
            inventoryService.updateInventory(ck,req.getWarehouse());
        }
        return cksonList;
    }
}
