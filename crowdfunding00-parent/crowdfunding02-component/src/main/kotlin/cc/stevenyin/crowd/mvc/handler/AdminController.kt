package cc.stevenyin.crowd.mvc.handler

import cc.stevenyin.crowd.Constants
import cc.stevenyin.crowd.entity.AdminRecord
import cc.stevenyin.crowd.service.api.AdminService
import com.github.pagehelper.PageInfo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import javax.servlet.http.HttpSession

@Controller
class AdminController {
    @Autowired
    private lateinit var adminService: AdminService

    @GetMapping("/login-check.html")
    fun loginCheck(hs: HttpSession): String {
        return if (hs.getAttribute(Constants.ADMIN_SESSION_KEY) == null) "redirect:/admin/to/login.html" else "redirect:/admin/main.html"
    }

    @GetMapping("/admin/to/login.html")
    fun toLoginPage(model: Model): String {
        model.addAttribute("admin", AdminRecord())
        return "admin-login"
    }

    @GetMapping("/admin/user.html")
    fun toUserPage(
        @RequestParam(value = "pageNum", defaultValue = "1") pageNum: Integer,
        @RequestParam(value = "pageSize", defaultValue = "10") pageSize: Integer,
        @RequestParam(value = "keyword", defaultValue = "") keyword: String,
        modelMap: ModelMap
    ): String {
        val pageInfo: PageInfo<AdminRecord> = adminService.getUser(keyword, pageNum, pageSize)
        modelMap.addAttribute("adminRecordList", pageInfo.list)
        modelMap.addAttribute("pageInfo", pageInfo)
        modelMap.addAttribute("keyword", keyword)
        modelMap.addAttribute("pageSize", pageSize)
        modelMap.addAttribute("pageNum", pageNum)
        return "user-management"
    }

    @GetMapping("/admin/role.html")
    fun toRolePage(): String {
        return "role-management"
    }

    @GetMapping("/admin/menu.html")
    fun toMenuPage(): String {
        return "menu-management"
    }

    @PostMapping("/admin/login.json")
    fun login(@ModelAttribute("admin") adminRecord: AdminRecord): String {
        adminService.doLogin(adminRecord)
        return "redirect:/admin/main.html"
    }
}