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

import com.testing26thjuly_.wmstudio.Table29;

/**
 * ServiceImpl object for domain model class Table29.
 *
 * @see Table29
 */
@Service("WMSTUDIO.Table29Service")
public class Table29ServiceImpl implements Table29Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Table29ServiceImpl.class);

    @Autowired
    @Qualifier("WMSTUDIO.Table29Dao")
    private WMGenericDao<Table29, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Table29, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "WMSTUDIOTransactionManager")
    @Override
	public Table29 create(Table29 table29) {
        LOGGER.debug("Creating a new Table29 with information: {}", table29);
        return this.wmGenericDao.create(table29);
    }

	@Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public Table29 getById(Integer table29Id) throws EntityNotFoundException {
        LOGGER.debug("Finding Table29 by id: {}", table29Id);
        Table29 table29 = this.wmGenericDao.findById(table29Id);
        if (table29 == null){
            LOGGER.debug("No Table29 found with id: {}", table29Id);
            throw new EntityNotFoundException(String.valueOf(table29Id));
        }
        return table29;
    }

	@Transactional(rollbackFor = EntityNotFoundException.class, value = "WMSTUDIOTransactionManager")
	@Override
	public Table29 update(Table29 table29) throws EntityNotFoundException {
        LOGGER.debug("Updating Table29 with information: {}", table29);
        this.wmGenericDao.update(table29);

        Integer table29Id = table29.getId();

        return this.wmGenericDao.findById(table29Id);
    }

    @Transactional(value = "WMSTUDIOTransactionManager")
	@Override
	public Table29 delete(Integer table29Id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Table29 with id: {}", table29Id);
        Table29 deleted = this.wmGenericDao.findById(table29Id);
        if (deleted == null) {
            LOGGER.debug("No Table29 found with id: {}", table29Id);
            throw new EntityNotFoundException(String.valueOf(table29Id));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public Page<Table29> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Table29s");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Page<Table29> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Table29s");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service WMSTUDIO for table Table29 to {} format", exportType);
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
    public Page<Table29> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable) {
        LOGGER.debug("Fetching all associated");
        return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
    }
}

