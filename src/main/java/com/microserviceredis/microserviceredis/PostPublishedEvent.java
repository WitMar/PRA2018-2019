package com.microserviceredis.microserviceredis;


import lombok.*;


import java.util.List;


public class PostPublishedEvent {

    private String postUrl;
    private String postTitle;
    private List<String> emails;

    public PostPublishedEvent(String postUrl, String postTitle, List<String> emails) {
        this.postUrl = postUrl;
        this.postTitle = postTitle;
        this.emails = emails;
    }

    public String getPostUrl() {
        return postUrl;
    }

    public void setPostUrl(String postUrl) {
        this.postUrl = postUrl;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }
}
