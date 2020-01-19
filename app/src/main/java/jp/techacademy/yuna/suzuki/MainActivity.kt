package jp.techacademy.yuna.suzuki

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.app.TimePickerDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.button1 -> showTimePickerDialog()
        }
    }

    private fun showTimePickerDialog() {
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { view, hour, minute ->
                Log.d("UI_PARTS", "$hour:$minute")
                textView.text = hour.toString()
                if (hour >= 2 && hour <= 9 ){
                    textView.text = "おはよう"
                } else if (hour >= 10 &&  hour <= 17){
                    textView.text = "こんにちは"
                } else if ((hour >= 18 && hour <= 24)|| (hour >= 9 && hour <= 1)){
                    textView.text = "こんばんは"
                } else {
                    textView.text = "正しく値が設定されていない可能性があります"
                }

            },
            13, 0, true)


        timePickerDialog.show()
    }

}
