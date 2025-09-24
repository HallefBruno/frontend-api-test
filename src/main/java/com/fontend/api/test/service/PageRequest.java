package com.fontend.api.test.service;


public class PageRequest implements Pageable {
	
	public PageRequest() {}
	
	private int pageNumber;
	private int pageSize;
	
	public PageRequest(int pageNumber, int pageSize) {
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
	}
	
	@Override
	public int pageNumber() {
		return pageNumber;
	}

	@Override
	public int pageSize() {
		return pageSize;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}
