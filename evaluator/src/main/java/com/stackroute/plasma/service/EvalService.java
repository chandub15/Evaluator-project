package com.stackroute.plasma.service;

import com.stackroute.plasma.domain.Evaluator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;


@Service
public class EvalService {

    Document doc;

    public String getHtmlContent() throws IOException {
        doc = Jsoup.connect("https://www.geeksforgeeks.org/encapsulation-in-java/")
                .header("Accept-Encoding", "gzip, deflate")
                .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:23.0) Gecko/20100101 Firefox/23.0")
                .maxBodySize(0)
                .timeout(600000)
                .get();
       // System.out.println("RESPONSE data"+doc);
        return String.valueOf(doc);
    }


    public String calScore() throws IOException {
       //String docx = Jsoup.connect("https://www.geeksforgeeks.org/encapsulation-in-java/").get().body().text();
        Document docx = Jsoup.connect("https://www.geeksforgeeks.org/encapsulation-in-java/").get();
/*
        String description = docx.select("meta[name=description]").first().attr("content");
        //System.out.println("Description : " + description);

        String keywords = docx.select("meta[name=keywords]").first().attr("content");
        //System.out.println("Keywords : " + keywords);
        System.out.println("RESPONSE data"+ description +"\n \n "+keywords);*/

        Element link = docx.select("a").first();

       // String text = docx.body().text(); // "An example link"
        // String linkHref = link.attr("href"); // "http://example.com/"
        // String linkText = link.text();
        return linkHref;
    }

    public String getScore() {

        return "anythingABC";
    }
}
