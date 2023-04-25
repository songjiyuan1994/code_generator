package me.songjy.generator.core;

import me.songjy.generator.config.Constants;
import me.songjy.generator.config.DataType;
import me.songjy.generator.config.GeneratorConfig;
import me.songjy.generator.utils.StringUtils;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Columns {

    private String javaField;

    private String columnComment;

    private String columnName;

    private String columnType;

    private String javaType;

    private String columKey;

    private String extra;

    public boolean isPkColumn() {
        return Constants.PK.equals(columKey);
    }

    public boolean isUniqueColumn() {
        return Constants.UK.equals(columKey);
    }

    public boolean isAutoInc() {
        return Constants.AUTO_INCREMENT.equals(extra);
    }

    public boolean isCreatedBy() {
        return GeneratorConfig.CREATE_BY_NAMES.contains(this.columnName);
    }

    public boolean isLastModifiedBy() {
        return GeneratorConfig.UPDATE_BY_NAMES.contains(this.columnName);
    }

    public boolean isJson() {
        return columnType.equals(DataType.JSON.getColumn());
    }

    public boolean isString() {
        return DataType.getByColumnDataType(columnType).isString();
    }

    public boolean isTime() {
        return DataType.getByColumnDataType(columnType).isTime();
    }

    public boolean isNum() {
        return DataType.getByColumnDataType(columnType).isNum();
    }

    public boolean containName() {
        return columnName.toLowerCase().contains("name");
    }

    public String getCapJavaField() {
        return StringUtils.capitalize(javaField);
    }

    public boolean cuIgnore() {
        return GeneratorConfig.CU_REQUEST_IGNORE_FIELD.contains(columnName);
    }
}
