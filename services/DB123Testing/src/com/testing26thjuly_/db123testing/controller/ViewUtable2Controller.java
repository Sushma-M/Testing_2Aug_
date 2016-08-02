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
import com.testing26thjuly_.db123testing.ViewUtable2;
import com.testing26thjuly_.db123testing.ViewUtable2Id;
import com.testing26thjuly_.db123testing.service.ViewUtable2Service;
import com.wordnik.swagger.annotations.*;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

/**
 * Controller object for domain model class ViewUtable2.
 * @see ViewUtable2
 */
@RestController("DB123Testing.ViewUtable2Controller")
@RequestMapping("/DB123Testing/ViewUtable2")
@Api(description = "Exposes APIs to work with ViewUtable2 resource.", value = "ViewUtable2Controller")
public class ViewUtable2Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(ViewUtable2Controller.class);

    @Autowired
    @Qualifier("DB123Testing.ViewUtable2Service")
    private ViewUtable2Service viewUtable2Service;

    /**
     * @deprecated Use {@link #findViewUtable2s(String)} instead.
     */
    @Deprecated
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of ViewUtable2 instances matching the search criteria.")
    public Page<ViewUtable2> findViewUtable2s(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering ViewUtable2s list");
        return viewUtable2Service.findAll(queryFilters, pageable);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of ViewUtable2 instances matching the search criteria.")
    public Page<ViewUtable2> findViewUtable2s(@RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering ViewUtable2s list");
        return viewUtable2Service.findAll(query, pageable);
    }

    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Returns downloadable file for the data.")
    public Downloadable exportViewUtable2s(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return viewUtable2Service.export(exportType, query, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service ViewUtable2Service instance
	 */
    protected void setViewUtable2Service(ViewUtable2Service service) {
        this.viewUtable2Service = service;
    }

    @RequestMapping(value = "/composite-id", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the ViewUtable2 instance associated with the given composite-id.")
    public ViewUtable2 getViewUtable2(@RequestParam(value = "id", required = true) String id, @RequestParam(value = "company", required = true) String company, @RequestParam(value = "contactName", required = true) String contactName, @RequestParam(value = "address", required = true) String address, @RequestParam(value = "city", required = true) String city) throws EntityNotFoundException {
        ViewUtable2Id viewutable2Id = new ViewUtable2Id();
        viewutable2Id.setId(id);
        viewutable2Id.setCompany(company);
        viewutable2Id.setContactName(contactName);
        viewutable2Id.setAddress(address);
        viewutable2Id.setCity(city);
        LOGGER.debug("Getting ViewUtable2 with id: {}", viewutable2Id);
        ViewUtable2 viewutable2 = viewUtable2Service.getById(viewutable2Id);
        LOGGER.debug("ViewUtable2 details with id: {}", viewutable2);
        return viewutable2;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the total count of ViewUtable2 instances.")
    public Long countViewUtable2s(@RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting ViewUtable2s");
        return viewUtable2Service.count(query);
    }
}