/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing26thjuly_.db123testing.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
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
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.file.model.DownloadResponse;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.runtime.util.WMMultipartUtils;
import com.wavemaker.runtime.util.WMRuntimeUtils;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.testing26thjuly_.db123testing.NewTypesUser;
import com.testing26thjuly_.db123testing.service.NewTypesUserService;
import com.wordnik.swagger.annotations.*;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

/**
 * Controller object for domain model class NewTypesUser.
 * @see NewTypesUser
 */
@RestController("DB123Testing.NewTypesUserController")
@RequestMapping("/DB123Testing/NewTypesUser")
@Api(description = "Exposes APIs to work with NewTypesUser resource.", value = "NewTypesUserController")
public class NewTypesUserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(NewTypesUserController.class);

    @Autowired
    @Qualifier("DB123Testing.NewTypesUserService")
    private NewTypesUserService newTypesUserService;

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Creates a new NewTypesUser instance.")
    public NewTypesUser createNewTypesUser(@RequestBody NewTypesUser newtypesuser) {
        LOGGER.debug("Create NewTypesUser with information: {}", newtypesuser);
        newtypesuser = newTypesUserService.create(newtypesuser);
        LOGGER.debug("Created NewTypesUser with information: {}", newtypesuser);
        return newtypesuser;
    }

    @RequestMapping(value = "/{id}/content/{fieldName}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Retrieves content for the given BLOB field in NewTypesUser instance")
    public DownloadResponse getNewTypesUserBLOBContent(@PathVariable("id") Integer id, @PathVariable("fieldName") String fieldName, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestParam(value = "download", defaultValue = "false") boolean download) {
        LOGGER.debug("Retrieves content for the given BLOB field {} in NewTypesUser instance", fieldName);
        if (!WMRuntimeUtils.isLob(NewTypesUser.class, fieldName)) {
            throw new TypeMismatchException("Given field " + fieldName + " is not a valid BLOB type");
        }
        NewTypesUser newtypesuser = newTypesUserService.getById(id);
        return WMMultipartUtils.buildDownloadResponseForBlob(newtypesuser, fieldName, httpServletRequest, download);
    }

    /**
     * @deprecated Use {@link #findNewTypesUsers(String)} instead.
     */
    @Deprecated
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of NewTypesUser instances matching the search criteria.")
    public Page<NewTypesUser> findNewTypesUsers(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering NewTypesUsers list");
        return newTypesUserService.findAll(queryFilters, pageable);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of NewTypesUser instances matching the search criteria.")
    public Page<NewTypesUser> findNewTypesUsers(@RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering NewTypesUsers list");
        return newTypesUserService.findAll(query, pageable);
    }

    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Returns downloadable file for the data.")
    public Downloadable exportNewTypesUsers(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return newTypesUserService.export(exportType, query, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service NewTypesUserService instance
	 */
    protected void setNewTypesUserService(NewTypesUserService service) {
        this.newTypesUserService = service;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = { "multipart/form-data" })
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Creates a new NewTypesUser instance.")
    public NewTypesUser createNewTypesUser(MultipartHttpServletRequest multipartHttpServletRequest) {
        NewTypesUser newtypesuser = WMMultipartUtils.toObject(multipartHttpServletRequest, NewTypesUser.class, "DB123Testing");
        LOGGER.debug("Creating a new NewTypesUser with information: {}", newtypesuser);
        return newTypesUserService.create(newtypesuser);
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the total count of NewTypesUser instances.")
    public Long countNewTypesUsers(@RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting NewTypesUsers");
        return newTypesUserService.count(query);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the NewTypesUser instance associated with the given id.")
    public NewTypesUser getNewTypesUser(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting NewTypesUser with id: {}", id);
        NewTypesUser foundNewTypesUser = newTypesUserService.getById(id);
        LOGGER.debug("NewTypesUser details with id: {}", foundNewTypesUser);
        return foundNewTypesUser;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the NewTypesUser instance associated with the given id.")
    public NewTypesUser editNewTypesUser(@PathVariable(value = "id") Integer id, @RequestBody NewTypesUser newtypesuser) throws EntityNotFoundException {
        LOGGER.debug("Editing NewTypesUser with id: {}", newtypesuser.getId());
        newtypesuser.setId(id);
        newtypesuser = newTypesUserService.update(newtypesuser);
        LOGGER.debug("NewTypesUser details with id: {}", newtypesuser);
        return newtypesuser;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST, consumes = { "multipart/form-data" })
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the NewTypesUser instance associated with the given id.This API should be used when NewTypesUser instance fields that require multipart data.")
    public NewTypesUser editNewTypesUser(@PathVariable(value = "id") Integer id, MultipartHttpServletRequest multipartHttpServletRequest) throws EntityNotFoundException {
        NewTypesUser newNewTypesUser = WMMultipartUtils.toObject(multipartHttpServletRequest, NewTypesUser.class, "DB123Testing");
        newNewTypesUser.setId(id);
        NewTypesUser oldNewTypesUser = newTypesUserService.getById(id);
        WMMultipartUtils.updateLobsContent(oldNewTypesUser, newNewTypesUser);
        LOGGER.debug("Updating NewTypesUser with information: {}", newNewTypesUser);
        return newTypesUserService.update(newNewTypesUser);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Deletes the NewTypesUser instance associated with the given id.")
    public boolean deleteNewTypesUser(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting NewTypesUser with id: {}", id);
        NewTypesUser deletedNewTypesUser = newTypesUserService.delete(id);
        return deletedNewTypesUser != null;
    }
}
