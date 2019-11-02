package lucasheber.com.jogodavelha

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.style.TypefaceSpan
import android.view.View
import android.widget.Button
import androidx.core.content.res.ResourcesCompat

class MainActivity : AppCompatActivity() {

    private var player: Int = 1

    private val posWins = listOf(
        listOf(1,2,3), listOf(4,5,6), listOf(7,8,9),
        listOf(1,4,7), listOf(8,5,2), listOf(9,6,3),
        listOf(1,5,9), listOf(7,5,3)
    )

    // adicionado o estilo da fonte
    var face = Typeface.DEFAULT


    override fun onCreate(savedInstanceState: Bundle?) {
        face = ResourcesCompat.getFont(this, R.font.bowlby_one)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun velha(pos: Int, btn: Button) {

    }

    // click button
    fun clickButton(view: View) = velha(view.tag.toString().toInt(), view as Button)
}
