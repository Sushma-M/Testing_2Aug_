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

import com.testing26thjuly_.demo.Table13;
import com.testing26thjuly_.demo.Table14Id;

/**
 * ServiceImpl object for domain model class Table13.
 *
 * @see Table13
 */
@Service("Demo.Table13Service")
public class Table13ServiceImpl implements Table13Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Table13ServiceImpl.class);

    @Autowired
    @Qualifier("Demo.Table13Dao")
    private WMGenericDao<Table13, Table14Id> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Table13, Table14Id> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "DemoTransactionManager")
    @Override
	public Table13 create(Table13 table13) {
        LOGGER.debug("Creating a new Table13 with information: {}", table13);
        return this.wmGenericDao.create(table13);
    }

	@Transactional(readOnly = true, value = "DemoTransactionManager")
	@Override
	public Table13 getById(Table14Id table13Id) throws EntityNotFoundException {
        LOGGER.debug("Finding Table13 by id: {}", table13Id);
        Table13 table13 = this.wmGenericDao.findById(table13Id);
        if (table13 == null){
            LOGGER.debug("No Table13 found with id: {}", table13Id);
            throw new EntityNotFoundException(String.valueOf(table13Id));
        }
        return table13;
    }

	@Transactional(rollbackFor = EntityNotFoundException.class, value = "DemoTransactionManager")
	@Override
	public Table13 update(Table13 table13) throws EntityNotFoundException {
        LOGGER.debug("Updating Table13 with information: {}", table13);
        this.wmGenericDao.update(table13);

        Table14Id table13Id = new Table14Id();
        table13Id.setId(table13.getId());
        table13Id.setColumn2(table13.getColumn2());
        table13Id.setColumn3(table13.getColumn3());

        return this.wmGenericDao.findById(table13Id);
    }

    @Transactional(value = "DemoTransactionManager")
	@Override
	public Table13 delete(Table14Id table13Id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Table13 with id: {}", table13Id);
        Table13 deleted = this.wmGenericDao.findById(table13Id);
        if (deleted == null) {
            LOGGER.debug("No Table13 found with id: {}", table13Id);
            throw new EntityNotFoundException(String.valueOf(table13Id));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "DemoTransactionManager")
	@Override
	public Page<Table13> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Table13s");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "DemoTransactionManager")
    @Override
    public Page<Table13> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Table13s");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "DemoTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service Demo for table Table13 to {} format", exportType);
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
    public Page<Table13> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable) {
        LOGGER.debug("Fetching all associated");
        return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
    }
}

