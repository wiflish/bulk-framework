package org.bulkframework.common.orderby;

import java.io.Serializable;

/**
 * 排序.
 * 
 * @author wiflish
 * @createTime 2012-6-3 下午9:54:20
 */
public class OrderBy implements Serializable {
	private static final long serialVersionUID = 2282262265405812558L;
	
	/** 排序 */
	public static final String ORDER_ASC = "asc";
	public static final String ORDER_DESC = "desc";
	
	private String orderBy;

	public String getOrderBy() {
		return orderBy;
	}

	public OrderBy setOrderBy(String orderByColumn, String order) {
		if(orderByColumn == null || orderByColumn == "") {
			return this;
		}
		if(order == null || order == "") {
			return this;
		}
		if(!ORDER_ASC.equalsIgnoreCase(order) && !ORDER_DESC.equalsIgnoreCase(order)) {
			return this;
		}
		
		if(this.orderBy == null) {
			this.orderBy = "";
		}
		
		StringBuilder sb = new StringBuilder(this.orderBy);

		if(this.orderBy != null && this.orderBy.length() > 0) {
			sb.append(',');
		}
		sb.append(orderByColumn);
		sb.append(' ');
		sb.append(order);
		
		this.orderBy = sb.toString(); 
		
		return this;
	}
}
