package com.how2java.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.pojo.Category;
import com.how2java.service.CategoryService;
import com.how2java.util.Page;

// 鍛婅瘔spring mvc杩欐槸涓�涓帶鍒跺櫒绫�
@Controller
@RequestMapping("")
public class CategoryController {
	@Autowired
	CategoryService categoryService;

	@RequestMapping("listCategory")
	public ModelAndView listCategory(Page page){
		ModelAndView mav = new ModelAndView();
		PageHelper.offsetPage(page.getStart(),5);
		List<Category> cs= categoryService.list();
		int total = (int) new PageInfo<Category>(cs).getTotal();
		
		page.caculateLast(total);
		
		// 鏀惧叆杞彂鍙傛暟
		mav.addObject("cs", cs);
		// 鏀惧叆jsp璺緞
		mav.setViewName("listCategory");
		return mav;
	}

}
