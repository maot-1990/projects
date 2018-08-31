package com.pers.blog.util;

public class Pager {
    
    /**
     * 当前页数
     */
    private int pageIndex = 1;
    /**
     * 每页条数
     */
    private int pageSize = 5;
    /**
     * 总页数
     */
    private int totalPage;
    /**
     * 总记录数
     */
    private int totalNum;
    
    public Pager(){
        
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        totalPage = 0;
        if(this.totalNum%this.pageSize == 0){
            totalPage = totalNum/pageSize;
        }else{
            totalPage = totalNum/pageSize + 1;
        }
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }
    
}
