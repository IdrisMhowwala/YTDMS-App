package com.yash.ytdms.dao;

import java.util.List;

import com.yash.ytdms.domain.Role;

/**
 * This is repsonsible for all the crud operations
 * @author rajpal.dodiya
 *
 */
public interface RoleDAO {
/**
 * This listAll will return list of all the roles
 * @return
 */
List<Role>listAll();

/**
 * This method will add the role in the database
 * @param role is the role to be inserted
 */
 void addRole(Role role);
}
