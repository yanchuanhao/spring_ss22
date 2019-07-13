package com.qf.dao.impl;

import com.qf.dao.UserDao;
import com.qf.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public User query(int id) {
        String sql = "select * from user where id=?";
        User user = jdbcTemplate.queryForObject(sql, new UserMapper(), id);
        return user;
    }

    class UserMapper implements RowMapper<User>{

        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            return user;
        }
    }
}
