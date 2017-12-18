package cn.likegirl.service;


import cn.likegirl.entities.Permission;

public interface PermissionService {
    public Permission createPermission(Permission permission);
    public void deletePermission(Long permissionId);
}
