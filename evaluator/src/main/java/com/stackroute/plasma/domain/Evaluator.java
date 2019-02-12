package com.stackroute.plasma.domain;


import lombok.*;

import javax.swing.text.Element;


@Data
//@Builder
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
public class Evaluator {
    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String title;
    public String url;
    //private Element description;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }
 /*   private String content;
    private int level;
    private float conf_score;*/


    /*public Evaluator() {
    }

    public Evaluator(String url, Element description, String content, int level, float conf_score) {
        this.url = url;
        this.description = description;
        this.content = content;
        this.level = level;
        this.conf_score = conf_score;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Element getDescription() {
        return description;
    }

   // public void setDescription(Element description) {
   //     this.description = description;
    //}

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public float getConf_score() {
        return conf_score;
    }

    public void setConf_score(float conf_score) {
        this.conf_score = conf_score;
    }

    public void setDescription(org.jsoup.nodes.Element element) {
    }*/
}

