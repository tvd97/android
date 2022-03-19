package com.example.docbao.ClassModel;

public class CommentChapter {
    public  int idComment;
    public  int idChapter;
    public  String  contentComment;

    public CommentChapter(){}

    public CommentChapter(int idComment, int idChapter, String contentComment) {
        this.idComment = idComment;
        this.idChapter = idChapter;
        this.contentComment = contentComment;

    }

    public int getIdComment() {
        return idComment;
    }

    public void setIdComment(int idComment) {
        this.idComment = idComment;
    }

    public int getIdChapter() {
        return idChapter;
    }

    public void setIdChapter(int idChapter) {
        this.idChapter = idChapter;
    }

    public String getContentComment() {
        return contentComment;
    }

    public void setContentComment(String contentComment) {
        this.contentComment = contentComment;
    }
}
