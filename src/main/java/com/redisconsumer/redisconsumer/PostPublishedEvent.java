package com.redisconsumer.redisconsumer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PostPublishedEvent {

    private String postUrl;

    private String postTitle;

    private List<String> emails;

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

    @JsonCreator
    public PostPublishedEvent(@JsonProperty("postUrl") String postUrl, @JsonProperty("postTitle") String postTitle, @JsonProperty("emails") List<String> emails) {
        this.postUrl = postUrl;
        this.postTitle = postTitle;
        this.emails = emails;
    }

}