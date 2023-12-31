package dr.sbs.admin.controller;

import dr.sbs.admin.service.AdminResourceCategoryService;
import dr.sbs.common.CommonResult;
import dr.sbs.mp.entity.AdminResourceCategory;
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
import org.springframework.web.bind.annotation.ResponseBody;

/** 后台资源分类管理 */
@Controller
@Api(tags = "AdminResourceCategoryController", description = "后台资源分类管理")
@RequestMapping("/adminResourceCategory")
public class AdminResourceCategoryController {
  @Autowired private AdminResourceCategoryService resourceCategoryService;

  @ApiOperation("查询所有后台资源分类")
  @RequestMapping(value = "/listAll", method = RequestMethod.GET)
  @ResponseBody
  public CommonResult<List<AdminResourceCategory>> listAll() {
    List<AdminResourceCategory> resourceList = resourceCategoryService.listAll();
    return CommonResult.success(resourceList);
  }

  @ApiOperation("添加后台资源分类")
  @RequestMapping(value = "/create", method = RequestMethod.POST)
  @ResponseBody
  public CommonResult<Integer> create(
      @RequestBody @Validated AdminResourceCategory adminResourceCategory,
      BindingResult bindingResult) {
    boolean result = resourceCategoryService.create(adminResourceCategory);
    if (result) {
      return CommonResult.success(1);
    } else {
      return CommonResult.failed();
    }
  }

  @ApiOperation("修改后台资源分类")
  @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
  @ResponseBody
  public CommonResult<Integer> update(
      @PathVariable Integer id,
      @RequestBody @Validated AdminResourceCategory adminResourceCategory,
      BindingResult bindingResult) {
    boolean result = resourceCategoryService.update(id, adminResourceCategory);
    if (result) {
      return CommonResult.success(1);
    } else {
      return CommonResult.failed();
    }
  }

  @ApiOperation("根据ID删除后台资源")
  @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
  @ResponseBody
  public CommonResult<Integer> delete(@PathVariable Integer id) {
    boolean result = resourceCategoryService.delete(id);
    if (result) {
      return CommonResult.success(1);
    } else {
      return CommonResult.failed();
    }
  }
}
