package com.v1n1c1u.demo.util;

import java.util.List;

public class PaginationUtil<T> {

    private int size;
    private int page;
    private long totalPages;

    private List<T> data;

    public PaginationUtil(int size, int page, long totalPages, List<T> data) {
        super();
        this.size = size;
        this.page = page;
        this.totalPages = totalPages;
        this.data = data;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(long totalPages) {
        this.totalPages = totalPages;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
