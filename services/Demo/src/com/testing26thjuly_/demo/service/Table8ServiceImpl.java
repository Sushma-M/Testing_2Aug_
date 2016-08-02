/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/

package com.testing26thjuly_.demo.service;

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

import com.testing26thjuly_.demo.Table8;

/**
 * ServiceImpl object for domain model class Table8.
 *
 * @see Table8
 */
@Service("Demo.Table8Service")
public class Table8ServiceImpl implements Table8Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Table8ServiceImpl.class);

    @Autowired
    @Qualifier("Demo.Table8Dao")
    private WMGenericDao<Table8, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Table8, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "DemoTransactionManager")
    @Override
	public Table8 create(Table8 table8) {
        LOGGER.debug("Creating a new Table8 with information: {}", table8);
        return this.wmGenericDao.create(table8);
    }

	@Transactional(readOnly = true, value = "DemoTransactionManager")
	@Override
	public Table8 getById(Integer table8Id) throws EntityNotFoundException {
        LOGGER.debug("Finding Table8 by id: {}", table8Id);
        Table8 table8 = this.wmGenericDao.findById(table8Id);
        if (table8 == null){
            LOGGER.debug("No Table8 found with id: {}", table8Id);
            throw new EntityNotFoundException(String.valueOf(table8Id));
        }
        return table8;
    }

	@Transactional(rollbackFor = EntityNotFoundException.class, value = "DemoTransactionManager")
	@Override
	public Table8 update(Table8 table8) throws EntityNotFoundException {
        LOGGER.debug("Updating Table8 with information: {}", table8);
        this.wmGenericDao.update(table8);

        Integer table8Id = table8.getId();

        return this.wmGenericDao.findById(table8Id);
    }

    @Transactional(value = "DemoTransactionManager")
	@Override
	public Table8 delete(Integer table8Id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Table8 with id: {}", table8Id);
        Table8 deleted = this.wmGenericDao.findById(table8Id);
        if (deleted == null) {
            LOGGER.debug("No Table8 found with id: {}", table8Id);
            throw new EntityNotFoundException(String.valueOf(table8Id));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "DemoTransactionManager")
	@Override
	public Page<Table8> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Table8s");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "DemoTransactionManager")
    @Override
    public Page<Table8> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Table8s");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "DemoTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service Demo for table Table8 to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "DemoTransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "DemoTransactionManager")
    @SuppressWarnings("unchecked")
	@Override
    public Page<Table8> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable) {
        LOGGER.debug("Fetching all associated");
        return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
    }
}

