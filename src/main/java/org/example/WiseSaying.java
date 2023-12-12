package org.example;

class WiseSaying {
    private int id;
    private String author;
    private String content;

    WiseSaying (int id, String author, String content) {
        this.id = id;
        this.author = author;
        this.content = content;
    }


    public int getId() {
        return this.id;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getContent() {
        return this.content;
    }



    public void setAuthor(String author) {
        this.author = author;
    }

    public void setContent (String content) {
        this.content = content;
    }


}

