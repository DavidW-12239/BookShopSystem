package com.example.book.dao.impl;

import com.example.book.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {

    private QueryRunner queryRunner = new QueryRunner();

    /**
     *
     * @param sql
     * @param args
     * @return
     */
    public int update(String sql, Object...args){
        Connection con = JdbcUtils.getConnection();
        try {
            return queryRunner.update(con, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(con);
        }
        return -1;
    }

    public <T> T queryForOne(Class<T> type, String sql, Object...args){
        Connection con = JdbcUtils.getConnection();
        try {
            return queryRunner.query(con, sql, new BeanHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(con);
        }
        return null;
    }

    public <T> List<T> queryForList(Class<T> type, String sql, Object...args){
        Connection con = JdbcUtils.getConnection();
        try {
            return queryRunner.query(con, sql, new BeanListHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(con);
        }
        return null;
    }

    public Object queryForSingleValue(String sql, Object...args){
        Connection con = JdbcUtils.getConnection();
        try {
            queryRunner.query(con, sql, new ScalarHandler(), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(con);
        }
        return null;
    }
}
