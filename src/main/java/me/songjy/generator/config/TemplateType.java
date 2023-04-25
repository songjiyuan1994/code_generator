package me.songjy.generator.config;

import me.songjy.generator.core.GeneratorParam;
import me.songjy.generator.utils.StringUtils;
import lombok.Getter;

@Getter
public enum TemplateType {


    PO("vm/po.java.vm", "", "PO.java"),
    DO("vm/do.java.vm", "", ".java"),
    RESPONSE("vm/rsp.java.vm", "", "Response.java"),
    REQUEST("vm/req/req.java.vm", "Query", "Request.java"),
    UNIQUE_REQUEST("vm/req/g_unique_req.java.vm", "GetByUnique", "Request.java"),
    Q_UNIQUE_REQUEST("vm/req/q_unique_req.java.vm", "QueryByUnique", "Request.java"),
    CREATE_REQUEST("vm/req/crt_req.java.vm", "Create", "Request.java"),
    UPDATE_REQUEST("vm/req/update_req.java.vm", "Update", "Request.java"),
    DELETE_REQUEST("vm/req/del_req.java.vm", "Delete", "Request.java"),
    DAO("vm/dao.java.vm", "", "DAO.java"),
    SERVICE("vm/service.java.vm", "", "Service.java"),
    SERVICEIMPL("vm/serviceimpl.java.vm", "", "ServiceImpl.java"),
    API("vm/api.java.vm", "", "Api.java"),
    ACTION("vm/action.java.vm", "", "Action.java"),


    ;


    private String templatePath;

    private String suffix;

    private String prefix;

    TemplateType(String templatePath, String prefix, String suffix) {
        this.templatePath = templatePath;
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public String getFilePath(GeneratorParam config, String className, String tableName) {
        String subPath = "";
        switch (this) {
            case PO:
                subPath = config.getPoPath();
                break;
            case DO:
                subPath = config.getDoPath();
                break;
            case RESPONSE:
                subPath = config.getRspPath();
                break;
            case REQUEST:
            case UNIQUE_REQUEST:
            case Q_UNIQUE_REQUEST:
            case CREATE_REQUEST:
            case UPDATE_REQUEST:
            case DELETE_REQUEST:
                subPath = config.getReqPath();
                break;
            case DAO:
                subPath = config.getDaoPath();
                break;
            case SERVICE:
                subPath = config.getServicePath();
                break;
            case SERVICEIMPL:
                subPath = config.getServiceImplPath();
                break;
            case API:
                subPath = config.getApiPath();
                break;
            case ACTION:
                subPath = config.getActionPath();
                break;
        }

        return config.getOutputBasePath() + StringUtils.replace(config.getBasePackage() + subPath + ".", ".", "/") + this.prefix + className + this.suffix;
    }
}
