package uz.digital.taskapp

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import uz.digital.taskapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {



    private lateinit var binding: ActivityMainBinding
    var activities = mutableSetOf<String>()
    val adapterActivity = AdapterActivity()
    val dialog = AddActivityDialog()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        activities = PrefManager.getActivity(this)

        binding.rvActivity.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvActivity.adapter = adapterActivity


        adapterActivity.updateList(activities)

        binding.add.setOnClickListener {
            dialog.show(supportFragmentManager, "Add")
        }

        dialog.setOnDissmisLitener(DialogInterface.OnDismissListener {
            activities = PrefManager.getActivity(this)
            adapterActivity.updateList(activities)


        })




    }

}