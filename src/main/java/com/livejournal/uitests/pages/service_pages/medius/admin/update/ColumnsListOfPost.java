package com.livejournal.uitests.pages.service_pages.medius.admin.update;

import java.util.ArrayList;

public class ColumnsListOfPost {

    private String subject = "!!!";
    private String editor = "test";
    ArrayList<String> authors = new ArrayList();
    private String category = "";
    private boolean interesting = false;
    private String date = "";
    ArrayList<String> positionOnMainPage = new ArrayList();
    private String status = "Post in process";

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public String getEditor() {
        return editor;
    }

    public String getStatus() {
        return status;
    }

    public void setAuthors(ArrayList<String> authors) {
        for (int i = 0; i < authors.size(); i++) {
            this.authors.add(authors.get(i));
        }
    }

    public void setInterestingPost(){
        this.interesting = true;
    }

    public void setMain(ArrayList<String> mainPage){
        for(int i=0; i< mainPage.size(); i++){
            positionOnMainPage.add(mainPage.get(i));
        }
    }

    public ArrayList<String> getPositionOnMainPage(){
        return this.positionOnMainPage;
    }

    public boolean getInterestingPost(){
        return interesting;
    }

    public ArrayList<String> getAuthors(){
        return authors;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }
}