package com.fontend.api.test.service;

import java.util.Collections;
import java.util.List;

public class PageImpl<T> implements Pageable, Page<T> {
	
	public PageImpl() {}
	
	private List<T> content;
	private long totalElements;
	private int totalPages;
	private PageRequest pageable;
	
	public PageImpl(List<T> content, PageRequest pageable, long totalElements) {
		this.content = content;
		this.pageable = pageable;
		this.totalElements = totalElements;
	}
	
	@Override
	public int getTotalPages() {
		totalPages = (int) Math.ceil((float) totalElements/pageable.pageSize());
		return totalPages;
	}

	@Override
	public long getTotalElements() {
		return totalElements;
	}

	@Override
	public List<T> getContent() {
		if(content == null) return Collections.emptyList();
		return content;
	}

	@Override
	public int pageNumber() {
		return pageable.pageNumber();
	}

	@Override
	public int pageSize() {
		return pageable.pageSize();
	}

	@Override
	public String getOrdenacao() {
		return pageable.getOrdenacao();
	}

	@Override
	public String getField() {
		return pageable.getField();
	}

}
