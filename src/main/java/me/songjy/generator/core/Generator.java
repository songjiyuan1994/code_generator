//package me.songjy.generator.core;
//
//import cn.hutool.core.io.FileUtil;
//import cn.hutool.extra.spring.SpringUtil;
//import me.songjy.generator.config.*;
//import me.songjy.generator.core.db.ColumnSchema;
//import me.songjy.generator.core.db.TableSchema;
//import me.songjy.generator.utils.StringUtils;
//import me.songjy.generator.utils.VelocityUtils;
//import org.apache.velocity.Template;
//import org.apache.velocity.VelocityContext;
//import org.apache.velocity.app.Velocity;
//import org.springframework.validation.annotation.Validated;
//
//import java.io.StringWriter;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//public class Generator {
//
//    public static void genCode(@Validated GeneratorParam config) {
//        List<TemplateParam> params = prepareTempParam(config);
//        process(params, config);
//    }
//
//    public static List<TemplateParam> prepareTempParam(GeneratorParam config) {
//
//
//        List<ColumnSchema> columnSchemas = SpringUtil.getBean(ColumnSchemaService.class).select(config.getTableName());
//        List<TableSchema> tableSchemas = SpringUtil.getBean(TableSchemaService.class).select(config.getTableName());
//
//        Map<String, List<ColumnSchema>> columnMap = columnSchemas.stream().collect(Collectors.groupingBy(ColumnSchema::getTableName, Collectors.toList()));
//        Map<String, String> tableMap = tableSchemas.stream().collect(Collectors.toMap(TableSchema::getTableName, TableSchema::getTableComment));
//
//
//        List<TemplateParam> params = new ArrayList<>();
//        for (Map.Entry<String, List<ColumnSchema>> table : columnMap.entrySet()) {
//            String tableName = table.getKey();
//            List<ColumnSchema> schemas = table.getValue();
//
//
//            HashSet<String> importList = new HashSet<>();
//            List<Columns> columns = new ArrayList<>();
//            List<Columns> uniqueColumns = new ArrayList<>();
//            Columns createTimeColumn = null;
//            Columns updateTimeColumn = null;
//            String logicDelColumn = null;
//            String pkColumn = null;
//            String pkFieldName = null;
//            String pkFieldNameCap = null;
//            Boolean hasLogicDelColumn = false;
//            for (ColumnSchema schema : schemas) {
//                DataType dateType = DataType.getByColumnDataType(schema.getDataType());
//                Columns c = Columns.builder()
//                        .columKey(schema.getColumKey())
//                        .columnType(schema.getDataType())
//                        .columnName(schema.getColumName())
//                        .javaField(StringUtils.toCamelCase(schema.getColumName()))
//                        .javaType(dateType.getField())
//                        .columnComment(schema.getColumComment())
//                        .extra(schema.getExtra())
//                        .build();
//                columns.add(c);
//                if (dateType.getFieldImport() != null) {
//                    importList.add(dateType.getFieldImport());
//                }
//                if (GeneratorConfig.UPDATE_TIME_NAMES.contains(schema.getColumName())) {
//                    updateTimeColumn = c;
//                }
//                if (GeneratorConfig.CREATE_TIME_NAMES.contains(schema.getColumName())) {
//                    createTimeColumn = c;
//                }
//                if (config.getLogicDelColumn() != null && config.getLogicDelColumn().equals(c.getColumnName())) {
//                    logicDelColumn = c.getColumnName();
//                    hasLogicDelColumn = true;
//                }
//                if (c.getColumKey().equals(Constants.PK)) {
//                    pkColumn = c.getColumnName();
//                    pkFieldName = c.getJavaField();
//                    pkFieldNameCap = c.getCapJavaField();
//                }
//                if (c.getColumKey().equals(Constants.UK)) {
//                    uniqueColumns.add(c);
//                }
//            }
//            TemplateParam param = TemplateParam.builder()
//                    .tableComment(tableMap.get(tableName))
//                    .tableName(tableName)
//                    .uniqueColumns(uniqueColumns)
//                    .className(StringUtils.capitalize(StringUtils.toCamelCase(tableName)))
//                    .importList(importList)
//                    .columns(columns)
//                    .pkColumn(pkColumn)
//                    .logicDelColumn(logicDelColumn)
//                    .dynamicInsertColumn(createTimeColumn)
//                    .dynamicUpdateColumn(updateTimeColumn)
//                    .pkFieldName(pkFieldName)
//                    .pkFieldNameCap(pkFieldNameCap)
//                    .hasLogicDelColumn(hasLogicDelColumn)
//                    .build();
//            params.add(param);
//        }
//
//        return params;
//    }
//
//
//    public static void process(List<TemplateParam> params, GeneratorParam config) {
//
//        VelocityInitializer.initVelocity();
//
//
//        for (TemplateParam param : params) {
//
//            VelocityContext velocityContext = VelocityUtils.prepareContext(param, config);
//
//            for (TemplateType templateType : TemplateType.values()) {
//                // 渲染模板
//                StringWriter sw = new StringWriter();
//                Template tpl = Velocity.getTemplate(templateType.getTemplatePath(), Constants.UTF8);
//                tpl.merge(velocityContext, sw);
//                FileUtil.writeUtf8String(sw.toString(), templateType.getFilePath(config, param.getClassName(), param.getTableName()));
//            }
//        }
//
//    }
//
//}
