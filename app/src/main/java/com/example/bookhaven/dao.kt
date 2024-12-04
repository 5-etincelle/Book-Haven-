package com.example.bookhaven

import com.example.bookhaven.data.Personne


class dao ( val pers : MutableList<Personne>)
{
    fun check(nom: String, password: String): Boolean {
        for (person in pers) {
            if (person.userName == nom && person.passWord == password) {
                return true
            }
        }
        return false
    }
}