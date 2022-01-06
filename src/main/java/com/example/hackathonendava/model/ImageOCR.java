package com.example.hackathonendava.model;

public class ImageOCR {
    private String path;
    private String text;

    public ImageOCR(String text) {
        this.text = text;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
