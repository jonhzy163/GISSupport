package com.gis3c.dao.impl;

import com.gis3c.dao.PostGISDao;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;

@Repository
public class PostGISDaoImpl extends SqlSessionDaoSupport implements PostGISDao {
    @Resource(name="sqlSessionFactory_GIS")
    private SqlSessionFactory sqlSessionFactory;
    @PostConstruct
    public void injectSessionFactory(){
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public void CommonCreateTable(Map<String,Object> tableStructure){
        getSqlSession().update("PostGISSql.commonCreateTable",tableStructure);
    }
    @Override
    public void CreateSpatialIndex(String tableName){
        getSqlSession().update("PostGISSql.createSpatialIndex",tableName);
    }
}
