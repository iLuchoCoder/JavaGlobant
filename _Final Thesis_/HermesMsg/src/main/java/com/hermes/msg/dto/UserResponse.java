package com.hermes.msg.dto;

import java.util.List;

public class UserResponse {

    private List<UserDTO> content;
    private int numPage;
    private int sizePage;
    private long totalElements;
    private int totalPages;
    private boolean last;

    public UserResponse() {
        super();
    }

    public List<UserDTO> getContent() {
        return content;
    }

    public void setContent(List<UserDTO> content) {
        this.content = content;
    }

    public int getNumPage() {
        return numPage;
    }

    public void setNumPage(int numPage) {
        this.numPage = numPage;
    }

    public int getSizePage() {
        return sizePage;
    }

    public void setSizePage(int sizePage) {
        this.sizePage = sizePage;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }
}
