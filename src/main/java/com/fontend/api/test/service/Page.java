package com.fontend.api.test.service;

import java.util.List;


public interface Page<T> {
	
	public int getTotalPages();
	public long getTotalElements();
	public List<T> getContent();
	
}
