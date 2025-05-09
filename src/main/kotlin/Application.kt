package com.example

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        module()  // вызов функции-модуля ниже
    }.start(wait = true)
}

fun Application.module() {
    // Обратите внимание: здесь не нужно создавать новый embeddedServer,
    // так как сервер уже запущен в main.
    routing {
        get("/") {
            call.respondText("<h1>Hello, World!</h1>")
        }
    }
}