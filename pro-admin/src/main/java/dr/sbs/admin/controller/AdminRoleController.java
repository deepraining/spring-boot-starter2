package dr.sbs.admin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import dr.sbs.admin.service.AdminRoleService;
import dr.sbs.common.CommonPage;
import dr.sbs.common.CommonResult;
import dr.sbs.mp.entity.AdminMenu;
import dr.sbs.mp.entity.AdminResource;
import dr.sbs.mp.entity.AdminRole;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/** 后台用户角色管理 */
@Controller
@Api(tags = "AdminRoleController", description = "后台用户角色管理")
@RequestMapping("/adminRole")
public class AdminRoleController {
  @Autowired private AdminRoleService roleService;

  @ApiOperation("添加角色")
  @RequestMapping(value = "/create", method = RequestMethod.POST)
  @ResponseBody
  public CommonResult<Integer> create(
      @RequestBody @Validated AdminRole role, BindingResult bindingResult) {
    boolean result = roleService.create(role);
    if (result) {
      return CommonResult.success(1);
    }
    return CommonResult.failed();
  }

  @ApiOperation("修改角色")
  @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
  @ResponseBody
  public CommonResult<Integer> update(
      @PathVariable Integer id, @RequestBody @Validated AdminRole role, BindingResult bindingResult) {
    boolean result = roleService.update(id, role);
    if (result) {
      return CommonResult.success(1);
    }
    return CommonResult.failed();
  }

  @ApiOperation("批量删除角色")
  @RequestMapping(value = "/delete", method = RequestMethod.POST)
  @ResponseBody
  public CommonResult<Integer> delete(@RequestParam("ids") List<Integer> ids) {
    boolean result = roleService.delete(ids);
    if (result) {
      return CommonResult.success(1);
    }
    return CommonResult.failed();
  }

  @ApiOperation("获取所有角色")
  @RequestMapping(value = "/listAll", method = RequestMethod.GET)
  @ResponseBody
  public CommonResult<List<AdminRole>> listAll() {
    List<AdminRole> roleList = roleService.list();
    return CommonResult.success(roleList);
  }

  @ApiOperation("根据角色名称分页获取角色列表")
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  @ResponseBody
  public CommonResult<CommonPage<AdminRole>> list(
      @RequestParam(value = "keyword", required = false) String keyword,
      @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
      @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
    Page<AdminRole> roleList = roleService.list(keyword, pageSize, pageNum);
    return CommonResult.success(CommonPage.toPage(roleList));
  }

  @ApiOperation("修改角色状态")
  @RequestMapping(value = "/updateStatus/{id}", method = RequestMethod.POST)
  @ResponseBody
  public CommonResult<Integer> updateStatus(
      @PathVariable Integer id, @RequestParam(value = "status") Integer status) {
    AdminRole adminRole = new AdminRole();
    adminRole.setStatus(status);
    boolean result = roleService.update(id, adminRole);
    if (result) {
      return CommonResult.success(1);
    }
    return CommonResult.failed();
  }

  @ApiOperation("获取角色相关菜单")
  @RequestMapping(value = "/listMenu/{roleId}", method = RequestMethod.GET)
  @ResponseBody
  public CommonResult<List<AdminMenu>> listMenu(@PathVariable Integer roleId) {
    List<AdminMenu> roleList = roleService.listMenu(roleId);
    return CommonResult.success(roleList);
  }

  @ApiOperation("获取角色相关资源")
  @RequestMapping(value = "/listResource/{roleId}", method = RequestMethod.GET)
  @ResponseBody
  public CommonResult<List<AdminResource>> listResource(@PathVariable Integer roleId) {
    List<AdminResource> roleList = roleService.listResource(roleId);
    return CommonResult.success(roleList);
  }

  @ApiOperation("给角色分配菜单")
  @RequestMapping(value = "/allocMenu", method = RequestMethod.POST)
  @ResponseBody
  public CommonResult<Integer> allocMenu(
      @RequestParam Integer roleId, @RequestParam List<Integer> menuIds) {
    boolean result = roleService.allocMenu(roleId, menuIds);
    return CommonResult.success(1);
  }

  @ApiOperation("给角色分配资源")
  @RequestMapping(value = "/allocResource", method = RequestMethod.POST)
  @ResponseBody
  public CommonResult<Integer> allocResource(
      @RequestParam Integer roleId, @RequestParam List<Integer> resourceIds) {
    boolean result = roleService.allocResource(roleId, resourceIds);
    return CommonResult.success(1);
  }
}
