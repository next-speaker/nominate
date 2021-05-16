// Place your Spring DSL code here
import com.puravida.nominate.JwtCookieTokenReader
import org.springframework.security.web.authentication.logout.CookieClearingLogoutHandler
beans = {

    tokenReader(JwtCookieTokenReader) {
        cookieName = 'jwt'
    }
    cookieClearingLogoutHandler(CookieClearingLogoutHandler, ['jwt'])
}
