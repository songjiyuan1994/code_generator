package me.songjy.generator.config;

import lombok.Getter;

@Getter
public enum DataType {

    /**
     * 字符串类型
     */
    VARCHAR("varchar", "String", null),
    TEXT("text", "String", null),
    TINYTEXT("tinytext", "String", null),
    MEDIUMTEXT("mediumtext", "String", null),
    LONGTEXT("longtext", "String", null),

    /**
     * 数字类型
     */
    BIGINT("bigint", "Long", null),
    MEDIUMINT("mediumint", "Long", null),
    INT("int", "Integer", null),
    SMALLINT("smallint", "Integer", null),
    TINYINT("tinyint", "Integer", null),

    /**
     * 时间类型
     */
    TIME("time", "LocalTime", "java.time.LocalTime"),
    DATE("date", "LocalDate", "java.time.LocalDate"),
    DATETIME("datetime", "LocalDateTime", "java.time.LocalDateTime"),
    TIMESTAMP("timestamp", "LocalDateTime", "java.time.LocalDateTime"),

    /**
     * 其他类型
     */
    JSON("json", "JsonNode", "com.fasterxml.jackson.databind.JsonNode"),

    ;

    private String column;

    private String field;

    private String fieldImport;

    DataType(String column, String field, String fi) {
        this.column = column;
        this.field = field;
        this.fieldImport = fi;
    }

    public static DataType getByColumnDataType(String columnDataType) {
        for (DataType dataType : DataType.values()) {
            if (dataType.column.equals(columnDataType)) {
                return dataType;
            }
        }
        throw new IllegalArgumentException("未知的数据类型:" + columnDataType);
    }

    public boolean isString() {
        return this == VARCHAR || this == TINYTEXT || this == MEDIUMINT || this == LONGTEXT || this == TEXT;
    }

    public boolean isTime() {
        return this == DATE || this == TIME || this == DATETIME || this == TIMESTAMP;
    }

    public boolean isNum() {
        return this == INT || this == SMALLINT || this == MEDIUMINT || this == TINYINT || this == BIGINT;
    }
}
