/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing26thjuly_.db123testing.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.TypeMismatchException;
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
import com.wavemaker.runtime.util.WMMultipartUtils;
import com.wavemaker.runtime.util.WMRuntimeUtils;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.testing26thjuly_.db123testing.ViewTypesSpacing;
import com.testing26thjuly_.db123testing.ViewTypesSpacingId;
import com.testing26thjuly_.db123testing.service.ViewTypesSpacingService;
import com.wordnik.swagger.annotations.*;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

/**
 * Controller object for domain model class ViewTypesSpacing.
 * @see ViewTypesSpacing
 */
@RestController("DB123Testing.ViewTypesSpacingController")
@RequestMapping("/DB123Testing/ViewTypesSpacing")
@Api(description = "Exposes APIs to work with ViewTypesSpacing resource.", value = "ViewTypesSpacingController")
public class ViewTypesSpacingController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ViewTypesSpacingController.class);

    @Autowired
    @Qualifier("DB123Testing.ViewTypesSpacingService")
    private ViewTypesSpacingService viewTypesSpacingService;

    @RequestMapping(value = "/composite-id", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the ViewTypesSpacing instance associated with the given composite-id.")
    public ViewTypesSpacing getViewTypesSpacing(@RequestParam("id") int id, @RequestParam("byteCol") Byte byteCol, @RequestParam("shortCol") Short shortCol, @RequestParam("intCol") Integer intCol, @RequestParam("longCol") BigInteger longCol, @RequestParam("bigIntCol") BigInteger bigIntCol, @RequestParam("floatCol") Float floatCol, @RequestParam("doubleCol") Double doubleCol, @RequestParam("bigDecCol") BigDecimal bigDecCol, @RequestParam("charCol") Character charCol, @RequestParam("stringCol") String stringCol, @RequestParam("textCol") String textCol, @RequestParam("booleanCol") Boolean booleanCol, @RequestParam("blobCol") byte[] blobCol, @RequestParam("datetimeCol") Date datetimeCol, @RequestParam("timestampCol") Date timestampCol, @RequestParam("dateCol") Date dateCol, @RequestParam("timeCol") Date timeCol) throws EntityNotFoundException {
        ViewTypesSpacingId viewtypesspacingId = new ViewTypesSpacingId();
        viewtypesspacingId.setId(id);
        viewtypesspacingId.setByteCol(byteCol);
        viewtypesspacingId.setShortCol(shortCol);
        viewtypesspacingId.setIntCol(intCol);
        viewtypesspacingId.setLongCol(longCol);
        viewtypesspacingId.setBigIntCol(bigIntCol);
        viewtypesspacingId.setFloatCol(floatCol);
        viewtypesspacingId.setDoubleCol(doubleCol);
        viewtypesspacingId.setBigDecCol(bigDecCol);
        viewtypesspacingId.setCharCol(charCol);
        viewtypesspacingId.setStringCol(stringCol);
        viewtypesspacingId.setTextCol(textCol);
        viewtypesspacingId.setBooleanCol(booleanCol);
        viewtypesspacingId.setBlobCol(blobCol);
        viewtypesspacingId.setDatetimeCol(datetimeCol);
        viewtypesspacingId.setTimestampCol(timestampCol);
        viewtypesspacingId.setDateCol(dateCol);
        viewtypesspacingId.setTimeCol(timeCol);
        LOGGER.debug("Getting ViewTypesSpacing with id: {}", viewtypesspacingId);
        ViewTypesSpacing viewtypesspacing = viewTypesSpacingService.getById(viewtypesspacingId);
        LOGGER.debug("ViewTypesSpacing details with id: {}", viewtypesspacing);
        return viewtypesspacing;
    }

    @RequestMapping(value = "/composite-id/content/{fieldName}", method = RequestMethod.GET)
    @ApiOperation(value = "Retrieves content for the given BLOB field in ViewTypesSpacing instance associated with the given composite-id.")
    public void getViewTypesSpacingBLOBContent(@RequestParam("id") int id, @RequestParam("byteCol") Byte byteCol, @RequestParam("shortCol") Short shortCol, @RequestParam("intCol") Integer intCol, @RequestParam("longCol") BigInteger longCol, @RequestParam("bigIntCol") BigInteger bigIntCol, @RequestParam("floatCol") Float floatCol, @RequestParam("doubleCol") Double doubleCol, @RequestParam("bigDecCol") BigDecimal bigDecCol, @RequestParam("charCol") Character charCol, @RequestParam("stringCol") String stringCol, @RequestParam("textCol") String textCol, @RequestParam("booleanCol") Boolean booleanCol, @RequestParam("blobCol") byte[] blobCol, @RequestParam("datetimeCol") Date datetimeCol, @RequestParam("timestampCol") Date timestampCol, @RequestParam("dateCol") Date dateCol, @RequestParam("timeCol") Date timeCol, @PathVariable("fieldName") String fieldName, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws EntityNotFoundException {
        LOGGER.debug("Retrieves content for the given BLOB field {} in ViewTypesSpacing instance", fieldName);
        if (!WMRuntimeUtils.isLob(ViewTypesSpacing.class, fieldName)) {
            throw new TypeMismatchException("Given field " + fieldName + " is not a valid BLOB type");
        }
        ViewTypesSpacingId viewtypesspacingId = new ViewTypesSpacingId();
        viewtypesspacingId.setId(id);
        viewtypesspacingId.setByteCol(byteCol);
        viewtypesspacingId.setShortCol(shortCol);
        viewtypesspacingId.setIntCol(intCol);
        viewtypesspacingId.setLongCol(longCol);
        viewtypesspacingId.setBigIntCol(bigIntCol);
        viewtypesspacingId.setFloatCol(floatCol);
        viewtypesspacingId.setDoubleCol(doubleCol);
        viewtypesspacingId.setBigDecCol(bigDecCol);
        viewtypesspacingId.setCharCol(charCol);
        viewtypesspacingId.setStringCol(stringCol);
        viewtypesspacingId.setTextCol(textCol);
        viewtypesspacingId.setBooleanCol(booleanCol);
        viewtypesspacingId.setBlobCol(blobCol);
        viewtypesspacingId.setDatetimeCol(datetimeCol);
        viewtypesspacingId.setTimestampCol(timestampCol);
        viewtypesspacingId.setDateCol(dateCol);
        viewtypesspacingId.setTimeCol(timeCol);
        ViewTypesSpacing viewtypesspacing = viewTypesSpacingService.getById(viewtypesspacingId);
        WMMultipartUtils.buildHttpResponseForBlob(viewtypesspacing, fieldName, httpServletRequest, httpServletResponse);
    }

    /**
     * @deprecated Use {@link #findViewTypesSpacings(String)} instead.
     */
    @Deprecated
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of ViewTypesSpacing instances matching the search criteria.")
    public Page<ViewTypesSpacing> findViewTypesSpacings(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering ViewTypesSpacings list");
        return viewTypesSpacingService.findAll(queryFilters, pageable);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of ViewTypesSpacing instances matching the search criteria.")
    public Page<ViewTypesSpacing> findViewTypesSpacings(@RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering ViewTypesSpacings list");
        return viewTypesSpacingService.findAll(query, pageable);
    }

    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Returns downloadable file for the data.")
    public Downloadable exportViewTypesSpacings(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return viewTypesSpacingService.export(exportType, query, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service ViewTypesSpacingService instance
	 */
    protected void setViewTypesSpacingService(ViewTypesSpacingService service) {
        this.viewTypesSpacingService = service;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the total count of ViewTypesSpacing instances.")
    public Long countViewTypesSpacings(@RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting ViewTypesSpacings");
        return viewTypesSpacingService.count(query);
    }
}
