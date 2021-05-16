package nominate

import com.puravida.nominate.Team
import com.puravida.nominate.TeamCommand
import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured
import groovy.transform.CompileDynamic

class TeamController {

    static allowedMethods = [index: 'GET',save: 'POST',]
    SpringSecurityService springSecurityService

    static List<Team> teams = []

    def index() {
    }

    def list(){
        String username = loggedEmail()
        [teams : teams.findAll{ it.owner == username}]
    }

    @Secured('isAuthenticated()')
    def save(TeamCommand teamCommand){
        String username = loggedEmail()
        Team team = new Team(description: teamCommand.description,
                owner: username,
                uuid: UUID.randomUUID().toString(),
                rawmember: teamCommand.members.findAll{it}.unique().join('|')
        )
        team.save()
        teams.add( team )
        redirect uri:'/'
    }

    @Secured('isAuthenticated()')
    def delete(String uuid){
        def team = teams.find{ it.uuid==uuid}
        if(team) {
            team.delete()
            teams.remove(team)
        }
        redirect uri:'/'
    }

    @Secured('permitAll')
    def showDialog(String id){
        def team = teams.find{ it.uuid==id}
        if(!team){
            render view:'showDialog'
            return
        }
        def members = team.members
        Collections.shuffle(members)
        render view:'showDialog', model:[ team:team, members: members]
    }

    @CompileDynamic
    protected String loggedUsername() {
        springSecurityService.principal.username
    }

    @CompileDynamic
    protected String loggedEmail() {
        springSecurityService.principal.userProfile.email
    }
}
