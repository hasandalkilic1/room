package eu.tutorials.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var db:RoomDb
    private lateinit var pDao:personDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db=RoomDb.accessDb(this)!!
        pDao= db.getPersonDao()

        //deletePerson()
        //updatePerson()
        //addPerson()
        //getAllPerson()
        //getRandomPerson()
        //getSearchedPersons()
        //getSpecifiedPerson()
        //getMultiplePerson()

    }

    fun getAllPerson(){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val personList=pDao.allPerson()

            for(j in personList){
                Log.e("person_id",j.id.toString())
                Log.e("person_name",j.name)
                Log.e("person_age",j.age.toString())
            }
        }
    }

    fun addPerson(){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val newPerson=personEntity(0,"ahmet",18)
            pDao.addPerson(newPerson)
        }
    }

    fun updatePerson(){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val updatedPerson=personEntity(20,"yeni deneme",48)
            pDao.updatePerson(updatedPerson)
        }
    }

    fun deletePerson(){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val deletedPerson=personEntity(20,"",0)
            pDao.deletePerson(deletedPerson)
        }
    }

    fun getRandomPerson(){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val personList=pDao.randomPerson()

            for(j in personList){
                Log.e("person_id",j.id.toString())
                Log.e("person_name",j.name)
                Log.e("person_age",j.age.toString())
            }
        }
    }

    fun getSearchedPersons(){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val personList=pDao.searchPerson("e")

            for(j in personList){
                Log.e("person_id",j.id.toString())
                Log.e("person_name",j.name)
                Log.e("person_age",j.age.toString())
            }
        }
    }

    fun getSpecifiedPerson(){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val person=pDao.getPerson(8)

            Log.e("person_id",person.id.toString())
            Log.e("person_name",person.name)
            Log.e("person_age",person.age.toString())

        }
    }


    fun getMultiplePerson(){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val personCount=pDao.getMultiplePerson("ahmet")

            Log.e("sameSearchedNameNumber",personCount.toString())


        }
    }
}