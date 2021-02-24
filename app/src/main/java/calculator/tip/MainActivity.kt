package calculator.tip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.roundToInt


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edit_text.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                printBill()
            }
        })

        slider.addOnChangeListener { slider, value, fromUser ->
            printBill()
        }
    }

    fun printBill() {
        val bill = edit_text.getText()
        val tipPercentage = slider.getValue().roundToInt()

        if (bill.isNotEmpty()) {
            text_view.setText("Bill value: $bill, tip percentage: $tipPercentage%")
        } else {
            text_view.setText("")
        }
    }
}