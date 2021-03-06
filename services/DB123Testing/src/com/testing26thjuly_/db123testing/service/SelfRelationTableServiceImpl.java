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

import com.testing26thjuly_.db123testing.SelfRelationTable;

/**
 * ServiceImpl object for domain model class SelfRelationTable.
 *
 * @see SelfRelationTable
 */
@Service("DB123Testing.SelfRelationTableService")
public class SelfRelationTableServiceImpl implements SelfRelationTableService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SelfRelationTableServiceImpl.class);

    @Autowired
    @Qualifier("DB123Testing.SelfRelationTableDao")
    private WMGenericDao<SelfRelationTable, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<SelfRelationTable, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "DB123TestingTransactionManager")
    @Override
	public SelfRelationTable create(SelfRelationTable selfrelationtable) {
        LOGGER.debug("Creating a new SelfRelationTable with information: {}", selfrelationtable);
        return this.wmGenericDao.create(selfrelationtable);
    }

	@Transactional(readOnly = true, value = "DB123TestingTransactionManager")
	@Override
	public SelfRelationTable getById(Integer selfrelationtableId) throws EntityNotFoundException {
        LOGGER.debug("Finding SelfRelationTable by id: {}", selfrelationtableId);
        SelfRelationTable selfrelationtable = this.wmGenericDao.findById(selfrelationtableId);
        if (selfrelationtable == null){
            LOGGER.debug("No SelfRelationTable found with id: {}", selfrelationtableId);
            throw new EntityNotFoundException(String.valueOf(selfrelationtableId));
        }
        return selfrelationtable;
    }

	@Transactional(rollbackFor = EntityNotFoundException.class, value = "DB123TestingTransactionManager")
	@Override
	public SelfRelationTable update(SelfRelationTable selfrelationtable) throws EntityNotFoundException {
        LOGGER.debug("Updating SelfRelationTable with information: {}", selfrelationtable);
        this.wmGenericDao.update(selfrelationtable);

        Integer selfrelationtableId = selfrelationtable.getId();

        return this.wmGenericDao.findById(selfrelationtableId);
    }

    @Transactional(value = "DB123TestingTransactionManager")
	@Override
	public SelfRelationTable delete(Integer selfrelationtableId) throws EntityNotFoundException {
        LOGGER.debug("Deleting SelfRelationTable with id: {}", selfrelationtableId);
        SelfRelationTable deleted = this.wmGenericDao.findById(selfrelationtableId);
        if (deleted == null) {
            LOGGER.debug("No SelfRelationTable found with id: {}", selfrelationtableId);
            throw new EntityNotFoundException(String.valueOf(selfrelationtableId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "DB123TestingTransactionManager")
	@Override
	public Page<SelfRelationTable> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all SelfRelationTables");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "DB123TestingTransactionManager")
    @Override
    public Page<SelfRelationTable> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all SelfRelationTables");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "DB123TestingTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service DB123Testing for table SelfRelationTable to {} format", exportType);
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
    public Page<SelfRelationTable> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable) {
        LOGGER.debug("Fetching all associated");
        return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
    }
}

