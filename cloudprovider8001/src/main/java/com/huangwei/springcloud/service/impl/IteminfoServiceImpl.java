package com.huangwei.springcloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huangwei.springcloud.dao.IteminfoDao;
import com.huangwei.springcloud.entities.Iteminfo;
import com.huangwei.springcloud.service.IteminfoService;
import org.springframework.stereotype.Service;

/**
 * Created by Hw
 * 21/01/22 10:39
 */
@Service
public class IteminfoServiceImpl extends ServiceImpl<IteminfoDao,Iteminfo> implements IteminfoService {

}
