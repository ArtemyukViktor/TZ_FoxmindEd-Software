package com.example.viktor.tzproducttest.pojo.pojcategory;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PojoProductCategory {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("results")
    @Expose
    private List<ResultCategory> results = null;
    @SerializedName("params")
    @Expose
    private Object params;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("pagination")
    @Expose
    private PaginationCategory pagination;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<ResultCategory> getResults() {
        return results;
    }

    public void setResults(List<ResultCategory> results) {
        this.results = results;
    }

    public Object getParams() {
        return params;
    }

    public void setParams(Object params) {
        this.params = params;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public PaginationCategory getPagination() {
        return pagination;
    }

    public void setPagination(PaginationCategory pagination) {
        this.pagination = pagination;
    }

}
