//------Generated by the Framework and must be changed-----//
//------Feature Extraction Functions-----//
package br.ufc.POC1.model.mapek.analysis

import org.apache.commons.math3.stat.descriptive.moment.Kurtosis
import org.apache.commons.math3.stat.descriptive.moment.Skewness
import java.util.*

class FeatureFunctions {
    companion object{
        fun Mean(values: MutableList<Double>?):Double{
            var sum = 0.0
            for (value in values!!){
                sum += value
            }
            return sum/values!!.size
        }

        fun Max(values: MutableList<Double>?):Double{
            var max = 0.0
            for (value in values!!){
                if(max < value)
                    max = value
            }
            return max
        }

        fun Min(values: MutableList<Double>?):Double{
            var min = 99999.0
            for (value in values!!){
                if(min > value)
                    min = value
            }
            return min
        }

        fun STD(values: MutableList<Double>?):Double{
            var sum = 0.0
            var standardDeviation = 0.0

            for (num in values!!) {
                sum += num
            }

            val mean = sum / 10

            for (num in values!!) {
                standardDeviation += Math.pow(num - mean, 2.0)
            }

            return Math.sqrt(standardDeviation / 10)
        }

        fun Kurtosis(values: MutableList<Double>?):Double{
            return Kurtosis().evaluate(values!!.toDoubleArray())
        }

        fun Skewness(values: MutableList<Double>?):Double{
            return Skewness().evaluate(values!!.toDoubleArray())
        }

        fun Entropy(values: MutableList<Double>?):Double{
            var entropy = 0.0
            for (prob in values!!) {
                if (prob != 0.0)
                    entropy -= prob * Math.log(prob) / Math.log(2.0)
            }
            return entropy
        }


        // mean absolute deviation
        fun MAD(values: MutableList<Double>?):Double{
            var absSum = 0.0
            for (value in values!!) absSum = (absSum + Math.abs(value - Mean(values) ))

            // Return mean absolute deviation
            return absSum / values!!.size
        }


        fun median(l:Int, n:Int):Int{
            return ((n-l+1+1)/2 - 1)+l
        }

        // IQR
        fun IQR(values: MutableList<Double>?): Double {
            var avalues = values!!.toDoubleArray()
            Arrays.sort(avalues)

            // Index of median
            // of entire data
            val mid_index = median(0,avalues.size)

            // Median of first half
            val Q1 = avalues[median(0,mid_index)]

            // Median of second half
            val Q3 = avalues[median(mid_index + 1, avalues.size)]

            // IQR calculation
            return Q3 - Q1
        }

    }

}