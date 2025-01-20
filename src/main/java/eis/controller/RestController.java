package eis.controller;

import eis.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private EnterpriseService enterpriseService;


    // 1. 查询企业信息的问答功能接口
    @GetMapping("/api/getEnterpriseInfoAnswer")
    public String getEnterpriseInfoAnswer(@RequestParam(name = "question", required = false, defaultValue = "") String question, Model model) {
        // 获取企业信息问答的答案
        System.out.println("question: " + question);
        String answer = enterpriseService.getEnterpriseInfoAnswer(question);
        return answer;  // 返回问答结果页面
    }
}
