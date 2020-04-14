package com.example.swipequiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.swipequiz.models.Question
import com.example.swipequiz.models.QuestionAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.question_item.*

class MainActivity : AppCompatActivity() {
    private val questions = arrayListOf<Question>()
    private val questionAdapter = QuestionAdapter(questions)

    private val SWIPE_RIGHT = 8
    private val SWIPE_LEFT = 4

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        questionAdapter.notifyDataSetChanged()
        createItemTouchHelper().attachToRecyclerView(rvQuestions)
    }

    // call the recyclerview and fill it


    private fun initViews() {
        rvQuestions.layoutManager =
            LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
        rvQuestions.adapter = questionAdapter

        rvQuestions.addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))

        for(i in Question.QUESTIONS){
            questions.add(i)
        }
    }

    private fun createItemTouchHelper(): ItemTouchHelper {
        var callback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false;
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val selectedItem = questions[position]
                if (((direction == SWIPE_RIGHT) and (selectedItem.answer)) || ((direction == SWIPE_LEFT) and (!selectedItem.answer))) {
                        Snackbar.make(tvQuestion, "Correct! Well done!", Snackbar.LENGTH_SHORT).show()
                        questions.removeAt(position)
                } else{
                    Snackbar.make(tvQuestion, "Can't remove this item, you were wrong!", Snackbar.LENGTH_SHORT).show()
                }
                questionAdapter.notifyDataSetChanged()
            }
        }
        return ItemTouchHelper(callback)
    }
}
