package com.fontend.api.test.service;

public class Page<T> {
	
	private int totalPages;
	private long totalElements;

	public Page(int totalPages, long totalElements) {
		this.totalPages = totalPages;
		this.totalElements = totalElements;
	}

	public Page() {
	}
	
	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public long getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}
	
}
