package io.undertree.goodbye

import org.springframework.context.annotation.Import

@Target(AnnotationTarget.CLASS, AnnotationTarget.FILE)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Import(GoodbyeConfig::class)
annotation class EnableGoodbyeComponent
