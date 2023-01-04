package com.adminPanel.dao;

import com.adminPanel.beans.Doctor;
import com.adminPanel.beans.petOwner;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class petOwnerDao {
    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template){
        this.template = template;
    }

    public boolean addOwner(petOwner owner){
        String add = "INSERT INTO petowners(firstname, lastname, email, contact) VALUES('"+ owner.getFirstname()+"','"+ owner.getLastname()+"','"+ owner.getEmail()+"','"+ owner.getContact()+"')";
        return template.update(add) > 0;
    }

    public boolean deleteOwner(int id){
        String delete = "DELETE FROM petowners WHERE id="+id+"";
        return template.update(delete) > 0;
    }

    public petOwner getOwnerById(int id){
        String sql="SELECT * FROM petowners WHERE id=?";
        return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<petOwner>(petOwner.class));
    }

    public int update(petOwner owner){
        String sql="UPDATE petowners SET firstname='"+owner.getFirstname()+"', lastname='"+owner.getLastname()+"',email='"+owner.getEmail()+"',contact='"+owner.getContact()+"' WHERE id="+owner.getId()+"";
        return template.update(sql);
    }

    public List<petOwner> getOwner(){
        return template.query("SELECT * FROM petowners",new RowMapper<petOwner>(){
            public petOwner mapRow(ResultSet rs, int row) throws SQLException {
                petOwner owner = new petOwner();
                owner.setId(rs.getInt(1));
                owner.setFirstname(rs.getString(2));
                owner.setLastname(rs.getString(3));
                owner.setEmail(rs.getString(4));
                owner.setContact(rs.getString(5));
                return owner;
            }
        });
    }
}
