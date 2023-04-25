package me.songjy.generator.config;

import cn.hutool.core.collection.CollUtil;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GeneratorConfig {

    /**
     * 创建修改时间和人的列名称
     */
    public static final Set<String> CREATE_TIME_NAMES = CollUtil.newHashSet("created_time", "crt_time", "create_time");
    public static final Set<String> CREATE_BY_NAMES = CollUtil.newHashSet("created_by", "crt_by", "create_by");
    public static final Set<String> UPDATE_TIME_NAMES = CollUtil.newHashSet("updated_time", "upt_time", "update_time");
    public static final Set<String> UPDATE_BY_NAMES = CollUtil.newHashSet("updated_by", "upt_by", "update_by");
    public static final Set<String> CU_REQUEST_IGNORE_FIELD =
            Stream.of(CREATE_TIME_NAMES, CREATE_BY_NAMES, UPDATE_TIME_NAMES, UPDATE_BY_NAMES,
                            CollUtil.newHashSet("is_delete","is_del","owner_id","data_scope")
                    )
                    .flatMap(Collection::stream).collect(Collectors.toSet());

}
