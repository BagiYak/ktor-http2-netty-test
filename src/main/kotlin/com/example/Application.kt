package com.example

import com.example.plugins.configureRouting
import com.example.plugins.configureTemplating
import io.ktor.application.*
import io.ktor.network.tls.certificates.*
import io.ktor.server.engine.*
import org.slf4j.LoggerFactory
import java.io.File

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {

    val keyStoreFile = File("build/keystore.jks")
    val keystore = generateCertificate(
        file = keyStoreFile,
        keyAlias = "sampleAlias",
        keyPassword = "foobar",
        jksPassword = "foobar"
    )
//    val environment = applicationEngineEnvironment {
//        log = LoggerFactory.getLogger("ktor.application")
//        connector {
//            port = 8080
//        }
//        sslConnector(
//            keyStore = keystore,
//            keyAlias = "sampleAlias",
//            keyStorePassword = { "foobar".toCharArray() },
//            privateKeyPassword = { "foobar".toCharArray() }) {
//            port = 8443
//            keyStorePath = keyStoreFile
//        }
//        module(Application::module)
//    }

    configureRouting()
    configureTemplating()
}
