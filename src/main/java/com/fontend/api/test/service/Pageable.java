package com.fontend.api.test.service;

public interface Pageable {
	int pageNumber();
	int pageSize();
	default String getOrdenacao() {
		return "desc";
	}
	default String getField() {
		return "id";
	}
}
