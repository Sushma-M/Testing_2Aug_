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

import com.testing26thjuly_.db123testing.ViewUtable2;
import com.testing26thjuly_.db123testing.ViewUtable2Id;

/**
 * ServiceImpl object for domain model class ViewUtable2.
 *
 * @see ViewUtable2
 */
@Service("DB123Testing.ViewUtable2Service")
public class ViewUtable2ServiceImpl implements ViewUtable2Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(ViewUtable2ServiceImpl.class);

    @Autowired
    @Qualifier("DB123Testing.ViewUtable2Dao")
    private WMGenericDao<ViewUtable2, ViewUtable2Id> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<ViewUtable2, ViewUtable2Id> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

	@Transactional(readOnly = true, value = "DB123TestingTransactionManager")
	@Override
	public ViewUtable2 getById(ViewUtable2Id viewutable2Id) throws EntityNotFoundException {
        LOGGER.debug("Finding ViewUtable2 by id: {}", viewutable2Id);
        ViewUtable2 viewutable2 = this.wmGenericDao.findById(viewutable2Id);
        if (viewutable2 == null){
            LOGGER.debug("No ViewUtable2 found with id: {}", viewutable2Id);
            throw new EntityNotFoundException(String.valueOf(viewutable2Id));
        }
        return viewutable2;
    }

	@Transactional(readOnly = true, value = "DB123TestingTransactionManager")
	@Override
	public Page<ViewUtable2> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all ViewUtable2s");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "DB123TestingTransactionManager")
    @Override
    public Page<ViewUtable2> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all ViewUtable2s");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "DB123TestingTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service DB123Testing for table ViewUtable2 to {} format", exportType);
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
    public Page<ViewUtable2> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable) {
        LOGGER.debug("Fetching all associated");
        return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
    }
}

