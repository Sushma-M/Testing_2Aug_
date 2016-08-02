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

import com.testing26thjuly_.demo.Table9;
import com.testing26thjuly_.demo.Table9Id;

/**
 * ServiceImpl object for domain model class Table9.
 *
 * @see Table9
 */
@Service("Demo.Table9Service")
public class Table9ServiceImpl implements Table9Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Table9ServiceImpl.class);

    @Autowired
    @Qualifier("Demo.Table9Dao")
    private WMGenericDao<Table9, Table9Id> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Table9, Table9Id> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "DemoTransactionManager")
    @Override
	public Table9 create(Table9 table9) {
        LOGGER.debug("Creating a new Table9 with information: {}", table9);
        return this.wmGenericDao.create(table9);
    }

	@Transactional(readOnly = true, value = "DemoTransactionManager")
	@Override
	public Table9 getById(Table9Id table9Id) throws EntityNotFoundException {
        LOGGER.debug("Finding Table9 by id: {}", table9Id);
        Table9 table9 = this.wmGenericDao.findById(table9Id);
        if (table9 == null){
            LOGGER.debug("No Table9 found with id: {}", table9Id);
            throw new EntityNotFoundException(String.valueOf(table9Id));
        }
        return table9;
    }

	@Transactional(rollbackFor = EntityNotFoundException.class, value = "DemoTransactionManager")
	@Override
	public Table9 update(Table9 table9) throws EntityNotFoundException {
        LOGGER.debug("Updating Table9 with information: {}", table9);
        this.wmGenericDao.update(table9);

        Table9Id table9Id = new Table9Id();
        table9Id.setId(table9.getId());
        table9Id.setColumn2(table9.getColumn2());

        return this.wmGenericDao.findById(table9Id);
    }

    @Transactional(value = "DemoTransactionManager")
	@Override
	public Table9 delete(Table9Id table9Id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Table9 with id: {}", table9Id);
        Table9 deleted = this.wmGenericDao.findById(table9Id);
        if (deleted == null) {
            LOGGER.debug("No Table9 found with id: {}", table9Id);
            throw new EntityNotFoundException(String.valueOf(table9Id));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "DemoTransactionManager")
	@Override
	public Page<Table9> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Table9s");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "DemoTransactionManager")
    @Override
    public Page<Table9> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Table9s");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "DemoTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service Demo for table Table9 to {} format", exportType);
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
    public Page<Table9> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable) {
        LOGGER.debug("Fetching all associated");
        return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
    }
}
