/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/

package com.testing26thjuly_.wmstudio.service;

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

import com.testing26thjuly_.wmstudio.Table65;
import com.testing26thjuly_.wmstudio.Table65Id;

/**
 * ServiceImpl object for domain model class Table65.
 *
 * @see Table65
 */
@Service("WMSTUDIO.Table65Service")
public class Table65ServiceImpl implements Table65Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Table65ServiceImpl.class);

    @Autowired
    @Qualifier("WMSTUDIO.Table65Dao")
    private WMGenericDao<Table65, Table65Id> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Table65, Table65Id> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "WMSTUDIOTransactionManager")
    @Override
	public Table65 create(Table65 table65) {
        LOGGER.debug("Creating a new Table65 with information: {}", table65);
        return this.wmGenericDao.create(table65);
    }

	@Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public Table65 getById(Table65Id table65Id) throws EntityNotFoundException {
        LOGGER.debug("Finding Table65 by id: {}", table65Id);
        Table65 table65 = this.wmGenericDao.findById(table65Id);
        if (table65 == null){
            LOGGER.debug("No Table65 found with id: {}", table65Id);
            throw new EntityNotFoundException(String.valueOf(table65Id));
        }
        return table65;
    }

	@Transactional(rollbackFor = EntityNotFoundException.class, value = "WMSTUDIOTransactionManager")
	@Override
	public Table65 update(Table65 table65) throws EntityNotFoundException {
        LOGGER.debug("Updating Table65 with information: {}", table65);
        this.wmGenericDao.update(table65);

        Table65Id table65Id = new Table65Id();
        table65Id.setStringCol(table65.getStringCol());
        table65Id.setId(table65.getId());
        table65Id.setShortCol(table65.getShortCol());

        return this.wmGenericDao.findById(table65Id);
    }

    @Transactional(value = "WMSTUDIOTransactionManager")
	@Override
	public Table65 delete(Table65Id table65Id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Table65 with id: {}", table65Id);
        Table65 deleted = this.wmGenericDao.findById(table65Id);
        if (deleted == null) {
            LOGGER.debug("No Table65 found with id: {}", table65Id);
            throw new EntityNotFoundException(String.valueOf(table65Id));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public Page<Table65> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Table65s");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Page<Table65> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Table65s");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service WMSTUDIO for table Table65 to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @SuppressWarnings("unchecked")
	@Override
    public Page<Table65> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable) {
        LOGGER.debug("Fetching all associated");
        return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
    }
}

