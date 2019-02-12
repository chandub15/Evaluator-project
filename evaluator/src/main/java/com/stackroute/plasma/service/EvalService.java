package com.stackroute.plasma.service;

import com.stackroute.plasma.domain.Evaluator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.List;

public class EvalService {

    private static Evaluator evaluator;

    private String[] str={"Define","","","",};

    private static String htmlCode="<html>\n" +
            "<body>\n" +
            "\n" +
            "<h1>My First Heading</h1>\n" +
            "\n" +
            "<p>My first paragraph.</p>\n" +
            "\n" +
            "</body>\n" +
            "</html>";
    public static Evaluator getHttpContent() throws IOException {

         Document html = Jsoup.parse(htmlCode);
        Element element=html.select("h1").first();
        evaluator.setDescription(element);
        System.out.println(evaluator.getUrl());
        return evaluator;
    }
}
