package com.puravida.nominate

import grails.validation.Validateable


class TeamCommand implements Validateable{
    String description
    List<String> members =[]
}
