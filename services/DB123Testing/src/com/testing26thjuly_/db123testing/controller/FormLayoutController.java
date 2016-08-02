/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing26thjuly_.db123testing.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.testing26thjuly_.db123testing.FormLayout;
import com.testing26thjuly_.db123testing.service.FormLayoutService;
import com.wordnik.swagger.annotations.*;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

/**
 * Controller object for domain model class FormLayout.
 * @see FormLayout
 */
@RestController("DB123Testing.FormLayoutController")
@RequestMapping("/DB123Testing/FormLayout")
@Api(description = "Exposes APIs to work with FormLayout resource.", value = "FormLayoutController")
public class FormLayoutController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FormLayoutController.class);

    @Autowired
    @Qualifier("DB123Testing.FormLayoutService")
    private FormLayoutService formLayoutService;

    /**
     * @deprecated Use {@link #findFormLayouts(String)} instead.
     */
    @Deprecated
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of FormLayout instances matching the search criteria.")
    public Page<FormLayout> findFormLayouts(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering FormLayouts list");
        return formLayoutService.findAll(queryFilters, pageable);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of FormLayout instances matching the search criteria.")
    public Page<FormLayout> findFormLayouts(@RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering FormLayouts list");
        return formLayoutService.findAll(query, pageable);
    }

    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Returns downloadable file for the data.")
    public Downloadable exportFormLayouts(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return formLayoutService.export(exportType, query, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service FormLayoutService instance
	 */
    protected void setFormLayoutService(FormLayoutService service) {
        this.formLayoutService = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Creates a new FormLayout instance.")
    public FormLayout createFormLayout(@RequestBody FormLayout formlayout) {
        LOGGER.debug("Create FormLayout with information: {}", formlayout);
        formlayout = formLayoutService.create(formlayout);
        LOGGER.debug("Created FormLayout with information: {}", formlayout);
        return formlayout;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the total count of FormLayout instances.")
    public Long countFormLayouts(@RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting FormLayouts");
        return formLayoutService.count(query);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the FormLayout instance associated with the given id.")
    public FormLayout getFormLayout(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting FormLayout with id: {}", id);
        FormLayout foundFormLayout = formLayoutService.getById(id);
        LOGGER.debug("FormLayout details with id: {}", foundFormLayout);
        return foundFormLayout;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the FormLayout instance associated with the given id.")
    public FormLayout editFormLayout(@PathVariable(value = "id") Integer id, @RequestBody FormLayout formlayout) throws EntityNotFoundException {
        LOGGER.debug("Editing FormLayout with id: {}", formlayout.getId());
        formlayout.setId(id);
        formlayout = formLayoutService.update(formlayout);
        LOGGER.debug("FormLayout details with id: {}", formlayout);
        return formlayout;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Deletes the FormLayout instance associated with the given id.")
    public boolean deleteFormLayout(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting FormLayout with id: {}", id);
        FormLayout deletedFormLayout = formLayoutService.delete(id);
        return deletedFormLayout != null;
    }
}
