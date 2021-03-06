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

import com.testing26thjuly_.db123testing.Form;

/**
 * ServiceImpl object for domain model class Form.
 *
 * @see Form
 */
@Service("DB123Testing.FormService")
public class FormServiceImpl implements FormService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FormServiceImpl.class);

    @Autowired
    @Qualifier("DB123Testing.FormDao")
    private WMGenericDao<Form, String> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Form, String> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "DB123TestingTransactionManager")
    @Override
	public Form create(Form form) {
        LOGGER.debug("Creating a new Form with information: {}", form);
        return this.wmGenericDao.create(form);
    }

	@Transactional(readOnly = true, value = "DB123TestingTransactionManager")
	@Override
	public Form getById(String formId) throws EntityNotFoundException {
        LOGGER.debug("Finding Form by id: {}", formId);
        Form form = this.wmGenericDao.findById(formId);
        if (form == null){
            LOGGER.debug("No Form found with id: {}", formId);
            throw new EntityNotFoundException(String.valueOf(formId));
        }
        return form;
    }

	@Transactional(rollbackFor = EntityNotFoundException.class, value = "DB123TestingTransactionManager")
	@Override
	public Form update(Form form) throws EntityNotFoundException {
        LOGGER.debug("Updating Form with information: {}", form);
        this.wmGenericDao.update(form);

        String formId = form.getId();

        return this.wmGenericDao.findById(formId);
    }

    @Transactional(value = "DB123TestingTransactionManager")
	@Override
	public Form delete(String formId) throws EntityNotFoundException {
        LOGGER.debug("Deleting Form with id: {}", formId);
        Form deleted = this.wmGenericDao.findById(formId);
        if (deleted == null) {
            LOGGER.debug("No Form found with id: {}", formId);
            throw new EntityNotFoundException(String.valueOf(formId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "DB123TestingTransactionManager")
	@Override
	public Page<Form> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Forms");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "DB123TestingTransactionManager")
    @Override
    public Page<Form> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Forms");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "DB123TestingTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service DB123Testing for table Form to {} format", exportType);
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
    public Page<Form> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable) {
        LOGGER.debug("Fetching all associated");
        return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
    }
}

