/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing26thjuly_.compositestest.controller;

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
import com.testing26thjuly_.compositestest.Table4;
import com.testing26thjuly_.compositestest.service.Table4Service;
import com.wordnik.swagger.annotations.*;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

/**
 * Controller object for domain model class Table4.
 * @see Table4
 */
@RestController("CompositesTest.Table4Controller")
@RequestMapping("/CompositesTest/Table4")
@Api(description = "Exposes APIs to work with Table4 resource.", value = "Table4Controller")
public class Table4Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(Table4Controller.class);

    @Autowired
    @Qualifier("CompositesTest.Table4Service")
    private Table4Service table4Service;

    /**
     * @deprecated Use {@link #findTable4s(String)} instead.
     */
    @Deprecated
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of Table4 instances matching the search criteria.")
    public Page<Table4> findTable4s(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Table4s list");
        return table4Service.findAll(queryFilters, pageable);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of Table4 instances matching the search criteria.")
    public Page<Table4> findTable4s(@RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Table4s list");
        return table4Service.findAll(query, pageable);
    }

    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Returns downloadable file for the data.")
    public Downloadable exportTable4s(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return table4Service.export(exportType, query, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service Table4Service instance
	 */
    protected void setTable4Service(Table4Service service) {
        this.table4Service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Creates a new Table4 instance.")
    public Table4 createTable4(@RequestBody Table4 table4) {
        LOGGER.debug("Create Table4 with information: {}", table4);
        table4 = table4Service.create(table4);
        LOGGER.debug("Created Table4 with information: {}", table4);
        return table4;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the total count of Table4 instances.")
    public Long countTable4s(@RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting Table4s");
        return table4Service.count(query);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the Table4 instance associated with the given id.")
    public Table4 getTable4(@PathVariable(value = "id") String id) throws EntityNotFoundException {
        LOGGER.debug("Getting Table4 with id: {}", id);
        Table4 foundTable4 = table4Service.getById(id);
        LOGGER.debug("Table4 details with id: {}", foundTable4);
        return foundTable4;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the Table4 instance associated with the given id.")
    public Table4 editTable4(@PathVariable(value = "id") String id, @RequestBody Table4 table4) throws EntityNotFoundException {
        LOGGER.debug("Editing Table4 with id: {}", table4.getStringCol());
        table4.setStringCol(id);
        table4 = table4Service.update(table4);
        LOGGER.debug("Table4 details with id: {}", table4);
        return table4;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Deletes the Table4 instance associated with the given id.")
    public boolean deleteTable4(@PathVariable(value = "id") String id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Table4 with id: {}", id);
        Table4 deletedTable4 = table4Service.delete(id);
        return deletedTable4 != null;
    }
}
