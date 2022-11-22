package com.ta.operations.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ta.operations.model.DBModel;



@Repository
public class OperationService implements DBRepository {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Override
  public int save(DBModel DBModel) {
    return jdbcTemplate.update("INSERT INTO KALEESWARAN_AGENTS VALUES(?,?,?)",
        new Object[] { DBModel.getAgentCode(), DBModel.getAgentName(), DBModel.getworkingArea(),DBModel.getphoneNo(),DBModel.getCountry() });
  }

  @Override
  public int update(DBModel DBModel) {
    return jdbcTemplate.update("UPDATE KALEESWARAN_AGENTS SET AGENT_CODE=?,WORKING_AREA=?,PHONE_NO=?,COUNTRY=? WHERE AGENT_NAME=?",
        new Object[] { DBModel.getAgentCode(), DBModel.getworkingArea(),DBModel.getphoneNo(),DBModel.getCountry(), DBModel.getAgentName() });
  }

  @Override
  public DBModel findByCode(String agentcode) {
    try {
      DBModel DBModel = jdbcTemplate.queryForObject("SELECT * FROM KALEESWARAN_AGENTS WHERE AGENT_CODE=?",
          BeanPropertyRowMapper.newInstance(DBModel.class), agentcode);

      return DBModel;
    } catch (IncorrectResultSizeDataAccessException e) {
      return null;
    }
  }

  @Override
  public int deleteByCode(String agentCode) {
    return jdbcTemplate.update("DELETE FROM KALEESWARAN_AGENTS WHERE AGENT_CODE=?", agentCode);
  }

  @Override
  public List<DBModel> findAll() {
    return jdbcTemplate.query("SELECT * from KALEESWARAN_AGENTS", BeanPropertyRowMapper.newInstance(DBModel.class));
  }

  @Override
  public List<DBModel> findByWorkArea(String area) {
    return jdbcTemplate.query("SELECT * from KALEESWARAN_AGENTS WHERE WORKING_AREA=?",
        BeanPropertyRowMapper.newInstance(DBModel.class), area);
  }

  @Override
  public List<DBModel> findByAgentName(String agentName) {
    String q = "SELECT * from KALEESWARAN_AGENTS WHERE AGENT_NAME LIKE '%" + agentName + "%'";

    return jdbcTemplate.query(q, BeanPropertyRowMapper.newInstance(DBModel.class));
  }

  @Override
  public int deleteAll() {
    return jdbcTemplate.update("DELETE from KALEESWARAN_AGENTS");
  }
}
