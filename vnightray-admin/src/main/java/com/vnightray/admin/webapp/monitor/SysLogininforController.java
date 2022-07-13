package com.vnightray.admin.webapp.monitor;

import com.vnightray.common.annotation.Log;
import com.vnightray.common.core.controller.BaseController;
import com.vnightray.common.core.domain.AjaxResult;
import com.vnightray.common.core.page.TableDataInfo;
import com.vnightray.common.enums.BusinessOpsType;
import com.vnightray.common.utils.poi.ExcelUtil;
import com.vnightray.system.domain.SysLoginInfor;
import com.vnightray.system.service.ISysLoginInforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 系统访问记录
 */
@RestController
@RequestMapping("/monitor/logininfor")
public class SysLogininforController extends BaseController
{
    @Autowired
    private ISysLoginInforService loginInforService;

    @PreAuthorize("@ss.hasPermi('monitor:logininfor:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysLoginInfor logininfor)
    {
        startPage();
        List<SysLoginInfor> list = loginInforService.selectLogininforList(logininfor);
        return getDataTable(list);
    }

    @Log(title = "登录日志", businessType = BusinessOpsType.EXPORT)
    @PreAuthorize("@ss.hasPermi('monitor:logininfor:export')")
    @GetMapping("/export")
    public AjaxResult export(SysLoginInfor logininfor)
    {
        List<SysLoginInfor> list = loginInforService.selectLogininforList(logininfor);
        ExcelUtil<SysLoginInfor> util = new ExcelUtil<SysLoginInfor>(SysLoginInfor.class);
        return util.exportExcel(list, "登录日志");
    }

    @PreAuthorize("@ss.hasPermi('monitor:logininfor:remove')")
    @Log(title = "登录日志", businessType = BusinessOpsType.DELETE)
    @DeleteMapping("/{infoIds}")
    public AjaxResult remove(@PathVariable Long[] infoIds)
    {
        return toAjax(loginInforService.deleteLogininforByIds(infoIds));
    }

    @PreAuthorize("@ss.hasPermi('monitor:logininfor:remove')")
    @Log(title = "登录日志", businessType = BusinessOpsType.CLEAN)
    @DeleteMapping("/clean")
    public AjaxResult clean()
    {
        loginInforService.cleanLogininfor();
        return AjaxResult.success();
    }
}
