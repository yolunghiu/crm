package com.liuhy.crm.page;

import java.util.ArrayList;
import java.util.List;

public class PageBean<T> {
    /*
    * currentPage and pageSize are passed by user
    * */
    private int currentPage;    // current page number
    private int pageSize;    // size of each page

    /*
    * totalRecords is queried from db
    * */
    private int totalRecords;   // total records in db. i

    /*
    * calculate when this class is being constructed
    * */
    private int startIndex;     // the start index in database's records
    private int totalPages;     // the total pages number of all records

    private List<T> data = new ArrayList<T>(0);       // data queried from database

    public PageBean(int currentPage, int pageSize, int totalRecords) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalRecords = totalRecords;

        /*
        * calculate these fields with the given params
        * */
        this.startIndex = (currentPage - 1) * pageSize;
        this.totalPages = (pageSize - 1 + totalRecords) / pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
