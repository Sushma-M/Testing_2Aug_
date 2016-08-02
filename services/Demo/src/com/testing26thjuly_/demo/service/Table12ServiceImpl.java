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

import com.testing26thjuly_.demo.Table12;

/**
 * ServiceImpl object for domain model class Table12.
 *
 * @see Table12
 */
@Service("Demo.Table12Service")
public class Table12ServiceImpl implements Table12Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Table12ServiceImpl.class);

    @Autowired
    @Qualifier("Demo.Table12Dao")
    private WMGenericDao<Table12, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Table12, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "DemoTransactionManager")
    @Override
	public Table12 create(Table12 table12) {
        LOGGER.debug("Creating a new Table12 with information: {}", table12);
        return this.wmGenericDao.create(table12);
    }

	@Transactional(readOnly = true, value = "DemoTransactionManager")
	@Override
	public Table12 getById(Integer table12Id) throws EntityNotFoundException {
        LOGGER.debug("Finding Table12 by id: {}", table12Id);
        Table12 table12 = this.wmGenericDao.findById(table12Id);
        if (table12 == null){
            LOGGER.debug("No Table12 found with id: {}", table12Id);
            throw new EntityNotFoundException(String.valueOf(table12Id));
        }
        return table12;
    }

	@Transactional(rollbackFor = EntityNotFoundException.class, value = "DemoTransactionManager")
	@Override
	public Table12 update(Table12 table12) throws EntityNotFoundException {
        LOGGER.debug("Updating Table12 with information: {}", table12);
        this.wmGenericDao.update(table12);

        Integer table12Id = table12.getId();

        return this.wmGenericDao.findById(table12Id);
    }

    @Transactional(value = "DemoTransactionManager")
	@Override
	public Table12 delete(Integer table12Id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Table12 with id: {}", table12Id);
        Table12 deleted = this.wmGenericDao.findById(table12Id);
        if (deleted == null) {
            LOGGER.debug("No Table12 found with id: {}", table12Id);
            throw new EntityNotFoundException(String.valueOf(table12Id));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "DemoTransactionManager")
	@Override
	public Page<Table12> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Table12s");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "DemoTransactionManager")
    @Override
    public Page<Table12> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Table12s");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "DemoTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service Demo for table Table12 to {} format", exportType);
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
    public Page<Table12> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable) {
        LOGGER.debug("Fetching all associated");
        return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
    }
}
