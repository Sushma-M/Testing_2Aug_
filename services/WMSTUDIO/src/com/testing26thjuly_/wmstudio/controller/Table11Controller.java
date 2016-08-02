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
import com.testing26thjuly_.wmstudio.Table11;
import com.testing26thjuly_.wmstudio.service.Table11Service;
import com.wordnik.swagger.annotations.*;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

/**
 * Controller object for domain model class Table11.
 * @see Table11
 */
@RestController("WMSTUDIO.Table11Controller")
@RequestMapping("/WMSTUDIO/Table11")
@Api(description = "Exposes APIs to work with Table11 resource.", value = "Table11Controller")
public class Table11Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(Table11Controller.class);

    @Autowired
    @Qualifier("WMSTUDIO.Table11Service")
    private Table11Service table11Service;

    /**
     * @deprecated Use {@link #findTable11s(String)} instead.
     */
    @Deprecated
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of Table11 instances matching the search criteria.")
    public Page<Table11> findTable11s(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Table11s list");
        return table11Service.findAll(queryFilters, pageable);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of Table11 instances matching the search criteria.")
    public Page<Table11> findTable11s(@RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Table11s list");
        return table11Service.findAll(query, pageable);
    }

    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Returns downloadable file for the data.")
    public Downloadable exportTable11s(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return table11Service.export(exportType, query, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service Table11Service instance
	 */
    protected void setTable11Service(Table11Service service) {
        this.table11Service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Creates a new Table11 instance.")
    public Table11 createTable11(@RequestBody Table11 table11) {
        LOGGER.debug("Create Table11 with information: {}", table11);
        table11 = table11Service.create(table11);
        LOGGER.debug("Created Table11 with information: {}", table11);
        return table11;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the total count of Table11 instances.")
    public Long countTable11s(@RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting Table11s");
        return table11Service.count(query);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the Table11 instance associated with the given id.")
    public Table11 getTable11(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Table11 with id: {}", id);
        Table11 foundTable11 = table11Service.getById(id);
        LOGGER.debug("Table11 details with id: {}", foundTable11);
        return foundTable11;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the Table11 instance associated with the given id.")
    public Table11 editTable11(@PathVariable(value = "id") Integer id, @RequestBody Table11 table11) throws EntityNotFoundException {
        LOGGER.debug("Editing Table11 with id: {}", table11.getId());
        table11.setId(id);
        table11 = table11Service.update(table11);
        LOGGER.debug("Table11 details with id: {}", table11);
        return table11;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Deletes the Table11 instance associated with the given id.")
    public boolean deleteTable11(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Table11 with id: {}", id);
        Table11 deletedTable11 = table11Service.delete(id);
        return deletedTable11 != null;
    }
}
