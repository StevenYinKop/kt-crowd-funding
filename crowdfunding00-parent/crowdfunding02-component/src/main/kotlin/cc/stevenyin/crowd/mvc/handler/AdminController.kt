package cc.stevenyin.crowd.mvc.handler

import cc.stevenyin.crowd.Constants
import cc.stevenyin.crowd.entity.AdminRecord
import cc.stevenyin.crowd.service.api.AdminService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.http.HttpSession

@Controller
class AdminController {
    @Autowired
    private lateinit var adminService: AdminService



    @GetMapping("/login-check.html")
    fun loginCheck(hs: HttpSession): String {
        return if (hs.getAttribute(Constants.ADMIN_SESSION_KEY) == null) "redirect:/admin/to/login.html" else "redirect:/admin/main.html"
    }

//    <mvc:view-controller path="/admin/to/login.html" view-name="admin-login" />
    @GetMapping("/admin/to/login.html")
    fun toLoginPage(model: Model):String {
        model.addAttribute("admin", AdminRecord())
        return "admin-login"
    }
    @PostMapping("/admin/login.json")
    fun login(@ModelAttribute("admin") adminRecord: AdminRecord): String {
        adminService.doLogin(adminRecord)
        return "redirect:/admin/main.html"
    }

    @RequestMapping("/test/ssm.html")
    fun ssm(mm: ModelMap): String {
        val list = adminService.findAll()
        mm.addAttribute("list", list)
        return "result"
    }
}