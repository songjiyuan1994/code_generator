package me.songjy.generator.core.db;

import lombok.Data;

@Data
public class ColumnSchema {

    private String tableName;

    private String columName;

    private String dataType;

    private String columKey;

    private String extra;

    private String columComment;
}
