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
import com.testing26thjuly_.compositestest.Table3;
import com.testing26thjuly_.compositestest.service.Table3Service;
import com.wordnik.swagger.annotations.*;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

/**
 * Controller object for domain model class Table3.
 * @see Table3
 */
@RestController("CompositesTest.Table3Controller")
@RequestMapping("/CompositesTest/Table3")
@Api(description = "Exposes APIs to work with Table3 resource.", value = "Table3Controller")
public class Table3Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(Table3Controller.class);

    @Autowired
    @Qualifier("CompositesTest.Table3Service")
    private Table3Service table3Service;

    /**
     * @deprecated Use {@link #findTable3s(String)} instead.
     */
    @Deprecated
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of Table3 instances matching the search criteria.")
    public Page<Table3> findTable3s(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Table3s list");
        return table3Service.findAll(queryFilters, pageable);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of Table3 instances matching the search criteria.")
    public Page<Table3> findTable3s(@RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Table3s list");
        return table3Service.findAll(query, pageable);
    }

    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Returns downloadable file for the data.")
    public Downloadable exportTable3s(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return table3Service.export(exportType, query, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service Table3Service instance
	 */
    protected void setTable3Service(Table3Service service) {
        this.table3Service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Creates a new Table3 instance.")
    public Table3 createTable3(@RequestBody Table3 table3) {
        LOGGER.debug("Create Table3 with information: {}", table3);
        table3 = table3Service.create(table3);
        LOGGER.debug("Created Table3 with information: {}", table3);
        return table3;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the total count of Table3 instances.")
    public Long countTable3s(@RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting Table3s");
        return table3Service.count(query);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the Table3 instance associated with the given id.")
    public Table3 getTable3(@PathVariable(value = "id") String id) throws EntityNotFoundException {
        LOGGER.debug("Getting Table3 with id: {}", id);
        Table3 foundTable3 = table3Service.getById(id);
        LOGGER.debug("Table3 details with id: {}", foundTable3);
        return foundTable3;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the Table3 instance associated with the given id.")
    public Table3 editTable3(@PathVariable(value = "id") String id, @RequestBody Table3 table3) throws EntityNotFoundException {
        LOGGER.debug("Editing Table3 with id: {}", table3.getColumn3());
        table3.setColumn3(id);
        table3 = table3Service.update(table3);
        LOGGER.debug("Table3 details with id: {}", table3);
        return table3;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Deletes the Table3 instance associated with the given id.")
    public boolean deleteTable3(@PathVariable(value = "id") String id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Table3 with id: {}", id);
        Table3 deletedTable3 = table3Service.delete(id);
        return deletedTable3 != null;
    }
}
