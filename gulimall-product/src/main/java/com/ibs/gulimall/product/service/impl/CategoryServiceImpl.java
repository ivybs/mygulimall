package com.ibs.gulimall.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ibs.common.utils.PageUtils;
import com.ibs.common.utils.Query;

import com.ibs.gulimall.product.dao.CategoryDao;
import com.ibs.gulimall.product.entity.CategoryEntity;
import com.ibs.gulimall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        // 1.查出所有分类
        List<CategoryEntity> entities = baseMapper.selectList(null);

        // 2.组装成父子的树形结构
        // 2.1 找到所有一级分类
        List<CategoryEntity> level1Menus = entities.stream().filter(categoryEntity -> categoryEntity.getParentCid() == 0)
                .map((menu) -> {
                    menu.setChildren(getChildren(menu,entities));
                    return menu;
                }).sorted((menu1,menu2) -> {
                    return (menu1.getSort() == null? 0:menu1.getSort())-(menu2.getSort() == null?0:menu2.getSort());
                }).collect(Collectors.toList());
        return null;
    }

    // 递归查找某个父级的所有子级，包括子级的子级（递归查询嘛）
    private List<CategoryEntity> getChildren(CategoryEntity root,List<CategoryEntity> all){
        List<CategoryEntity> children = all.stream().filter(categoryEntity -> categoryEntity.getParentCid() == root.getCatId())
        .map(categoryEntity -> {
            // 1.找到子菜单
            categoryEntity.setChildren(getChildren(categoryEntity, all));
            return categoryEntity;
        }).sorted((menu1,menu2) -> {
            // 2.菜单的排序  有的菜单的排序字段为空，所以这里要判空并进行默认值设置处理
            return (menu1.getSort() == null? 0:menu1.getSort())-(menu2.getSort() == null?0:menu2.getSort());
        }).collect(Collectors.toList());
        return children;
    }
}