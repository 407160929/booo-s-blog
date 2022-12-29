package com.bo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bo.domain.ResponseResult;
import com.bo.domain.dto.AddCategoryDto;
import com.bo.domain.entity.Category;
import com.bo.domain.vo.CategoryVo;

import java.util.List;


/**
 * 分类表(Category)表服务接口
 *
 * @author makejava
 * @since 2022-12-22 17:08:33
 */
public interface CategoryService extends IService<Category> {

    ResponseResult getCategoryList();

    List<CategoryVo> listAllCategory();

    ResponseResult getCategoryPageList(Integer pageNum, Integer pageSize,String name, String status);

    ResponseResult addCategory(AddCategoryDto addCategoryDto);

    ResponseResult getCategoryById(Long id);
}
