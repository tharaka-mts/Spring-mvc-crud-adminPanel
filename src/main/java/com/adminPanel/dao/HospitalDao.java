package com.adminPanel.dao;
import com.adminPanel.beans.Hospital;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class HospitalDao {
    JdbcTemplate template;
    
    public void setTemplate(JdbcTemplate template){
        this.template = template;
    }

    public boolean addHospital(Hospital hospital){
        String add = "INSERT INTO hospitals(name, email, contact) VALUES('"+ hospital.getName()+"','"+ hospital.getEmail()+"','"+ hospital.getContact()+"')";
        return template.update(add) > 0;
    }

    public boolean deleteHospital(int id){
        String delete = "DELETE FROM hospitals WHERE id="+id+"";
        return template.update(delete) > 0;
    }

    public List<Hospital> getHospital(){
        return template.query("SELECT * FROM hospitals",new RowMapper<Hospital>(){
            public Hospital mapRow(ResultSet rs, int row) throws SQLException {
                Hospital hospital = new Hospital();
                hospital.setId(rs.getInt(1));
                hospital.setName(rs.getString(2));
                hospital.setEmail(rs.getString(3));
                hospital.setContact(rs.getString(4));
                return hospital;
            }
        });
    }
}
