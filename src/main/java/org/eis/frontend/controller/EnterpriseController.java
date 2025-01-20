package org.eis.frontend.controller;

import org.eis.frontend.model.Enterprise;
import org.eis.frontend.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@Controller
public class EnterpriseController {

    @Autowired
    private EnterpriseService enterpriseService;

    // 1. 显示首页
    @GetMapping("/")
    public String index() {
        return "index";  // 返回 index.html 页面
    }

    // 2. 根据企业名称查询
    @GetMapping("/searchByName")
    public String searchByName(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "searchType", required = false) String searchType,
            Model model) {
        // 首次加载页面（name 参数为 null）
        if (name == null) {
            model.addAttribute("searchType", "name");
            return "enterpriseList";
        }

        // 输入为空时，设置提示信息
        if (name.trim().isEmpty()) {
            model.addAttribute("message", "请输入企业名称进行搜索！");
            model.addAttribute("enterprises", List.of());
            model.addAttribute("searchType", searchType);
            return "enterpriseList";
        }

        // 正常查询
        List<Enterprise> enterprises = enterpriseService.searchEnterpriseByName(name);
        model.addAttribute("enterprises", enterprises);
        model.addAttribute("searchType", searchType);

        // 如果结果为空，设置提示信息
        if (enterprises.isEmpty()) {
            model.addAttribute("message", "未找到相关企业，请尝试其他名称！");
        }

        return "enterpriseList";
    }

    // 3. 根据企业简称查询
    @GetMapping("/searchByAbbreviation")
    public String searchByAbbreviation(
            @RequestParam(name = "abbreviation", required = false) String abbreviation,
            @RequestParam(name = "searchType", required = false) String searchType,
            Model model) {
        // 首次加载页面（abbreviation 参数为 null）
        if (abbreviation == null) {
            model.addAttribute("searchType", "abbreviation");
            return "enterpriseList";
        }

        // 输入为空时，设置提示信息
        if (abbreviation.trim().isEmpty()) {
            model.addAttribute("message", "请输入企业简称进行搜索！");
            model.addAttribute("enterprises", List.of());
            model.addAttribute("searchType", searchType);
            return "enterpriseList";
        }

        // 正常查询
        List<Enterprise> enterprises = enterpriseService.searchEnterpriseByAbbreviation(abbreviation);
        model.addAttribute("enterprises", enterprises);
        model.addAttribute("searchType", searchType);

        // 如果结果为空，设置提示信息
        if (enterprises.isEmpty()) {
            model.addAttribute("message", "未找到相关企业，请尝试其他简称！");
        }

        return "enterpriseList";
    }

    // 4. 获取与某企业强关联的企业，基于行业、地区等相同属性
    @GetMapping("/getRelatedEnterprises")
    public String getRelatedEnterprises(Model model) {
        // 获取相关企业
        List<Enterprise> relatedEnterprises = enterpriseService.getRelatedEnterprises();
        model.addAttribute("enterprises", relatedEnterprises);  // 将查询结果传递给视图
        model.addAttribute("message","尚未完成");
        return "enterpriseRelated";  // 返回查询结果页面
    }

    // 5. 查询企业信息的问答功能
    @GetMapping("/getEnterpriseInfoAnswer")
    public String getEnterpriseInfoAnswer() {
        // 只是现实页面，前端 通过 ajax 请求后端接口
        return "enterpriseChat";  // 返回问答结果页面
    }

    // 6. 查看企业详情
    @GetMapping("/enterpriseDetail")
    public String getEnterpriseDetail(
            @RequestParam(name = "name", required = false) String name,
            Model model) {
        // 首次加载页面（name 参数为 null）
        if (name == null) {
            return "enterpriseDetail";
        }

        // 输入为空时，设置提示信息
        if (name.trim().isEmpty()) {
            model.addAttribute("message", "请输入企业名称！");
            model.addAttribute("enterprises", List.of());
            return "enterpriseDetail";
        }

        // 正常查询
        List<Enterprise> enterprises = enterpriseService.searchEnterpriseByName(name);
        model.addAttribute("enterprises", enterprises);

        // 如果结果为空，设置提示信息
        if (enterprises.isEmpty()) {
            model.addAttribute("message", "未找到相关企业！");
        }

        return "enterpriseDetail";
    }

}
