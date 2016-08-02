/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/

package com.testing26thjuly_.db123testing.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.file.model.Downloadable;

import com.testing26thjuly_.db123testing.TestTablename;

/**
 * ServiceImpl object for domain model class TestTablename.
 *
 * @see TestTablename
 */
@Service("DB123Testing.TestTablenameService")
public class TestTablenameServiceImpl implements TestTablenameService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestTablenameServiceImpl.class);

    @Autowired
    @Qualifier("DB123Testing.TestTablenameDao")
    private WMGenericDao<TestTablename, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<TestTablename, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "DB123TestingTransactionManager")
    @Override
	public TestTablename create(TestTablename testtablename) {
        LOGGER.debug("Creating a new TestTablename with information: {}", testtablename);
        return this.wmGenericDao.create(testtablename);
    }

	@Transactional(readOnly = true, value = "DB123TestingTransactionManager")
	@Override
	public TestTablename getById(Integer testtablenameId) throws EntityNotFoundException {
        LOGGER.debug("Finding TestTablename by id: {}", testtablenameId);
        TestTablename testtablename = this.wmGenericDao.findById(testtablenameId);
        if (testtablename == null){
            LOGGER.debug("No TestTablename found with id: {}", testtablenameId);
            throw new EntityNotFoundException(String.valueOf(testtablenameId));
        }
        return testtablename;
    }

	@Transactional(rollbackFor = EntityNotFoundException.class, value = "DB123TestingTransactionManager")
	@Override
	public TestTablename update(TestTablename testtablename) throws EntityNotFoundException {
        LOGGER.debug("Updating TestTablename with information: {}", testtablename);
        this.wmGenericDao.update(testtablename);

        Integer testtablenameId = testtablename.getId();

        return this.wmGenericDao.findById(testtablenameId);
    }

    @Transactional(value = "DB123TestingTransactionManager")
	@Override
	public TestTablename delete(Integer testtablenameId) throws EntityNotFoundException {
        LOGGER.debug("Deleting TestTablename with id: {}", testtablenameId);
        TestTablename deleted = this.wmGenericDao.findById(testtablenameId);
        if (deleted == null) {
            LOGGER.debug("No TestTablename found with id: {}", testtablenameId);
            throw new EntityNotFoundException(String.valueOf(testtablenameId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "DB123TestingTransactionManager")
	@Override
	public Page<TestTablename> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all TestTablenames");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "DB123TestingTransactionManager")
    @Override
    public Page<TestTablename> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all TestTablenames");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "DB123TestingTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service DB123Testing for table TestTablename to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "DB123TestingTransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "DB123TestingTransactionManager")
    @SuppressWarnings("unchecked")
	@Override
    public Page<TestTablename> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable) {
        LOGGER.debug("Fetching all associated");
        return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
    }
}
