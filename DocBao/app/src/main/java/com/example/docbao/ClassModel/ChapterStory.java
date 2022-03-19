package com.example.docbao.ClassModel;

public class ChapterStory {
    public  int idChapter;
    public  String chapterStory;
    public  int idStory;
    public  String contentChapter;

    public ChapterStory(){}

    public ChapterStory(int idChapter, String chapterStory, int idStory, String contentChapter) {
        this.idChapter = idChapter;
        this.chapterStory = chapterStory;
        this.idStory = idStory;
        this.contentChapter = contentChapter;
    }

    public int getIdChapter() {
        return idChapter;
    }

    public void setIdChapter(int idChapter) {
        this.idChapter = idChapter;
    }

    public String getChapterStory() {
        return chapterStory;
    }

    public void setChapterStory(String chapterStory) {
        this.chapterStory = chapterStory;
    }

    public int getIdStory() {
        return idStory;
    }

    public void setIdStory(int idStory) {
        this.idStory = idStory;
    }

    public String getContentChapter() {
        return contentChapter;
    }

    public void setContentChapter(String contentChapter) {
        this.contentChapter = contentChapter;
    }
}
