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
                printTipAmount()
            }
        })

        slider.addOnChangeListener { slider, value, fromUser ->
            printTipAmount()
        }
    }

    fun printTipAmount() {
        if (edit_text.getText().isNotEmpty()) {
            val bill = edit_text.getText().toString().toDouble()
            val tipPercentage = slider.getValue()
            val tipAmount = bill * tipPercentage / 100.0
            val tipAmountFormatted = "%.2f".format(tipAmount)

            text_view.setText("Tip amount: $tipAmountFormatted")
        } else {
            text_view.setText("")
        }
    }
}