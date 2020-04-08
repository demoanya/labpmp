package com.anna.demeshko.millionaire

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var preferencesHelper: PreferencesHelper
    lateinit var questions: List<Question>

    var baseValue = 100000
    var sum = 0
    var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        preferencesHelper = PreferencesHelper(this)

        btnHint.setOnClickListener {
            btnHint.visibility = View.GONE
            val answers = questions[currentIndex].answers
            val correctIndex = answers.indexOfFirst { it.isCorrect }
            if (correctIndex >= 2) {
                btnAnswer1.isEnabled = false
                btnAnswer2.isEnabled = false
            } else  {
                btnAnswer3.isEnabled = false
                btnAnswer4.isEnabled = false
            }
        }

        btnTakeMoney.setOnClickListener {
            showWinAlert()
        }

        btnAnswer1.setOnClickListener(this)
        btnAnswer2.setOnClickListener(this)
        btnAnswer3.setOnClickListener(this)
        btnAnswer4.setOnClickListener(this)

        startGame()
    }

    private fun startGame() {
        sum = 0
        currentIndex = 0
        btnHint.visibility = if (preferencesHelper.isHintEnabled) View.VISIBLE else View.GONE
        questions = generateQuestions().shuffled()
        questions.forEach { it.answers = it.answers.shuffled() }
        questions = questions.take(preferencesHelper.questionCount)
        showNextQuestion()
        tvSum.text = sum.toString()
    }

    private fun showNextQuestion() {
        val question = questions[currentIndex]
        tvDescription.text = question.description
        btnAnswer1.text = question.answers[0].title
        btnAnswer2.text = question.answers[1].title
        btnAnswer3.text = question.answers[2].title
        btnAnswer4.text = question.answers[3].title

        btnAnswer1.isEnabled = true
        btnAnswer2.isEnabled = true
        btnAnswer3.isEnabled = true
        btnAnswer4.isEnabled = true
    }

    override fun onClick(v: View?) {
        val answers = questions[currentIndex].answers
        val correctIndex = answers.indexOfFirst { it.isCorrect }
        if (v?.id == R.id.btnAnswer1 && correctIndex == 0
            || v?.id == R.id.btnAnswer2 && correctIndex == 1
            || v?.id == R.id.btnAnswer3 && correctIndex == 2
            || v?.id == R.id.btnAnswer4 && correctIndex == 3) {
            handleCorrectAnswer()
        } else {
            handleWrongAnswer()
        }

    }

    private fun handleWrongAnswer() {
        showLostAlert()
    }

    private fun handleCorrectAnswer() {
        if (currentIndex == questions.size - 1) {
            sum = 1000000
            showWinAlert()
        } else {
            currentIndex++
            sum += baseValue
            tvSum.text = sum.toString()
            showNextQuestion()
        }
    }

    private fun showWinAlert() {
        val msg = getString(R.string.win_title, sum)
        showAlert(msg)
    }

    private fun showLostAlert() {
        val msg = getString(R.string.loose_title)
        showAlert(msg)
    }

    private fun showAlert(msg: String) {
        AlertDialog.Builder(this)
            .setMessage(msg)
            .setPositiveButton(R.string.ok) { dialog, _ ->
                dialog.dismiss()
                finish()
            }.show()
    }
}
