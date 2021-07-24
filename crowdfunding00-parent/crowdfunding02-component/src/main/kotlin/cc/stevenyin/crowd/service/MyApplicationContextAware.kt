package cc.stevenyin.crowd

import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.stereotype.Component

@Component
class MyApplicationContextAware: ApplicationContextAware {
	override fun setApplicationContext(applicationContext: ApplicationContext?) {
		val beanDefinitionNames = applicationContext!!.getBeanDefinitionNames()
		beanDefinitionNames.forEach { println(it) }
	}
}