package cn.likegirl.dao;


import cn.likegirl.entities.Permission;

public interface PermissionDao {

    public Permission createPermission(Permission permission);

    public void deletePermission(Long permissionId);

}
