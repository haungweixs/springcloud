package com.huangwei.springcloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huangwei.springcloud.entities.Ckson;
import com.huangwei.springcloud.entities.Req;

import java.util.List;

/**
 * Created by Hw
 * 21/02/04 10:01
 */
public interface CksonService extends IService<Ckson> {
    public List<Ckson> updateProduct(Req req);
}
