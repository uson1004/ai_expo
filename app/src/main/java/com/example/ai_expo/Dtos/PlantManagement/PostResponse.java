package com.example.ai_expo.Dtos.PlantManagement;

import com.example.ai_expo.Dtos.Post;
import com.google.gson.annotations.SerializedName;


import java.util.List;

public class PostResponse {
    @SerializedName("content")
    private List<Post> posts;

    @SerializedName("pageable")
    private Pageable pageable;

    @SerializedName("last")
    private boolean last;

    @SerializedName("totalPages")
    private int totalPages;

    @SerializedName("totalElements")
    private int totalElements;

    @SerializedName("size")
    private int size;

    @SerializedName("number")
    private int number;

    @SerializedName("sort")
    private Sort sort;

    @SerializedName("first")
    private boolean first;

    @SerializedName("numberOfElements")
    private int numberOfElements;

    @SerializedName("empty")
    private boolean empty;

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public Pageable getPageable() {
        return pageable;
    }

    public void setPageable(Pageable pageable) {
        this.pageable = pageable;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    // Getters and setters
}

class Pageable {
    @SerializedName("pageNumber")
    private int pageNumber;

    @SerializedName("pageSize")
    private int pageSize;

    @SerializedName("sort")
    private Sort sort;

    @SerializedName("offset")
    private int offset;

    @SerializedName("paged")
    private boolean paged;

    @SerializedName("unpaged")
    private boolean unpaged;

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public boolean isPaged() {
        return paged;
    }

    public void setPaged(boolean paged) {
        this.paged = paged;
    }

    public boolean isUnpaged() {
        return unpaged;
    }

    public void setUnpaged(boolean unpaged) {
        this.unpaged = unpaged;
    }
// Getters and setters
}

class Sort {
    @SerializedName("empty")
    private boolean empty;

    @SerializedName("unsorted")
    private boolean unsorted;

    @SerializedName("sorted")
    private boolean sorted;

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public boolean isUnsorted() {
        return unsorted;
    }

    public void setUnsorted(boolean unsorted) {
        this.unsorted = unsorted;
    }

    public boolean isSorted() {
        return sorted;
    }

    public void setSorted(boolean sorted) {
        this.sorted = sorted;
    }
// Getters and setters
}


