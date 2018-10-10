package com.example.mohit_pc.fsai.Feeds;

public class BluePrintFeed {

    String content,createdBy,image,title;

    public BluePrintFeed(){

    }

    public BluePrintFeed(String content, String createdBy, String image, String title) {
        this.content = content;
        this.createdBy = createdBy;
        this.image = image;
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
