package org.softcits.auth.mapper;
import java.util.List;

import org.softcits.auth.model.MbgUserAndRole;
public interface MbgUserRoleMapper {

	List<MbgUserAndRole> getAllUsersAndRoles();
}
