package me.songjy.generator.core;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class GeneratorParam {

    private String author;

    private List<String> tableName;

    private String basePackage;

    private String logicDelColumn;

    /**
     * 生成文件输出路径
     */
    private String outputBasePath;

    private String poPath;

    private String doPath;

    private String reqPath;

    private String rspPath;

    private String servicePath;

    private String serviceImplPath;

    private String daoPath;

    private String apiPath;

    private String actionPath;

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String author;

        private List<String> tableName;

        private String basePackage;

        private String logicDelColumn;

        private String outputBasePath;
        private String poPath = ".provider.repository.po";

        private String doPath = ".api.model";

        private String reqPath = ".api.request";

        private String rspPath = ".api.response";

        private String servicePath = ".domain.service";

        private String serviceImplPath = ".provider.service.impl";

        private String daoPath = ".provider.repository.dao";

        private String apiPath = ".api.service";

        private String actionPath = ".domain.action";


        public Builder outputBasePath(String outputBasePath) {
            this.outputBasePath = outputBasePath;
            return this;
        }

        public Builder poPath(String poPath) {
            this.poPath = poPath;
            return this;
        }

        public Builder doPath(String doPath) {
            this.doPath = doPath;
            return this;
        }

        public Builder reqPath(String reqPath) {
            this.reqPath = reqPath;
            return this;
        }

        public Builder rspPath(String rspPath) {
            this.rspPath = rspPath;
            return this;
        }

        public Builder servicePath(String servicePath) {
            this.servicePath = servicePath;
            return this;
        }

        public Builder serviceImplPath(String serviceImplPath) {
            this.serviceImplPath = serviceImplPath;
            return this;
        }

        public Builder daoPath(String daoPath) {
            this.daoPath = daoPath;
            return this;
        }

        public Builder apiPath(String apiPath) {
            this.apiPath = apiPath;
            return this;
        }

        public Builder actionPath(String actionPath) {
            this.actionPath = actionPath;
            return this;
        }

        public Builder author(String author) {
            this.author = author;
            return this;
        }

        public Builder tableName(String... tableName) {
            this.tableName = Arrays.stream(tableName).collect(Collectors.toList());
            return this;
        }

        public Builder basePackage(String basePackage) {
            this.basePackage = basePackage;
            return this;
        }

        public Builder logicDelColumn(String logicDelColumn) {
            this.logicDelColumn = logicDelColumn;
            return this;
        }

        public GeneratorParam build() {
            return new GeneratorParam(
                    this.author,
                    this.tableName,
                    this.basePackage,
                    this.logicDelColumn,
                    this.outputBasePath,
                    this.poPath,
                    this.doPath,
                    this.reqPath,
                    this.rspPath,
                    this.servicePath,
                    this.serviceImplPath,
                    this.daoPath,
                    this.apiPath,
                    this.actionPath);
        }

    }

}
