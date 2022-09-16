package com.easy.city.codegen.controller;

import cn.hutool.core.io.IoUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.easy.city.codegen.core.util.R;
import com.easy.city.codegen.entity.GenConfig;
import com.easy.city.codegen.service.SysGeneratorService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * 代码生成器
 * @author ZhangYuting
 */
@Controller
@RequestMapping("/generator")
public class SysGeneratorController {
    @Autowired
    private SysGeneratorService sysGeneratorService;

    /**
     * 列表
     *
     * @param tableName 参数集
     * @return 数据库表
     */
    @GetMapping("/page")
    @ResponseBody
    public R getPage(Page page, String tableName) {
        return new R<>(sysGeneratorService.getPage(page, tableName));
    }

    /**
     * 生成代码
     */
    @SneakyThrows
	@GetMapping(value = "/code")
    public void generatorCode(GenConfig genConfig, HttpServletResponse response) {
        byte[] data = sysGeneratorService.generatorCode(genConfig);

        response.reset();
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, String.format("attachment; filename=%s.zip", genConfig.getTableName()));
        response.addHeader(HttpHeaders.CONTENT_LENGTH, String.valueOf(data.length));
        response.setContentType("application/octet-stream; charset=UTF-8");

        IoUtil.write(response.getOutputStream(), Boolean.TRUE, data);
    }
}
