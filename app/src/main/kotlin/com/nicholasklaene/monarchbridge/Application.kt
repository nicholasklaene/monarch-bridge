package com.nicholasklaene.monarchbridge

import com.nicholasklaene.monarchbridge.auth.MonarchBootstrapMain
import com.nicholasklaene.monarchbridge.config.MonarchProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(MonarchProperties::class)
class Application

// Token that routes `java -jar app.jar` into the interactive Monarch auth bootstrap instead
// of starting the web server. Lets the Docker image / Homebrew / install.sh expose a single
// jar for both `serve` and `bootstrap` flows.
private const val BOOTSTRAP_FLAG = "--bootstrap-monarch"
private const val BOOTSTRAP_SUBCOMMAND = "bootstrap"

@Suppress("SpreadOperator")
fun main(args: Array<String>) {
    if (BOOTSTRAP_FLAG in args || args.firstOrNull() == BOOTSTRAP_SUBCOMMAND) {
        val forwarded = args.filterNot { it == BOOTSTRAP_FLAG || it == BOOTSTRAP_SUBCOMMAND }
        MonarchBootstrapMain.main(forwarded.toTypedArray())
        return
    }
    runApplication<Application>(*args)
}
