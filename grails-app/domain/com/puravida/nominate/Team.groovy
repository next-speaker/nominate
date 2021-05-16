package com.puravida.nominate
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class Team {

    String owner
    String description
    String uuid
    String rawmember

    Date dateCreated
    Date lastUpdated

    List<String>getMembers(){
        (rawmember ?: "").split('\\|') as List<String>
    }

    static constraints = {
        owner email: true
        rawmember maxSize: 1024
    }
    static mapping = {
        owner index: 'owner_idx'
    }
}
