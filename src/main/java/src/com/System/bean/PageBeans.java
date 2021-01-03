package src.com.System.bean;

import java.util.List;

public class PageBeans<T> {
    private Integer currentPage;//当前查询的第几页
    private Integer pageSize;//每页几行
    private Integer beforePage;//上一页
    private Integer afterPage;//下一页
    private Integer totalRows;//总行数
    private Integer totalPages;//总页数

    private List<T> list;

    public PageBeans() {
    }
    public PageBeans(Integer currentPage,Integer pageSize,Integer totalRows, List<T> list){
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalRows = totalRows;
        this.list = list;
        // 4.一共多少页 totalPages
        this.totalPages = this.totalRows%this.pageSize==0?this.totalRows/this.pageSize:this.totalRows/this.pageSize+1;
        //6.上一页
        this.beforePage = this.currentPage-1<=0?1:this.currentPage-1;
        //7.下一页
        this.afterPage = this.currentPage+1>=this.totalPages?this.totalPages:this.currentPage+1;

    }
    public PageBeans(Integer currentPage, Integer pageSize, Integer beforePage, Integer afterPage, Integer totalRows, Integer totalPages, List<T> list) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.beforePage = beforePage;
        this.afterPage = afterPage;
        this.totalRows = totalRows;
        this.totalPages = totalPages;
        this.list = list;
         }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getBeforePage() {
        return beforePage;
    }

    public void setBeforePage(Integer beforePage) {
        this.beforePage = beforePage;
    }

    public Integer getAfterPage() {
        return afterPage;
    }

    public void setAfterPage(Integer afterPage) {
        this.afterPage = afterPage;
    }

    public Integer getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(Integer totalRows) {
        this.totalRows = totalRows;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", beforePage=" + beforePage +
                ", afterPage=" + afterPage +
                ", totalRows=" + totalRows +
                ", totalPages=" + totalPages +
                ", list=" + list +
                '}';
    }

}
