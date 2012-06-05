package org.bulkframework.common.pagination;

import java.io.Serializable;
import java.util.List;

/**
 * 分页处理类.
 *
 * @author wiflish
 * @createTime 2012-5-31 下午5:07:00
 */
public class Pager<T> implements Serializable {
	private static final long serialVersionUID = -7813513436632328774L;
	
	private int totalCount;
	/** 页大小,默认20条记录. */
	private int pageSize = 20;
	/** 当前页, 默认第一页 */
	private int pageNo = 1;
	private List<T> pageData;
	private boolean needTotalCount = true;
	
	public Pager() {
	}

	public Pager(int pageNo, int pageSize) {
		this.pageNo = pageNo;
		this.pageSize = pageSize;
	}
	
	/**
	 * 获取当前页的记录索引.
	 * @return
	 */
	public int getStartIndex() {
		return (pageNo - 1) * pageSize;
	}

	/**
	 * 计算总页数.
	 * @return
	 */
	public int getPageCount() {
		if(totalCount <= 0) {
			return 0;
		}
		return (totalCount - 1) / pageSize + 1;
	}
	
	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public List<T> getPageData() {
		return pageData;
	}

	public void setPageData(List<T> pageData) {
		this.pageData = pageData;
	}

	public boolean isNeedTotalCount() {
		return needTotalCount;
	}

	public void setNeedTotalCount(boolean needTotalCount) {
		this.needTotalCount = needTotalCount;
	}
}
