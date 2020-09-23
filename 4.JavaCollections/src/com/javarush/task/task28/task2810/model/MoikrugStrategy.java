package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MoikrugStrategy implements Strategy {
    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?q=java+%s&page=%d";
    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.102 Safari/537.36";

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> listVacancy = new ArrayList<>();
        String siteName = "https://moikrug.ru";
        int pageNumber = 0;

        String url = String.format(URL_FORMAT, searchString, pageNumber);

        try {

            Document doc;

            while (true) {
                doc = getDocument(searchString, pageNumber++);

                Elements elements = doc.getElementsByAttributeValue("class", "job");
                elements.addAll(doc.getElementsByAttributeValue("class", "job marked"));

                if (elements.size() != 0) {
                    for (Element element : elements) {
                        Vacancy vacancy = new Vacancy();
                        vacancy.setTitle(element.select("div[class=title]").text().trim());

                        vacancy.setSalary(element.select("div[class=salary]").text().trim());
                        vacancy.setCity(element.select("span[class=location]").text().trim());
                        vacancy.setCompanyName(element.select("[class=company_name]").text());

                        vacancy.setSiteName(siteName);
                        vacancy.setUrl(siteName + element.select("div[class=title]").first().getElementsByTag("a").attr("href").trim());

                        listVacancy.add(vacancy);

                    }

                } else break;
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return listVacancy;
    }

    protected Document getDocument(String searchString, int page) throws IOException {
        return Jsoup.connect(String.format(URL_FORMAT, searchString, page))
                .userAgent(USER_AGENT)
                .referrer("")
                .get();
    }
}
