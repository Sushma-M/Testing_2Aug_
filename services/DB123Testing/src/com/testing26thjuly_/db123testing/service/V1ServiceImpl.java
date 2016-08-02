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

import com.testing26thjuly_.db123testing.V1;
import com.testing26thjuly_.db123testing.V1Id;

/**
 * ServiceImpl object for domain model class V1.
 *
 * @see V1
 */
@Service("DB123Testing.V1Service")
public class V1ServiceImpl implements V1Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(V1ServiceImpl.class);

    @Autowired
    @Qualifier("DB123Testing.V1Dao")
    private WMGenericDao<V1, V1Id> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<V1, V1Id> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

	@Transactional(readOnly = true, value = "DB123TestingTransactionManager")
	@Override
	public V1 getById(V1Id v1Id) throws EntityNotFoundException {
        LOGGER.debug("Finding V1 by id: {}", v1Id);
        V1 v1 = this.wmGenericDao.findById(v1Id);
        if (v1 == null){
            LOGGER.debug("No V1 found with id: {}", v1Id);
            throw new EntityNotFoundException(String.valueOf(v1Id));
        }
        return v1;
    }

	@Transactional(readOnly = true, value = "DB123TestingTransactionManager")
	@Override
	public Page<V1> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all V1s");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "DB123TestingTransactionManager")
    @Override
    public Page<V1> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all V1s");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "DB123TestingTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service DB123Testing for table V1 to {} format", exportType);
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
    public Page<V1> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable) {
        LOGGER.debug("Fetching all associated");
        return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
    }
}

