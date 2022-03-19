package com.example.docbao.ClassModel;

public class Story {
    public   int idStory;
    public   String nameStory;
    public   String  typeStory;
    public  Story(){}
    public Story(int idStory, String nameStory, String typeStory) {
        this.idStory = idStory;
        this.nameStory = nameStory;
        this.typeStory = typeStory;
    }

    public int getIdStory() {
        return idStory;
    }

    public void setIdStory(int idStory) {
        this.idStory = idStory;
    }

    public String getNameStory() {
        return nameStory;
    }

    public void setNameStory(String nameStory) {
        this.nameStory = nameStory;
    }

    public String getTypeStory() {
        return typeStory;
    }

    public void setTypeStory(String typeStory) {
        this.typeStory = typeStory;
    }
}
