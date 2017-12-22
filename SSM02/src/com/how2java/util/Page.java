package com.how2java.util;

/**
 * @author suxin
 * 2017年12月19日
 * prjName:SSM02 pakName:com.how2java.util
 * TODO
 * 用于统计每次分页的起点和终点，其中最后一个方法用来处理当以5为分页单位的一些特殊情况
 * 2017年12月19日
 */
public class Page {

	int start=0;
	int count = 5;
	int last = 0;
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getLast() {
		return last;
	}
	public void setLast(int last) {
		this.last = last;
	}
	
	public void caculateLast(int total) {
	    // 假设总数是50，是能够被5整除的，那么最后一页的开始就是45
	    if (0 == total % count)
	        last = total - count;
	    // 假设总数是51，不能够被5整除的，那么最后一页的开始就是50
	    else
	        last = total - total % count;		
	}

	
	
	
}
