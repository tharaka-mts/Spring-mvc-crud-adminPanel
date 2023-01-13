package com.adminPanel.dao;

import com.adminPanel.beans.Doctor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DoctorDao {
    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public int count(){
        String countSql = "SELECT COUNT(*) FROM doctors";
        return template.queryForObject(countSql, Integer.class);
    }


    public boolean addDoctor(Doctor doctor){
        String add = "INSERT INTO doctors(firstname, lastname, email, contact) VALUES('"+ doctor.getFirstname()+"','"+ doctor.getLastname()+"','"+ doctor.getEmail()+"','"+ doctor.getContact()+"')";
        return template.update(add) > 0;
    }

    public boolean deleteDoctor(int id){
        String delete = "DELETE FROM doctors WHERE id="+id+"";
        return template.update(delete) > 0;
    }

    public Doctor getDoctorById(int id){
        String sql="SELECT * FROM doctors WHERE id=?";
        return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Doctor>(Doctor.class));
    }

    public int update(Doctor doctor){
        String sql="UPDATE doctors SET firstname='"+doctor.getFirstname()+"', lastname='"+doctor.getLastname()+"',email='"+doctor.getEmail()+"',contact='"+doctor.getContact()+"' WHERE id="+doctor.getId()+"";
        return template.update(sql);
    }

    public List<Doctor> getDoctors(){
        return template.query("SELECT * FROM doctors",new RowMapper<Doctor>(){
            public Doctor mapRow(ResultSet rs, int row) throws SQLException {
                Doctor doctor = new Doctor();
                doctor.setId(rs.getInt(1));
                doctor.setFirstname(rs.getString(2));
                doctor.setLastname(rs.getString(3));
                doctor.setEmail(rs.getString(4));
                doctor.setContact(rs.getString(5));
                return doctor;
            }
        });
    }
}
