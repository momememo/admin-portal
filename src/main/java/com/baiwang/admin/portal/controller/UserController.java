package com.baiwang.admin.portal.controller;

import com.baiwang.admin.portal.bean.entity.Group;
import com.baiwang.admin.portal.bean.entity.Role;
import com.baiwang.admin.portal.bean.entity.User;
import com.baiwang.admin.portal.service.GroupService;
import com.baiwang.admin.portal.service.RoleService;
import com.baiwang.admin.portal.service.UserService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: 用户控制器
 * @author: liyunfei
 * @date: 2018/8/29 9:46
 */
@Controller
@RequestMapping("user")
public class UserController extends BaseController {

    /**
     * 1. 添加用户
     * 2. 删除用户
     * 3. 用户设置权限
     * 4. 修改用户
     */

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private GroupService groupService;

    private static Logger log = LoggerFactory.getLogger(RoleController.class);

    @ResponseBody
    @RequestMapping(value = "/list")
    public List<User> list(@RequestParam(value = "requestId", required = false) String requestId) {
        List<User> users = userService.getUserList(requestId);
        log.info("{} --> user list: {}", requestId, users);
        return users;
    }

    @RequestMapping(value = "/gotoAdd")
    public String gotoAdd(@RequestParam(value = "requestId", required = false) String requestId,
                          Model model) {
        List<Role> roles = roleService.getRoleList(requestId);
        List<Group> groups = groupService.getGroupList(requestId);
        model.addAttribute("roles", roles);
        model.addAttribute("groups", groups);
        return "user/register";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(User user,
                      @RequestParam(value = "requestId", required = false) String requestId) {
        log.info("{} --> add user : {}", requestId, user);
        userService.addUser(requestId, user);
        return "";
    }

    @RequestMapping(value = "/gotoUpdate", method = RequestMethod.POST)
    public String gotoUpdate(@RequestParam String roleId,
                             @RequestParam(value = "requestId", required = false) String requestId) {
        log.info("{} --> goto update role, roleId : {}", requestId, roleId);
        return "";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestBody User user,
                         @RequestParam(value = "requestId", required = false) String requestId) {
        log.info("{} -->update user : {}", requestId, user);
        userService.updateUser(requestId, user);
        return "";
    }

    @RequestMapping(value = "/delete")
    public String delete(@RequestParam("userId") String userId,
                         @RequestParam(value = "requestId", required = false) String requestId) {
        log.info("{} --> delete userId : {}", requestId, userId);
        userService.deleteUserById(requestId, userId);
        return "";
    }
}
