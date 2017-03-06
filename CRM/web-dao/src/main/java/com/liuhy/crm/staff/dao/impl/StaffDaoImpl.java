package com.liuhy.crm.staff.dao.impl;

import com.liuhy.crm.post.dao.PostDao;
import com.liuhy.crm.staff.dao.StaffDao;
import com.liuhy.crm.staff.domain.CrmStaff;
import com.liuhy.crm.utils.MD5Utils;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class StaffDaoImpl extends JdbcDaoSupport implements StaffDao {

    private PostDao postDao;

    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }

    @Override
    public boolean add(CrmStaff staff) {
        return false;
    }

    @Override
    public boolean update(CrmStaff staff) {
        this.getJdbcTemplate().update("UPDATE crm_staff SET loginName=?,staffName=?,gender=?,onDutyDate=?,postId=? WHERE staffId=?",
                staff.getLoginName(), staff.getStaffName(), staff.getGender(), staff.getOnDutyDate(), staff.getPost().getPostId(), staff.getStaffId());

        return true;
    }

    @Override
    public boolean delete(CrmStaff staff) {
        return false;
    }

    @Override
    public CrmStaff findByName(String staffName) {
        return null;
    }

    /*
    * 根据传来员工的登录名和密码判断其是否存在
    * */
    @Override
    public boolean isExists(CrmStaff staff) {
        // 获取加密后的密码
        String loginPwd = MD5Utils.getMD5Value(staff.getLoginPwd());

        Integer count = this.getJdbcTemplate()
                .queryForObject("SELECT COUNT(*) FROM crm_staff WHERE loginName=? AND loginPwd=?",
                        new String[]{staff.getLoginName(), loginPwd},
                        Integer.class);
        if (1 == count) {
            return true;
        }
        return false;
    }

    /*
    * 查询所有员工
    * 页面上需要展示的不在crm_staff表中的信息：
    *   1.crm_post:postName         根据crm_staff中的postId查询，需要postDao
    *   2.crm_department:depName    根据crm_post中的depId查询，需要departmentDao
    * */
    @Override
    public List<CrmStaff> findAll() {
        List<CrmStaff> allStaff = new ArrayList<CrmStaff>(0);

        // 返回 List<Map<String,Object>>
        List result = this.getJdbcTemplate().queryForList("SELECT * FROM crm_staff");
        for (int i = 0; i < result.size(); i++) {
            //
            Map<String, Object> row = (Map<String, Object>) result.get(i);
            CrmStaff staff = new CrmStaff();
            staff.setStaffId((String) row.get("staffId"));
            staff.setLoginName((String) row.get("loginName"));
            staff.setLoginPwd((String) row.get("loginPwd"));
            staff.setGender((String) row.get("gender"));
            staff.setStaffName((String) row.get("staffName"));

            Date date = new Date(((Timestamp) row.get("onDutyDate")).getTime());
            staff.setOnDutyDate(date);

            String postId = (String) row.get("postId");
            staff.setPost(postDao.findById(postId));

            allStaff.add(staff);
        }

        return allStaff;
    }

    @Override
    public CrmStaff findById(String id) {
        return this.getJdbcTemplate()
                .queryForObject("SELECT * FROM crm_staff WHERE staffId=?",
                        (rs, rowNum) -> {
                            CrmStaff staff = new CrmStaff();
                            staff.setStaffId(rs.getString("staffId"));
                            staff.setLoginName(rs.getString("loginName"));
                            staff.setLoginPwd(rs.getString("loginPwd"));
                            staff.setGender(rs.getString("gender"));
                            staff.setStaffName(rs.getString("staffName"));

                            Date date = new Date(rs.getDate("onDutyDate").getTime());
                            staff.setOnDutyDate(date);

                            String postId = rs.getString("postId");
                            staff.setPost(postDao.findById(postId));

                            return staff;
                        },
                        id);
    }
}
