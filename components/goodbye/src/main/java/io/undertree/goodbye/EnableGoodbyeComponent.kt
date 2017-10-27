package io.undertree.goodbye

import org.springframework.context.annotation.Import
import java.lang.annotation.Inherited

@Target(AnnotationTarget.CLASS, AnnotationTarget.FILE)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Inherited
@Import(GoodbyeConfig::class)
annotation class EnableGoodbyeComponent
