/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing26thjuly_.wmstudio.controller;

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
import com.testing26thjuly_.wmstudio.Composite1;
import com.testing26thjuly_.wmstudio.Composite1Id;
import com.testing26thjuly_.wmstudio.service.Composite1Service;
import com.wordnik.swagger.annotations.*;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

/**
 * Controller object for domain model class Composite1.
 * @see Composite1
 */
@RestController("WMSTUDIO.Composite1Controller")
@RequestMapping("/WMSTUDIO/Composite1")
@Api(description = "Exposes APIs to work with Composite1 resource.", value = "Composite1Controller")
public class Composite1Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(Composite1Controller.class);

    @Autowired
    @Qualifier("WMSTUDIO.Composite1Service")
    private Composite1Service composite1Service;

    /**
     * @deprecated Use {@link #findComposite1s(String)} instead.
     */
    @Deprecated
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of Composite1 instances matching the search criteria.")
    public Page<Composite1> findComposite1s(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Composite1s list");
        return composite1Service.findAll(queryFilters, pageable);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of Composite1 instances matching the search criteria.")
    public Page<Composite1> findComposite1s(@RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Composite1s list");
        return composite1Service.findAll(query, pageable);
    }

    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Returns downloadable file for the data.")
    public Downloadable exportComposite1s(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return composite1Service.export(exportType, query, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service Composite1Service instance
	 */
    protected void setComposite1Service(Composite1Service service) {
        this.composite1Service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Creates a new Composite1 instance.")
    public Composite1 createComposite1(@RequestBody Composite1 composite1) {
        LOGGER.debug("Create Composite1 with information: {}", composite1);
        composite1 = composite1Service.create(composite1);
        LOGGER.debug("Created Composite1 with information: {}", composite1);
        return composite1;
    }

    @RequestMapping(value = "/composite-id", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the Composite1 instance associated with the given composite-id.")
    public Composite1 getComposite1(@RequestParam(value = "stringCol", required = true) String stringCol, @RequestParam(value = "id", required = true) int id, @RequestParam(value = "shortCol", required = true) short shortCol) throws EntityNotFoundException {
        Composite1Id composite1Id = new Composite1Id();
        composite1Id.setStringCol(stringCol);
        composite1Id.setId(id);
        composite1Id.setShortCol(shortCol);
        LOGGER.debug("Getting Composite1 with id: {}", composite1Id);
        Composite1 composite1 = composite1Service.getById(composite1Id);
        LOGGER.debug("Composite1 details with id: {}", composite1);
        return composite1;
    }

    @RequestMapping(value = "/composite-id", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the Composite1 instance associated with the given composite-id.")
    public Composite1 editComposite1(@RequestParam(value = "stringCol", required = true) String stringCol, @RequestParam(value = "id", required = true) int id, @RequestParam(value = "shortCol", required = true) short shortCol, @RequestBody Composite1 composite1) throws EntityNotFoundException {
        Composite1Id composite1Id = new Composite1Id();
        composite1Id.setStringCol(stringCol);
        composite1Id.setId(id);
        composite1Id.setShortCol(shortCol);
        composite1Service.delete(composite1Id);
        composite1 = composite1Service.create(composite1);
        LOGGER.debug("Composite1 details with id is updated: {}", composite1);
        return composite1;
    }

    @RequestMapping(value = "/composite-id", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Deletes the Composite1 instance associated with the given composite-id.")
    public boolean deleteComposite1(@RequestParam(value = "stringCol", required = true) String stringCol, @RequestParam(value = "id", required = true) int id, @RequestParam(value = "shortCol", required = true) short shortCol) throws EntityNotFoundException {
        Composite1Id composite1Id = new Composite1Id();
        composite1Id.setStringCol(stringCol);
        composite1Id.setId(id);
        composite1Id.setShortCol(shortCol);
        LOGGER.debug("Deleting Composite1 with id: {}", composite1Id);
        Composite1 composite1 = composite1Service.delete(composite1Id);
        return composite1 != null;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the total count of Composite1 instances.")
    public Long countComposite1s(@RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting Composite1s");
        return composite1Service.count(query);
    }
}
