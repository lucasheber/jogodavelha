package lucasheber.com.jogodavelha

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.style.TypefaceSpan
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.core.content.res.ResourcesCompat
import java.util.ArrayList

data class Velha(var message: String = "Deu Velha!")

class MainActivity : AppCompatActivity() {

    private var player: Int = 1

    private val listWins = listOf(
        listOf(1,2,3), listOf(4,5,6), listOf(7,8,9),
        listOf(1,4,7), listOf(8,5,2), listOf(9,6,3),
        listOf(1,5,9), listOf(7,5,3)
    )

    private var listPlayerOne = ArrayList<Int>()
    private var listPlayerTwo = ArrayList<Int>()

    // adicionado o estilo da fonte
    var face = Typeface.DEFAULT

    override fun onCreate(savedInstanceState: Bundle?) {
        face = ResourcesCompat.getFont(this, R.font.bowlby_one)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun move(pos: Int, btn: Button) {
        btn.setTextColor(Color.WHITE)
        btn.textSize = 40F
        btn.typeface = face

        if (player == 1) {
            player = 2
            listPlayerOne.add(pos)
            btn.text = "X"
            btn.setBackgroundResource(R.color.playerOne)
        } else {
            player = 1
            listPlayerTwo.add(pos)
            btn.text = "O"
            btn.setBackgroundResource(R.color.playerTwo)

        }

        btn.isClickable = false
        checkWinner()
    }

    // click button
    fun clickButton(view: View) = move(view.tag.toString().toInt(), view as Button)

    private fun checkWinner() {

       if (isWinner(listPlayerOne)) {
           gameOver(Velha("Player One (X) Winner!"))
       } else if (isWinner(listPlayerTwo)) {
           gameOver(Velha("Player Two (O) Winner!"))
       } else if (listPlayerOne.size + listPlayerTwo.size == 9) {
           gameOver(Velha())
       }
    }

    private fun isWinner(list: List<Int>): Boolean {

        listWins.forEach {
            if (list.containsAll(it)) return true
        }

        return false
    }

    private fun gameOver(velha: Velha) {
        val intent = Intent(this, Winner::class.java)
        intent.putExtra("velha", velha.message)

        startActivity(intent)
    }
}
