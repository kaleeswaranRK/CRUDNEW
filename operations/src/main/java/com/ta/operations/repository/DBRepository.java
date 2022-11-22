package com.ta.operations.repository;

import java.util.List;

import com.ta.operations.model.DBModel;

public interface DBRepository {
  int save(DBModel book);

  int update(DBModel book);

  DBModel findByCode(String agentCode);

  int deleteByCode(String agentCode);

  List<DBModel> findAll();

  List<DBModel> findByWorkArea(String area);

  List<DBModel> findByAgentName(String agentName);

  int deleteAll();
}