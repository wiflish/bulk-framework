package org.bulkframework.common.pagination;

import static org.junit.Assert.*;

import org.junit.Test;

public class PagerTest {

	@Test
	public void testGetStartIndex() {
		Pager<String> pager = new Pager<String>(2, 20);
		
		assertTrue(pager.getStartIndex() == 20);
	}
	
	@Test
	public void testGetPageCount() {
		Pager<String> pager = new Pager<String>(2, 20);
		
		pager.setTotalCount(101);
		
		assertTrue(6 == pager.getPageCount());
	}
}
