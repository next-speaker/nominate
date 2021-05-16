package nominate

import com.puravida.nominate.JwtCookieTokenReader
import grails.config.Config
import grails.core.support.GrailsConfigurationAware
import grails.plugin.springsecurity.annotation.Secured
import grails.plugin.springsecurity.rest.token.reader.TokenReader
import groovy.util.logging.Slf4j
import javax.servlet.http.Cookie

@Slf4j
class AuthController implements GrailsConfigurationAware {

    TokenReader tokenReader

    int jwtExpiration

    String grailsServerUrl

    static allowedMethods = [
            success: 'GET',
            logout: 'POST'
    ]

    @Secured('permitAll')
    def success(String token) {
        log.debug('token value {}', token)
        if (token) {
            Cookie cookie = jwtCookie(token)
            response.addCookie(cookie)
        }
        [grailsServerUrl: grailsServerUrl]
    }

    protected Cookie jwtCookie(String tokenValue) {
        Cookie jwtCookie = new Cookie( cookieName(), tokenValue )
        jwtCookie.maxAge = jwtExpiration
        jwtCookie.path = '/'
        jwtCookie.setHttpOnly(true)
        if ( httpOnly() ) {
            jwtCookie.setSecure(true)
        }
        jwtCookie
    }

    @Override
    void setConfiguration(Config co) {
        jwtExpiration = co.getProperty('grails.plugin.springsecurity.rest.token.storage.memcached.expiration', Integer, 3600)
        grailsServerUrl = co.getProperty('grails.serverURL', String)
    }

    protected boolean httpOnly() {
        grailsServerUrl?.startsWith('https')
    }

    protected String cookieName() {
        if ( tokenReader instanceof JwtCookieTokenReader ) {
            return ((JwtCookieTokenReader) tokenReader).cookieName
        }
        return 'jwt'
    }
}
