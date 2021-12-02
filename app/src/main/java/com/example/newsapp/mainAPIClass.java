package com.example.newsapp;

import java.util.ArrayList;

public class mainAPIClass {

    private String status, totalResult;
    private ArrayList<modelAPIClass> articles;

    public mainAPIClass(String status, String totalResult, ArrayList<modelAPIClass> articles) {
        this.status = status;
        this.totalResult = totalResult;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(String totalResult) {
        this.totalResult = totalResult;
    }

    public ArrayList<modelAPIClass> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<modelAPIClass> articles) {
        this.articles = articles;
    }
}
