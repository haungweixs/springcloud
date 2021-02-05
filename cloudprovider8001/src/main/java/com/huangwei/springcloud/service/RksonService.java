package com.huangwei.springcloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huangwei.springcloud.entities.Req;
import com.huangwei.springcloud.entities.Rkson;

import java.util.List;

/**
 * Created by Hw
 * 21/01/22 10:39
 */
public interface RksonService extends IService<Rkson> {
    List<Rkson> updateProduct(Req req);

    List<Rkson> findRksonList();

}
