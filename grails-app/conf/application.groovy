import grails.core.GrailsApplication
import grails.util.Holders

grails.plugin.springsecurity.controllerAnnotations.staticRules = [
        [pattern: '/',               access: ['permitAll']],
        [pattern: '/error',          access: ['permitAll']],
        [pattern: '/index',          access: ['permitAll']],
        [pattern: '/index.gsp',      access: ['permitAll']],
        [pattern: '/shutdown',       access: ['permitAll']],
        [pattern: '/assets/**',      access: ['permitAll']],
        [pattern: '/**/js/**',       access: ['permitAll']],
        [pattern: '/**/css/**',      access: ['permitAll']],
        [pattern: '/**/images/**',   access: ['permitAll']],
        [pattern: '/**/favicon.ico', access: ['permitAll']]
]

grails {
    plugin {
        springsecurity {
            rest {
                token {
                    validation {
                        useBearerToken = false
                        enableAnonymousAccess = true
                    }
                    storage {
                        jwt {
                            secret = 'foobar123'*4
                        }
                    }
                }
                oauth {
                    frontendCallbackUrl = { String tokenValue ->
                        "${Holders.grailsApplication.config.grails.serverURL}/auth/success?token=${tokenValue}"
                    }
                    google {
                        client = org.pac4j.oauth.client.Google2Client
                        key = '9399787043-tnbujcvr5fcdhnj0g93o03tlm7lurg4f.apps.googleusercontent.com'
                        secret = 'oU4EOSQ2-8pW7Re-YcMxPK0R'
                        scope = org.pac4j.oauth.client.Google2Client.Google2Scope.EMAIL_AND_PROFILE
                        defaultRoles = []
                    }
                }
            }
            providerNames = ['anonymousAuthenticationProvider']
        }
    }
}

String ANONYMOUS_FILTERS = 'anonymousAuthenticationFilter,restTokenValidationFilter,restExceptionTranslationFilter,filterInvocationInterceptor'
grails.plugin.springsecurity.filterChain.chainMap = [
        [pattern: '/dbconsole/**',      filters: 'none'],
        [pattern: '/assets/**',      filters: 'none'],
        [pattern: '/**/js/**',       filters: 'none'],
        [pattern: '/**/css/**',      filters: 'none'],
        [pattern: '/**/images/**',   filters: 'none'],
        [pattern: '/**/favicon.ico', filters: 'none'],
        [pattern: '/', filters: ANONYMOUS_FILTERS],
        [pattern: '/team/*', filters: ANONYMOUS_FILTERS],
        [pattern: '/auth/success', filters: ANONYMOUS_FILTERS],
        [pattern: '/oauth/authenticate/google', filters: ANONYMOUS_FILTERS],
        [pattern: '/oauth/callback/google', filters: ANONYMOUS_FILTERS],
        [pattern: '/**', filters: 'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter,-rememberMeAuthenticationFilter'],
]

grails.plugin.springsecurity.logout.handlerNames = ['rememberMeServices', 'securityContextLogoutHandler', 'cookieClearingLogoutHandler']