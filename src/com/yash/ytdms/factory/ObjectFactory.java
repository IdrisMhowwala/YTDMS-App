package com.yash.ytdms.factory;

import com.yash.ytdms.dao.CategoryDAO;
import com.yash.ytdms.dao.DocumentDAO;
import com.yash.ytdms.dao.GroupDAO;
import com.yash.ytdms.dao.NotificationDAO;
import com.yash.ytdms.dao.PermissionDAO;
import com.yash.ytdms.dao.PermissionModuleDAO;
import com.yash.ytdms.dao.RoleDAO;
import com.yash.ytdms.dao.SectionDAO;
import com.yash.ytdms.dao.TestDAO;
import com.yash.ytdms.daoimpl.CategoryDAOImpl;
import com.yash.ytdms.daoimpl.DocumentDAOImpl;
import com.yash.ytdms.daoimpl.GroupDAOImpl;
import com.yash.ytdms.daoimpl.NotificationDAOImpl;
import com.yash.ytdms.daoimpl.PermissionDAOImpl;
import com.yash.ytdms.daoimpl.PermissionModuleDAOImpl;
import com.yash.ytdms.daoimpl.RoleDAOImpl;
import com.yash.ytdms.daoimpl.SectionDAOImpl;
import com.yash.ytdms.daoimpl.TestDAOImpl;
import com.yash.ytdms.domain.Category;
import com.yash.ytdms.service.CategoryService;
import com.yash.ytdms.service.DocumentService;
import com.yash.ytdms.service.GroupService;
import com.yash.ytdms.service.NotificationService;
import com.yash.ytdms.service.PermissionModuleService;
import com.yash.ytdms.service.PermissionService;
import com.yash.ytdms.service.RoleService;
import com.yash.ytdms.service.SectionService;
import com.yash.ytdms.service.TestService;
import com.yash.ytdms.serviceimpl.CategoryServiceImpl;
import com.yash.ytdms.serviceimpl.DocumentServiceImpl;
import com.yash.ytdms.serviceimpl.GroupServiceImpl;
import com.yash.ytdms.serviceimpl.NotificationServiceImpl;
import com.yash.ytdms.serviceimpl.PermissionModuleServiceImpl;
import com.yash.ytdms.serviceimpl.PermissionServiceImpl;
import com.yash.ytdms.serviceimpl.RoleServiceImpl;
import com.yash.ytdms.serviceimpl.SectionServiceImpl;
import com.yash.ytdms.serviceimpl.TestServiceImpl;
/**
 * This object factory is used to get the Implementation object based on reference type
 * You need to copy paste the if block and change the Reference type as per your requirement. 
 * If condition is met successfully, return the implementation object. 
 * @author samay.jain
 *
 */
public class ObjectFactory {

	public static Object getObject(Class refClassName) {
		
		if(refClassName == TestDAO.class) {
			return (Object) new TestDAOImpl();
		}
		
		if(refClassName == TestService.class) {
			return (Object) new TestServiceImpl();
		}
		if(refClassName == DocumentService.class) {
			return (Object) new DocumentServiceImpl();
		}
		if(refClassName == DocumentDAO.class) {
			return (Object) new DocumentDAOImpl();
		}
		if(refClassName == CategoryDAO.class) {
			return (Object) new CategoryDAOImpl();
		}
		
		if(refClassName == CategoryService.class) {
			return (Object) new CategoryServiceImpl();
		}
		if(refClassName == Category.class) {
			return (Object) new Category();
		}
		if(refClassName == NotificationDAO.class) {
			return (Object) new NotificationDAOImpl();
		}
		
		if(refClassName == NotificationService.class) {
			return (Object) new NotificationServiceImpl();
		}
		if(refClassName == PermissionModuleDAO.class) {
			return (Object) new PermissionModuleDAOImpl();
		}
		
		if(refClassName == PermissionModuleService.class) {
			return (Object) new PermissionModuleServiceImpl();
		}
		if(refClassName == RoleDAO.class) {
			return (Object) new RoleDAOImpl();
		}
		
		if(refClassName == RoleService.class) {
			return (Object) new RoleServiceImpl();
		}
		
		if(refClassName == PermissionDAO.class) {
			return (Object) new PermissionDAOImpl();
		}
		
		if(refClassName == PermissionService.class) {
			return (Object) new PermissionServiceImpl();
		}
		if(refClassName == SectionDAO.class) {
			return (Object) new SectionDAOImpl();
		}
		
		if(refClassName == SectionService.class) {
			return (Object) new SectionServiceImpl();
		}
		if (refClassName == GroupDAO.class) {
			return (Object) new GroupDAOImpl();
		}
		if (refClassName == GroupService.class) {
			return (Object) new GroupServiceImpl();
		}
		return null;
	}

}
