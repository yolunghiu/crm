package com.liuhy.crm.department.dao.impl;

import com.liuhy.crm.department.dao.DepartmentDao;
import com.liuhy.crm.department.domain.CrmDepartment;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class DepartmentDaoImpl extends JdbcDaoSupport implements DepartmentDao {

    @Override
    public boolean add(CrmDepartment department) {
        return false;
    }

    @Override
    public boolean update(CrmDepartment department) {
        return false;
    }

    @Override
    public boolean delete(CrmDepartment department) {
        return false;
    }

    @Override
    public CrmDepartment findById(String id) {
        return this.getJdbcTemplate()
                .queryForObject("SELECT * FROM crm_department WHERE depId=?",
                        (rs, rowNum) -> {
                            CrmDepartment department = new CrmDepartment();
                            department.setDepId(id);
                            department.setDepName(rs.getString("depName"));

                            return department;
                        },
                        id);
    }
}
