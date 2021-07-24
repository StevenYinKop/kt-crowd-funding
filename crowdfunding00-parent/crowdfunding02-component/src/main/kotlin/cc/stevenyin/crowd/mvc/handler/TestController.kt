package cc.stevenyin.crowd.mvc.handler

import cc.stevenyin.crowd.service.api.TestService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class TestController {
    @Autowired
    private lateinit var testService: TestService

    @RequestMapping("/test/ssm.html")
    fun ssm(mm: ModelMap): String {
        val list = testService.findAll()
        mm.addAttribute("list", list)
        return "result"
    }
}