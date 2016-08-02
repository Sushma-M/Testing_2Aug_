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
import com.testing26thjuly_.wmstudio.Table65;
import com.testing26thjuly_.wmstudio.Table65Id;
import com.testing26thjuly_.wmstudio.service.Composite1Service;
import com.testing26thjuly_.wmstudio.service.Table65Service;
import com.wordnik.swagger.annotations.*;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

/**
 * Controller object for domain model class Table65.
 * @see Table65
 */
@RestController("WMSTUDIO.Table65Controller")
@RequestMapping("/WMSTUDIO/Table65")
@Api(description = "Exposes APIs to work with Table65 resource.", value = "Table65Controller")
public class Table65Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(Table65Controller.class);

    @Autowired
    @Qualifier("WMSTUDIO.Table65Service")
    private Table65Service table65Service;

    @Autowired
    @Qualifier("WMSTUDIO.Composite1Service")
    private Composite1Service composite1Service;

    /**
     * @deprecated Use {@link #findTable65s(String)} instead.
     */
    @Deprecated
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of Table65 instances matching the search criteria.")
    public Page<Table65> findTable65s(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Table65s list");
        return table65Service.findAll(queryFilters, pageable);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of Table65 instances matching the search criteria.")
    public Page<Table65> findTable65s(@RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Table65s list");
        return table65Service.findAll(query, pageable);
    }

    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Returns downloadable file for the data.")
    public Downloadable exportTable65s(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return table65Service.export(exportType, query, pageable);
    }

    @RequestMapping(value = "/{id:.+}/composite1s", method = RequestMethod.GET)
    @ApiOperation(value = "Gets the composite1s instance associated with the given id.")
    public Page<Composite1> findAssociatedComposite1s(Pageable pageable, @PathVariable("id") Table65Id id) {
        LOGGER.debug("Fetching all associated composite1s");
        return composite1Service.findAssociatedValues(id, "table65", "stringCol", pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service Table65Service instance
	 */
    protected void setTable65Service(Table65Service service) {
        this.table65Service = service;
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
    @ApiOperation(value = "Creates a new Table65 instance.")
    public Table65 createTable65(@RequestBody Table65 table65) {
        LOGGER.debug("Create Table65 with information: {}", table65);
        table65 = table65Service.create(table65);
        LOGGER.debug("Created Table65 with information: {}", table65);
        return table65;
    }

    @RequestMapping(value = "/composite-id", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the Table65 instance associated with the given composite-id.")
    public Table65 getTable65(@RequestParam(value = "stringCol", required = true) String stringCol, @RequestParam(value = "id", required = true) int id, @RequestParam(value = "shortCol", required = true) short shortCol) throws EntityNotFoundException {
        Table65Id table65Id = new Table65Id();
        table65Id.setStringCol(stringCol);
        table65Id.setId(id);
        table65Id.setShortCol(shortCol);
        LOGGER.debug("Getting Table65 with id: {}", table65Id);
        Table65 table65 = table65Service.getById(table65Id);
        LOGGER.debug("Table65 details with id: {}", table65);
        return table65;
    }

    @RequestMapping(value = "/composite-id", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the Table65 instance associated with the given composite-id.")
    public Table65 editTable65(@RequestParam(value = "stringCol", required = true) String stringCol, @RequestParam(value = "id", required = true) int id, @RequestParam(value = "shortCol", required = true) short shortCol, @RequestBody Table65 table65) throws EntityNotFoundException {
        Table65Id table65Id = new Table65Id();
        table65Id.setStringCol(stringCol);
        table65Id.setId(id);
        table65Id.setShortCol(shortCol);
        table65Service.delete(table65Id);
        table65 = table65Service.create(table65);
        LOGGER.debug("Table65 details with id is updated: {}", table65);
        return table65;
    }

    @RequestMapping(value = "/composite-id", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Deletes the Table65 instance associated with the given composite-id.")
    public boolean deleteTable65(@RequestParam(value = "stringCol", required = true) String stringCol, @RequestParam(value = "id", required = true) int id, @RequestParam(value = "shortCol", required = true) short shortCol) throws EntityNotFoundException {
        Table65Id table65Id = new Table65Id();
        table65Id.setStringCol(stringCol);
        table65Id.setId(id);
        table65Id.setShortCol(shortCol);
        LOGGER.debug("Deleting Table65 with id: {}", table65Id);
        Table65 table65 = table65Service.delete(table65Id);
        return table65 != null;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the total count of Table65 instances.")
    public Long countTable65s(@RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting Table65s");
        return table65Service.count(query);
    }
}