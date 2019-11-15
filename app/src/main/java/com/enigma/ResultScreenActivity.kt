package com.enigma

import android.graphics.Color
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.enigma.databinding.ContentResultScreenBinding
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import kotlinx.android.synthetic.main.activity_result_screen.*

class ResultScreenActivity : AppCompatActivity() {
    lateinit var binding: ContentResultScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_screen)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "All Caught up!!"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val content = findViewById<View>(R.id.content)
        binding = DataBindingUtil.bind<ContentResultScreenBinding>(content)!!

        val score = intent.extras?.getInt("score")
        val total = intent.extras?.getInt("total")
        binding.score.text = score.toString()


        if (score != null) {
            when {
                score <= 5 -> {
                    binding.resultDesc.text = getString(R.string.need_improvement)
                    binding.resultDesc.setTextColor(resources.getColor(R.color.exceeded))

                    setCustomGaugeProgress(
                        ((score.toFloat() / total!!) * 100).toInt(),
                        binding.customGauge,
                        R.color.exceeded
                    )
                }
                score in 6..10 -> {
                    binding.resultDesc.text = getString(R.string.good)
                    binding.resultDesc.setTextColor(resources.getColor(R.color.high))
                    setCustomGaugeProgress(
                        ((score.toFloat() / total!!) * 100).toInt(),
                        binding.customGauge,
                        R.color.high
                    )
                }
                else -> {
                    binding.resultDesc.text = getString(R.string.excellent)
                    binding.resultDesc.setTextColor(resources.getColor(R.color.standard))
                    setCustomGaugeProgress(
                        ((score.toFloat() / total!!) * 100).toInt(),
                        binding.customGauge,
                        R.color.standard
                    )
                }
            }
        }


    }


    private fun setCustomGaugeProgress(progress: Int, customGauge: CustomGauge, color: Int) {
        if (progress <= 0) {
            customGauge.pointStartColor = ContextCompat.getColor(this, R.color.black_overlay)
            customGauge.pointEndColor = ContextCompat.getColor(this, R.color.black_overlay)
        } else {
            customGauge.pointStartColor = ContextCompat.getColor(this, color)
            customGauge.pointEndColor = ContextCompat.getColor(this, color)
        }
        object : Thread() {
            override fun run() {
                var i = 0
                while (i <= progress) {
                    try {
                        runOnUiThread {
                            customGauge.value = i * 10
                        }
                        sleep(30)
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                    i++
                }
            }
        }.start()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home->{
                onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }


    private fun setData(yVals: ArrayList<Entry>, xVals: ArrayList<String>, mChart: LineChart) {
        var xVals1 = ArrayList<String>()
        xVals1.add("Date")
        xVals1.addAll(xVals)
        val set1: LineDataSet
        mChart.getLegend().setEnabled(false)
        mChart.setDescription(null)
        // create a dataset and give it a type
        set1 = LineDataSet(yVals, "DataSet 1")
        set1.fillAlpha = 110
        // set1.setFillColor(Color.RED);

        // set the line to be drawn like this "- - - - - -"
        // set1.enableDashedLine(10f, 5f, 0f);
        // set1.enableDashedHighlightLine(10f, 5f, 0f);
        set1.color = resources.getColor(R.color.line)
        set1.setCircleColor(Color.BLACK)
        set1.lineWidth = 1f
        set1.circleRadius = 3f
        set1.setDrawCircleHole(true)
        set1.valueTextSize = 9f
        set1.setDrawFilled(false)

        val dataSets = ArrayList<ILineDataSet>()
        dataSets.add(set1) // add the datasets

        // create a data object with the datasets
        val data = LineData(dataSets)
        // set data
        mChart.setData(data)


        mChart.setVisibleXRangeMaximum(5F)
        mChart.moveViewToX(xVals1.size.toFloat())


    }
}
