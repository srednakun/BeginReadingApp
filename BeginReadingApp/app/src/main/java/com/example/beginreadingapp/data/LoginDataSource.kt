package com.example.beginreadingapp.data

import com.example.beginreadingapp.data.model.LoggedInUser
import kotlinx.coroutines.test.withTestContext
import java.io.File
import java.io.IOException
import java.io.ObjectOutputStream
import java.io.PrintWriter

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    private val users: HashMap<String, String> = HashMap()
    val fileName = "/data/data/com.example.beginreadingapp/user_login_info"


    fun login(username: String, password: String): Result<LoggedInUser> {
        try {
            // TODO: handle loggedInUser authentication

            if(checkLogin(username, password)) {
                val username = LoggedInUser(java.util.UUID.randomUUID().toString(), username)
                return Result.Success(username)
            }
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
        return Result.Error(IOException("Error logging in"))
    }

    fun logout() {
        // TODO: revoke authentication
    }

    fun populateUserMap(){
        //populate the users map
        File(fileName).forEachLine {
            //println("here are files $it")
            val username = (it.substringBefore(" "))
            var password = (it.substringAfter(" "))
            //println("username $username")
            //println("password $password")
            //users[username] = password
            users[username] = password

        }
        println("user entries ${users.entries}")
    }
    fun createUser(username: String, password: String): Result<LoggedInUser> {

        //create the file
        if(!File(fileName).exists()){
            File(fileName).createNewFile()
        }

        //populate the users
        populateUserMap()


        //add the new user to the map
        users[username] = password
        //println("contains key ${users.containsKey(username)}" )
        //println("contains ${users.contains(username)}" )
        //println("users at username ${users[username] == password}" )
        //println("entries ${users.entries}" )
        //users.set(username,password)
        //File(fileName).writeText("username:" + username + "password:" + password)

        //add the new user to the file
        File(fileName).appendText("\n$username $password")

        //using write text overwrites the file
        //File(fileName).writeText("$username $password")
        val username = LoggedInUser(java.util.UUID.randomUUID().toString(), username)
        //File(fileName).forEachLine { println(it) }

        return Result.Success(username)
    }

    //check that the user exists and that the username matches the password
    fun checkLogin(username: String, password: String): Boolean{
        //populate the users
        populateUserMap()
        //println("users at username match ${users[username] == password}" )

        //println(users[username])
        //println("size of map = " + users.size)
        //println(users.entries)
        //users.forEach { (key, value) -> println("$key = $value") }
        return users[username] == password
    }


}