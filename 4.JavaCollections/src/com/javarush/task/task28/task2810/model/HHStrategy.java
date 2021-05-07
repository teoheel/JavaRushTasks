package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HHStrategy implements Strategy {
    private static final String URL_FORMAT = "http://hh.ru/search/vacancy?text=java+%s&page=%d";

    protected Document getDocument(String searchString, int page) {
        Document doc = null;
        try {
            doc = Jsoup.connect(String.format(URL_FORMAT, searchString, page)).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.102 Safari/537.36").referrer("").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doc;
    }

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> vacancies = new ArrayList<>();
        Vacancy vacancy;
        int page = 0;
        Document doc;
        while (true) {
            doc = getDocument(searchString, page++);
            if (doc == null) {
                break;
            }
            Elements elements = doc.select("[data-qa=vacancy-serp__vacancy]");
            if (elements.size() == 0) {
                break;
            }
            for (Element element : elements) {
                vacancy = new Vacancy();
                vacancy.setTitle(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").text());
                vacancy.setCity(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-address").text());
                vacancy.setCompanyName(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-employer").text());
                vacancy.setSalary(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-compensation").text());
                vacancy.setUrl(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").attr("href").trim());
                vacancy.setSiteName(String.format(URL_FORMAT, searchString, page));
                vacancies.add(vacancy);
            }
        }
        return vacancies;
    }
}
