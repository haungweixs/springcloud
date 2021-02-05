package com.huangwei.springcloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huangwei.springcloud.dao.ProductDao;
import com.huangwei.springcloud.entities.Product;
import com.huangwei.springcloud.service.ProductService;
import org.springframework.stereotype.Service;

/**
 * Created by Hw
 * 21/02/02 15:10
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductDao,Product> implements ProductService {
}
