package net.harutiro.countapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import net.harutiro.countapp.databinding.ActivityMainBinding
import net.harutiro.countapp.model.CountType
import net.harutiro.countapp.model.Db
import net.harutiro.countapp.model.dao

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var db: Db
    lateinit var dao: dao


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Databaseの作成
        db = Room.databaseBuilder(
            this,
            Db::class.java,
            "uriage.db"
        ).build()
        dao = db.dao()

        GlobalScope.launch {
            val date = dao.getAll()

            if(date.isEmpty()){
                val karaage = CountType(
                    type = 1,
                    dateList = mutableListOf<String>(),
                    count = 0
                )
                dao.create(karaage)

                val pet = CountType(
                    type = 2,
                    dateList = mutableListOf<String>(),
                    count = 0
                )
                dao.create(pet)

                val potato = CountType(
                    type = 3,
                    dateList = mutableListOf<String>(),
                    count = 0
                )
                dao.create(potato)

            }else{
                binding.karaageText.text = date[0].count.toString()
                binding.petText.text = date[1].count.toString()
                binding.potatoText.text = date[2].count.toString()
            }
        }



        binding.potatoPulsButton.setOnClickListener{

        }
    }
}