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

import com.testing26thjuly_.db123testing.Urtable1;

/**
 * ServiceImpl object for domain model class Urtable1.
 *
 * @see Urtable1
 */
@Service("DB123Testing.Urtable1Service")
public class Urtable1ServiceImpl implements Urtable1Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Urtable1ServiceImpl.class);

    @Autowired
    @Qualifier("DB123Testing.Urtable1Dao")
    private WMGenericDao<Urtable1, String> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Urtable1, String> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "DB123TestingTransactionManager")
    @Override
	public Urtable1 create(Urtable1 urtable1) {
        LOGGER.debug("Creating a new Urtable1 with information: {}", urtable1);
        return this.wmGenericDao.create(urtable1);
    }

	@Transactional(readOnly = true, value = "DB123TestingTransactionManager")
	@Override
	public Urtable1 getById(String urtable1Id) throws EntityNotFoundException {
        LOGGER.debug("Finding Urtable1 by id: {}", urtable1Id);
        Urtable1 urtable1 = this.wmGenericDao.findById(urtable1Id);
        if (urtable1 == null){
            LOGGER.debug("No Urtable1 found with id: {}", urtable1Id);
            throw new EntityNotFoundException(String.valueOf(urtable1Id));
        }
        return urtable1;
    }

	@Transactional(rollbackFor = EntityNotFoundException.class, value = "DB123TestingTransactionManager")
	@Override
	public Urtable1 update(Urtable1 urtable1) throws EntityNotFoundException {
        LOGGER.debug("Updating Urtable1 with information: {}", urtable1);
        this.wmGenericDao.update(urtable1);

        String urtable1Id = urtable1.getId();

        return this.wmGenericDao.findById(urtable1Id);
    }

    @Transactional(value = "DB123TestingTransactionManager")
	@Override
	public Urtable1 delete(String urtable1Id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Urtable1 with id: {}", urtable1Id);
        Urtable1 deleted = this.wmGenericDao.findById(urtable1Id);
        if (deleted == null) {
            LOGGER.debug("No Urtable1 found with id: {}", urtable1Id);
            throw new EntityNotFoundException(String.valueOf(urtable1Id));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "DB123TestingTransactionManager")
	@Override
	public Page<Urtable1> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Urtable1s");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "DB123TestingTransactionManager")
    @Override
    public Page<Urtable1> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Urtable1s");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "DB123TestingTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service DB123Testing for table Urtable1 to {} format", exportType);
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
    public Page<Urtable1> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable) {
        LOGGER.debug("Fetching all associated");
        return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
    }
}

