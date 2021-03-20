import android.R
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    //Davit jan knayes mi hat activity_second@ chi tenum
    //mekel x,o image-ner@ chi tenum

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }

    var gameActive = true
    var activePlayer = 0
    var gameState = intArrayOf(2, 2, 2, 2, 2, 2, 2, 2, 2)

    var winPositions = arrayOf(intArrayOf(0, 1, 2), intArrayOf(3, 4, 5),
            intArrayOf(6, 7, 8), intArrayOf(0, 3, 6), intArrayOf(1, 4, 7),
            intArrayOf(2, 5, 8), intArrayOf(0, 4, 8), intArrayOf(2, 4, 6))

    fun playerTap(view: View) {
        val img = view as ImageView
        val tappedImage = img.tag.toString().toInt()

        if (gameState[tappedImage] == 2) {
            counter++

            if (counter == 9) {
                gameActive = false
            }

            gameState[tappedImage] = activePlayer
            img.translationY = -1000f

            if (activePlayer == 0) {
                img.setImageResource(R.drawable.x)
                activePlayer = 1

            } else {
                img.setImageResource(R.drawable.o)
                activePlayer = 0
            }
            img.animate().translationYBy(1000f).duration = 300
        }
        var flag = 0
        for (winPosition in winPositions) {
            if (gameState[winPosition[0]] == gameState[winPosition[1]] && gameState[winPosition[1]] == gameState[winPosition[2]] && gameState[winPosition[0]] != 2) {
                flag = 1
                gameActive = false
                var winnerStr: String = if (gameState[winPosition[0]] == 0) {
                    "X has won"
                } else {
                    "O has won"
                }
                val status = findViewById<TextView>(R.id.status)
                status.text = winnerStr
            }
        }
        if (counter == 9 && flag == 0) {
            val status = findViewById<TextView>(R.id.status)
            status.text = "Match Draw"
        }


        (findViewById<View>(R.id.image1) as ImageView).setImageResource(0)
        (findViewById<View>(R.id.image2) as ImageView).setImageResource(0)
        (findViewById<View>(R.id.image3) as ImageView).setImageResource(0)
        (findViewById<View>(R.id.image4) as ImageView).setImageResource(0)
        (findViewById<View>(R.id.image5) as ImageView).setImageResource(0)
        (findViewById<View>(R.id.image6) as ImageView).setImageResource(0)
        (findViewById<View>(R.id.image7) as ImageView).setImageResource(0)
        (findViewById<View>(R.id.image8) as ImageView).setImageResource(0)
        (findViewById<View>(R.id.image9) as ImageView).setImageResource(0)
        val status = findViewById<TextView>(R.id.status)
        status.text = "X's Turn - Tap to play"


    }

    companion object {
        var counter = 0
    }
}

