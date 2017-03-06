package com.liuhy.crm.utils;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.UUID;

public class DBUtils {
    /**
     * 生成UUID作为数据库主键
     */
    public static String generateUUID() {
        UUID uuid = UUID.randomUUID();
        String instance = uuid.toString();
        // 去掉"-"符号
        String result = instance.substring(0, 8) + instance.substring(9, 13) + instance.substring(14, 18) + instance.substring(19, 23) + instance.substring(24);
        return result;
    }

    /**
     * 查询数据库中某个表记录总数
     *
     * @param tableName 表名
     * @return 记录数
     */
    public static int getTotalRecrods(String tableName, JdbcTemplate template) {
        return template.queryForObject("SELECT COUNT(*) FROM " + tableName, Integer.class);
    }

    public static void main(String[] args) {
        System.out.println(generateUUID());
    }
}
