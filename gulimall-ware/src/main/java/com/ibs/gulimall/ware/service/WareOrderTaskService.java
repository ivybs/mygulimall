package com.ibs.gulimall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ibs.common.utils.PageUtils;
import com.ibs.gulimall.ware.entity.WareOrderTaskEntity;

import java.util.Map;

/**
 * 库存工作单
 *
 * @author ibs
 * @email ivybsugarman@qq.com
 * @date 2022-05-15 19:11:35
 */
public interface WareOrderTaskService extends IService<WareOrderTaskEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

