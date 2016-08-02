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

import com.testing26thjuly_.db123testing.UsersTable;

/**
 * ServiceImpl object for domain model class UsersTable.
 *
 * @see UsersTable
 */
@Service("DB123Testing.UsersTableService")
public class UsersTableServiceImpl implements UsersTableService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsersTableServiceImpl.class);

    @Autowired
    @Qualifier("DB123Testing.UsersTableDao")
    private WMGenericDao<UsersTable, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<UsersTable, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "DB123TestingTransactionManager")
    @Override
	public UsersTable create(UsersTable userstable) {
        LOGGER.debug("Creating a new UsersTable with information: {}", userstable);
        return this.wmGenericDao.create(userstable);
    }

	@Transactional(readOnly = true, value = "DB123TestingTransactionManager")
	@Override
	public UsersTable getById(Integer userstableId) throws EntityNotFoundException {
        LOGGER.debug("Finding UsersTable by id: {}", userstableId);
        UsersTable userstable = this.wmGenericDao.findById(userstableId);
        if (userstable == null){
            LOGGER.debug("No UsersTable found with id: {}", userstableId);
            throw new EntityNotFoundException(String.valueOf(userstableId));
        }
        return userstable;
    }

	@Transactional(rollbackFor = EntityNotFoundException.class, value = "DB123TestingTransactionManager")
	@Override
	public UsersTable update(UsersTable userstable) throws EntityNotFoundException {
        LOGGER.debug("Updating UsersTable with information: {}", userstable);
        this.wmGenericDao.update(userstable);

        Integer userstableId = userstable.getUserId();

        return this.wmGenericDao.findById(userstableId);
    }

    @Transactional(value = "DB123TestingTransactionManager")
	@Override
	public UsersTable delete(Integer userstableId) throws EntityNotFoundException {
        LOGGER.debug("Deleting UsersTable with id: {}", userstableId);
        UsersTable deleted = this.wmGenericDao.findById(userstableId);
        if (deleted == null) {
            LOGGER.debug("No UsersTable found with id: {}", userstableId);
            throw new EntityNotFoundException(String.valueOf(userstableId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "DB123TestingTransactionManager")
	@Override
	public Page<UsersTable> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all UsersTables");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "DB123TestingTransactionManager")
    @Override
    public Page<UsersTable> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all UsersTables");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "DB123TestingTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service DB123Testing for table UsersTable to {} format", exportType);
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
    public Page<UsersTable> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable) {
        LOGGER.debug("Fetching all associated");
        return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
    }
}
