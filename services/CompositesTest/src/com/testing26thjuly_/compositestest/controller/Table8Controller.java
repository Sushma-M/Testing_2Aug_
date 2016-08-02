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
import com.testing26thjuly_.compositestest.Table8;
import com.testing26thjuly_.compositestest.service.Table8Service;
import com.wordnik.swagger.annotations.*;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

/**
 * Controller object for domain model class Table8.
 * @see Table8
 */
@RestController("CompositesTest.Table8Controller")
@RequestMapping("/CompositesTest/Table8")
@Api(description = "Exposes APIs to work with Table8 resource.", value = "Table8Controller")
public class Table8Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(Table8Controller.class);

    @Autowired
    @Qualifier("CompositesTest.Table8Service")
    private Table8Service table8Service;

    /**
     * @deprecated Use {@link #findTable8s(String)} instead.
     */
    @Deprecated
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of Table8 instances matching the search criteria.")
    public Page<Table8> findTable8s(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Table8s list");
        return table8Service.findAll(queryFilters, pageable);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of Table8 instances matching the search criteria.")
    public Page<Table8> findTable8s(@RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Table8s list");
        return table8Service.findAll(query, pageable);
    }

    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Returns downloadable file for the data.")
    public Downloadable exportTable8s(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return table8Service.export(exportType, query, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service Table8Service instance
	 */
    protected void setTable8Service(Table8Service service) {
        this.table8Service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Creates a new Table8 instance.")
    public Table8 createTable8(@RequestBody Table8 table8) {
        LOGGER.debug("Create Table8 with information: {}", table8);
        table8 = table8Service.create(table8);
        LOGGER.debug("Created Table8 with information: {}", table8);
        return table8;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the total count of Table8 instances.")
    public Long countTable8s(@RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting Table8s");
        return table8Service.count(query);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the Table8 instance associated with the given id.")
    public Table8 getTable8(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Table8 with id: {}", id);
        Table8 foundTable8 = table8Service.getById(id);
        LOGGER.debug("Table8 details with id: {}", foundTable8);
        return foundTable8;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the Table8 instance associated with the given id.")
    public Table8 editTable8(@PathVariable(value = "id") Integer id, @RequestBody Table8 table8) throws EntityNotFoundException {
        LOGGER.debug("Editing Table8 with id: {}", table8.getId());
        table8.setId(id);
        table8 = table8Service.update(table8);
        LOGGER.debug("Table8 details with id: {}", table8);
        return table8;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Deletes the Table8 instance associated with the given id.")
    public boolean deleteTable8(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Table8 with id: {}", id);
        Table8 deletedTable8 = table8Service.delete(id);
        return deletedTable8 != null;
    }
}