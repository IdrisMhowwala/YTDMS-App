package com.yash.ytdms.service;

import java.util.List;

import com.yash.ytdms.domain.PermissionModule;
import com.yash.ytdms.exception.PermissionException;

/**
 * This will contain all the businness related logics of Permission module
 * @author rajpal.dodiya
 *
 */
public interface PermissionModuleService {
/**
 * This will return list of all the available modules from the system
 * @return
 */
List<PermissionModule>listAll();

/**
 * This will add the module in the available modules
 * @param module is the module to be added
 */
void addModule(PermissionModule module) throws PermissionException;


/**
 * This is used to retrieve all the modules list
 * @return list of permission modules
 */
public List<PermissionModule> getGroupList();


/**
 * This is used to retrieve group according to id
 * @param id is the id of particular module
 * @return a specific module
 */
public PermissionModule getGroup(int id);
}
