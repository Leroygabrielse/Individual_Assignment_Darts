package com.leroygabrielse.dartsapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_game.*
import kotlinx.android.synthetic.main.activity_pre_game.*
import java.time.LocalDate
import kotlin.math.roundToInt

const val GAMESTATS_REQUEST_CODE = 400
const val ENDGAMESTATS_REQUEST_CODE = 600
const val EXTRA_ENDGAME = "EXTRA_ENDGAME"
var playerTurn = 0
var tempScore = 0
var numberOfLegs = ""


class GameActivity : AppCompatActivity() {

    private val viewModel: GameActivityViewModel by viewModels()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()
        initViews()
    }
    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("ResourceAsColor")
    private fun initViews(){

        val bundle: Bundle? = intent.extras
        bundle?.let{
            bundle.apply {
                val game: Game? = getParcelable("EXTRA_GAME_DATA")
                if (game != null){
                    tvGameName.text = "${game.GameName}"
                    tvNameP1.text = "${game.playerOneName}"
                    tvNameP2.text = "${game.playerTwoName}"
                    numberOfLegs = "${game.numberOfLegsOrSets}"
                }
            }
        }

        tvThrownP1.setText("Darts: 0")
        tvThrownP2.setText("Darts: 0")
        tvAvgP1.setText("Avg: 0")
        tvAvgP2.setText("Avg: 0")

        tvHintP1.visibility = View.INVISIBLE
        tvHintP2.visibility = View.INVISIBLE

        btnStats.setOnClickListener {view->
            val intent = Intent(this, StatsActivity::class.java)
            startActivityForResult(intent,
                GAMESTATS_REQUEST_CODE
            )
        }
        btnEnter.setOnClickListener {
            if(tvScoreInput.text.toString().toInt() < 181){
                if(playerTurn.equals(0)){
                    handleEnter(tvScoreP1, tvAvgP1, tvThrownP1, tvLegsP1, tvNameP1)

                    tvScoreInput.setText("0")
                    ivTurnP1.visibility = View.INVISIBLE
                    ivTurnP2.visibility = View.VISIBLE
                    playerTurn += 1
                }
                else {
                    handleEnter(tvScoreP2, tvAvgP2, tvThrownP2, tvLegsP2, tvNameP2)
                    tvScoreInput.setText("0")
                    ivTurnP2.visibility = View.INVISIBLE
                    ivTurnP1.visibility = View.VISIBLE
                    playerTurn -= 1

                }
            }

        }
        btnOne.setOnClickListener {
            enterNumber("1")
        }
        btnTwo.setOnClickListener {
            enterNumber("2")
        }
        btnThree.setOnClickListener {
            enterNumber("3")
        }
        btnFour.setOnClickListener {
            enterNumber("4")
        }
        btnFive.setOnClickListener {
            enterNumber("5")
        }
        btnSix.setOnClickListener {
            enterNumber("6")
        }
        btnSeven.setOnClickListener {
            enterNumber("7")
        }
        btnEight.setOnClickListener {
            enterNumber("8")
        }
        btnNine.setOnClickListener {
            enterNumber("9")
        }
        btnZero.setOnClickListener {
            enterNumber("0")
        }

        btnBackspace.setOnClickListener {
            if(tvScoreInput.text.toString().length > 1){
                val newScore = tvScoreInput.text.toString().substring(0, tvScoreInput.text.toString().length - 1)
                tvScoreInput.setText(newScore)
            }
            else if (tvScoreInput.text.toString().length == 1){
                tvScoreInput.setText("0")
            }

        }
        btnUndo.setOnClickListener {
            /*if(tvScoreP1.text.toString().toInt() != 501 && tvScoreP2.text.toString().toInt() != 501 ){
                if (playerTurn.equals(0)){
                    undoScore(tvScoreP2, tvAvgP2, tvThrownP2)
                    playerTurn += 1
                }
                else {
                    undoScore(tvScoreP1, tvAvgP1, tvThrownP1)
                    playerTurn -= 1
                }
            }*/

        }

    }
    fun enterNumber(number: String){
        val score = tvScoreInput.text.toString()
        if (score.toInt()<=18){
            if (score == "0"){
                tvScoreInput.setText(number)
            }
            else {
                tvScoreInput.setText(score + number)
            }
        }
    }
    @RequiresApi(Build.VERSION_CODES.O)
    private fun handleEnter(textView: TextView, textView2: TextView, textView3: TextView, textView4: TextView, textView5: TextView){

        //Score substract
        textView.setText(
            (textView.text.toString().toInt() - tvScoreInput.text.toString().toInt()).toString()
        )

        //DartsThrown
        textView3.setText(
            ("Darts: " + (textView3.text.toString().substring(7).toInt() + 3).toString())
        )
        //Avg
        val totalScore = 501 - textView.text.toString().toDouble()
        val totalTurns = textView3.text.toString().substring(7).toInt() / 3

        textView2.setText(
            "Avg: " + Math.round(totalScore/totalTurns * 100) / 100.0
        )
        //set temporary value for the undoscore function
        tempScore = tvScoreInput.text.toString().toInt()
        if(textView.text.toString() == "0"){
            textView4.setText(
                (textView4.text.toString().toInt() + 1).toString()
            )
            if(textView4.text.toString().toInt() == numberOfLegs.toInt()){
                gameEnd()
            }else{
                resetLeg(textView5)
            }

        }
    }
    @SuppressLint("SetTextI18n")
    private fun undoScore(textView: TextView, textView2: TextView, textView3: TextView){
        //set score back
        textView.setText(
            textView.text.toString().toInt() + tempScore
        )
        //set thrown dartsback
        textView3.setText(
            "Darts: " + ((textView3.text.toString().substring(7).toInt()) + 3)
        )
        val totalScore = 501 - textView.text.toString().toDouble()
        val totalTurns = textView3.text.toString().substring(7).toInt() / 3
        textView2.setText(
            "Avg: " + (totalScore / totalTurns * 100).roundToInt() / 100.0
        )
    }

    private fun resetLeg(textView: TextView){
        val legNumber = tvLegsP1.text.toString().toInt() + tvLegsP2.text.toString().toInt()
        val winner = textView.text.toString()

        val stats = Stats(legNumber,winner, tvAvgP1.text.toString(),tvAvgP2.text.toString(),tvThrownP1.text.toString().substring(7).toInt(),tvThrownP2.text.toString().substring(7).toInt() )
        viewModel.insertGame(stats)
        tvScoreP1.setText("501")
        tvScoreP2.setText("501")
        tvThrownP1.setText("Darts: 0")
        tvThrownP2.setText("Darts: 0")
        tvAvgP1.setText("Avg: 0")
        tvAvgP2.setText("Avg: 0")
    }
    @RequiresApi(Build.VERSION_CODES.O)
    private fun gameEnd(){
        viewModel.deleteAllStats()
        val intent = Intent(this, EndGameActivity::class.java)
        val endgameStats = EndGameStats("Leroy", "First to 2 Legs", "Leroy vs Thomas", LocalDate.now())
        intent.putExtra(EXTRA_ENDGAME, endgameStats)
        startActivityForResult(intent, ENDGAMESTATS_REQUEST_CODE)
    }
}
