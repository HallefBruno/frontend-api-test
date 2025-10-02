package com.fontend.api.test.service;

import java.util.List;

public class PageImpl<T> {
	
	private List<T> content;
	private Page page;
	
	public PageImpl() {
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
	
	public List<T> getContent() {
		return content;
	}

	public void setContent(List<T> content) {
		this.content = content;
	}

}
