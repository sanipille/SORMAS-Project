package de.symeda.sormas.api.user;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

@Remote
public interface UserFacade {

    List<UserReferenceDto> getAllAsReference(UserRole userRole);
    
    List<UserDto> getAll(UserRole... role);
    
    UserDto getByUuid(String uuid);
    
    UserDto saveUser(UserDto dto);

    boolean isLoginUnique(String uuid, String userName);
    
    String resetPassword(String uuid);

	List<UserDto> getAllAfter(Date date);

	UserDto getByUserName(String userName);

	UserReferenceDto getByUserNameAsReference(String userName);

	List<UserReferenceDto> getAllAfterAsReference(Date date);

	List<UserReferenceDto> getAssignableUsers(UserReferenceDto assigningUser);
}
