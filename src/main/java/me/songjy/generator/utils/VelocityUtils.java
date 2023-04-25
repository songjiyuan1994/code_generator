package me.songjy.generator.utils;

import cn.hutool.core.date.DateUtil;
import me.songjy.generator.core.GeneratorParam;
import me.songjy.generator.core.TemplateParam;
import org.apache.velocity.VelocityContext;

import java.util.Date;

/**
 * 模板工具类
 *
 * @author ruoyi
 */
public class VelocityUtils {
    /**
     * 项目空间路径
     */
    private static final String PROJECT_PATH = "main/java";

    /**
     * mybatis空间路径
     */
    private static final String MYBATIS_PATH = "main/resources/mapper";

    /**
     * 默认上级菜单，系统工具
     */
    private static final String DEFAULT_PARENT_MENU_ID = "3";

    /**
     * 设置模板变量信息
     *
     * @return 模板列表
     */
    public static VelocityContext prepareContext(TemplateParam param, GeneratorParam config) {

        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("className", param.getClassName());
        velocityContext.put("tableName", param.getTableName());
        velocityContext.put("tableComment", param.getTableComment());
        velocityContext.put("basePackage", config.getBasePackage());
        velocityContext.put("importList", param.getImportList());
        velocityContext.put("hasCreatedBy", param.isHasCreatedBy());
        velocityContext.put("hasLastModifiedBy", param.isHasLastModifiedBy());
        velocityContext.put("author", config.getAuthor());
        velocityContext.put("dateTime", DateUtil.format(new Date(), "yyyy-MM-dd HH:mm"));
        velocityContext.put("dynamicInsertColumn", param.getDynamicInsertColumn());
        velocityContext.put("dynamicUpdateColumn", param.getDynamicUpdateColumn());
        velocityContext.put("logicDelColumn", param.getLogicDelColumn());
        velocityContext.put("columns", param.getColumns());
        velocityContext.put("pkColumn", param.getPkColumn());
        velocityContext.put("poPath", config.getPoPath());
        velocityContext.put("doPath", config.getDoPath());
        velocityContext.put("reqPath", config.getReqPath());
        velocityContext.put("rspPath", config.getRspPath());
        velocityContext.put("servicePath", config.getServicePath());
        velocityContext.put("serviceImplPath", config.getServiceImplPath());
        velocityContext.put("daoPath", config.getDaoPath());
        velocityContext.put("apiPath", config.getApiPath());
        velocityContext.put("actionPath", config.getActionPath());
        velocityContext.put("uniqueColumns", param.getUniqueColumns());
        velocityContext.put("pkFieldName", param.getPkFieldName());
        velocityContext.put("pkFieldNameCap", param.getPkFieldNameCap());
        velocityContext.put("hasLogicDelColumn", param.isHasLogicDelColumn());


        return velocityContext;
    }

}
