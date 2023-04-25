package me.songjy.generator.core;

import lombok.Builder;
import lombok.Data;

import java.util.HashSet;
import java.util.List;

@Data
@Builder
public class TemplateParam {

    private String className;

    private String tableName;

    private String tableComment;

    private HashSet<String> importList;

    private boolean hasCreatedBy = false;

    private boolean hasLastModifiedBy = false;

    private Columns dynamicInsertColumn;

    private Columns dynamicUpdateColumn;

    private String logicDelColumn;

    private boolean hasLogicDelColumn = false;

    private List<Columns> columns;

    private List<Columns> uniqueColumns;

    private String pkColumn;

    private String pkFieldName;

    private String pkFieldNameCap;

}
