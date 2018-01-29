package com.baseutil;

import java.io.Serializable;
import java.util.List;

/**
 * 分页基类
 * @author admin
 *
 */
public class Page<T> implements Serializable {

	private static final long serialVersionUID = 1L;
      
	protected int totalPages;//总页数
	protected int totalNum;//总行数
	protected int pageNum;//页码
	protected int pageSize;//页大小
	protected List<T> dataSet;// 数据集
	
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getDataSet() {
		return dataSet;
	}
	public void setDataSet(List<T> dataSet) {
		this.dataSet = dataSet;
	}
	
}
