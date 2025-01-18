package org.eis.frontend.service;

import org.eis.frontend.model.Enterprise;
import org.eis.frontend.repository.EnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

import java.util.List;

@Service
public class EnterpriseService {



    @Autowired
    private EnterpriseRepository enterpriseRepository;

    // 1. 根据企业名称进行查询
    public List<Enterprise> searchEnterpriseByName(String name) {
        enterpriseRepository.flush();
        // 根据企业名称进行模糊查询
        return enterpriseRepository.findByNameContaining(name);

    }

    // 2. 根据企业简称进行查询
    public List<Enterprise> searchEnterpriseByAbbreviation(String abbreviation) {
        // 根据企业简称进行模糊查询
        enterpriseRepository.flush();
        return enterpriseRepository.findByAbbreviationContaining(abbreviation);
    }


    public List<Enterprise> getRelatedEnterprises() {
        return null;
         }

    // 4. 查询企业信息的问答功能（待接入大模型）
    public String getEnterpriseInfoAnswer(String question) {
        // 请求远程服务 http://101.37.14.142:5000/get_answer?query=
        System.out.println("question: " + question);
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://1.92.200.230:5000/get_answer?query=" + URLEncoder.encode(question, StandardCharsets.UTF_8)))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "请求远程服务失败";
        }
    }
}
