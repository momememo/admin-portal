package com.baiwang.admin.portal.controller;

import com.baiwang.admin.portal.bean.entity.Role;
import com.baiwang.admin.portal.service.RoleService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: 用户角色控制器
 * @author: liyunfei
 * @date: 2018/8/29 9:46
 */
@Controller
@RequestMapping("role")
public class RoleController extends BaseController {

    /**
     * 1. 增加权限
     * 2. 修改权限
     * 3. 删除权限
     * 4. 用户赋权
     */

    @Autowired
    private RoleService roleService;

    private static Logger log = LoggerFactory.getLogger(RoleController.class);

    @ResponseBody
    @RequestMapping(value = "/list")
    public List<Role> list(@RequestParam(value = "requestId", required = false) String requestId) {
        List<Role> roles = roleService.getRoleList(requestId);
        log.info("{} --> role list: {}", requestId, roles);
        return roles;
    }

    @RequestMapping(value = "/gotoAdd")
    public String gotoAdd() {
        return "";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestBody Role role,
                      @RequestParam(value = "requestId", required = false) String requestId) {
        log.info("{} --> add role : {}", requestId, role);
        roleService.addRole(requestId, role);
        return "";
    }

    @RequestMapping(value = "/gotoUpdate", method = RequestMethod.POST)
    public String gotoUpdate(@RequestParam String roleId,
                             @RequestParam(value = "requestId", required = false) String requestId) {
        log.info("{} --> goto update role, roleId : {}", requestId, roleId);
        return "";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestBody Role role,
                         @RequestParam(value = "requestId", required = false) String requestId) {
        log.info("{} -->update role : {}", requestId, role);
        roleService.updateRole(requestId, role);
        return "";
    }

    @RequestMapping(value = "/delete")
    public String delete(@RequestParam("roleId") String roleId,
                         @RequestParam(value = "requestId", required = false) String requestId) {
        log.info("{} --> delete roleId : {}", requestId, roleId);
        roleService.deleteRoleById(requestId, roleId);
        return "";
    }

}
