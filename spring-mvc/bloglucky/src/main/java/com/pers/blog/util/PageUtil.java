package com.pers.blog.util;

import java.util.ArrayList;
import java.util.List;

import com.github.pagehelper.Page;

public class PageUtil {

	public static <T> List<T> pageToList(Page<T> page){
		List<T> list = new ArrayList<T>();
		if(page != null && page.size()>0){
			for(int i=0; i<page.size(); i++){
				list.add(page.get(i));
			}
		}
		return list;
	}
}
