package com.huangwei.springcloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huangwei.springcloud.dao.RksonDao;
import com.huangwei.springcloud.entities.Product;
import com.huangwei.springcloud.entities.Req;
import com.huangwei.springcloud.entities.Rkson;
import com.huangwei.springcloud.service.ProductService;
import com.huangwei.springcloud.service.RksonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Hw
 * 21/01/22 10:39
 */
@Service
public class RksonServiceImpl extends ServiceImpl<RksonDao,Rkson> implements RksonService {

    @Autowired
    RksonService rksonService;
    @Autowired
    ProductService productService;

    @Override
    public List<Rkson> updateProduct(Req req) {
        Rkson rkson=new Rkson();
        QueryWrapper<Rkson> rksonWrapper=new QueryWrapper<>();
        rksonWrapper.eq("parentId", req.getId());
        List<Rkson> rksonList= rksonService.list(rksonWrapper);
        for (Rkson rk:rksonList){
            Product product=productService.getById(rk.getProduct());
            if (product.getQuantity()!=null){
                product.setQuantity(product.getQuantity()+rk.getQuantity());
            }else {
                product.setQuantity(rk.getQuantity());
            }
            productService.updateById(product);
        }
        return rksonList;
    }

    @Override
    public List<Rkson> findRksonList() {
        return rksonService.list();
    }

}
