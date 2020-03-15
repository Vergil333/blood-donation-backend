package com.martinmachava.blooddonation.backend.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.filter.AbstractRequestLoggingFilter
import javax.servlet.http.HttpServletRequest

/**
 * Log every request IN and OUT of REST API
 */
@Component
class LoggingFilter: AbstractRequestLoggingFilter() {

    @Value("\${request.logging.shouldLog}")
    var shouldLog: Boolean = false

    init {
        setIncludeClientInfo(true)
        setIncludeHeaders(true)
        setIncludePayload(true)
        setIncludeQueryString(true)
        setBeforeMessagePrefix("Request started => ")
        setAfterMessagePrefix("Request ended => ")
    }

    override fun shouldLog(request: HttpServletRequest): Boolean = shouldLog

    override fun beforeRequest(p0: HttpServletRequest, p1: String) = logger.info(p1)

    override fun afterRequest(p0: HttpServletRequest, p1: String) = logger.info(p1)

}