package com.huangwei.springcloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huangwei.springcloud.dao.PermissionDao;
import com.huangwei.springcloud.entities.Permission;
import com.huangwei.springcloud.service.PermissionService;
import org.springframework.stereotype.Service;

/**
 * Created by Hw
 * 21/03/08 15:45
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionDao,Permission> implements PermissionService {
}
