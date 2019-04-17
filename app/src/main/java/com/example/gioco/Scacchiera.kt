package com.example.gioco

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import kotlinx.android.synthetic.main.activity_main.view.*

class Scacchiera : View {
    constructor(context: Context) : super(context, null)
    constructor(context: Context,attrs: AttributeSet?) : super(context,attrs,0)
    var l=0
    var a=0
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        var schermo = Rect() //creo un rettangolo
        canvas?.getClipBounds(schermo) //gli inserisco le dimensioni della view
        var n: Int = number.text.toInt()
        l=(schermo.right - schermo.left)/5 //larghezza quadratino
        a=(schermo.bottom - schermo.top)/5 //altezza quadratino (l'origine degli assi di rect sta in alto a sx)
        var paint = Paint() //creo un pennello
        var left_increment=0
        var top_increment=0
        //inizializzo le caselle a colore alterni, le pari bianche e le dispari nere
        for (i in 1..5) {
            left_increment=0
            for (j in 1..5) {
                var casella = Rect(schermo.left + left_increment, schermo.top + top_increment, schermo.left + left_increment + l,schermo.top + top_increment + a)
                if ((i+j)%2 == 0)   //controllo se sono nelle caselle pari
                    paint.color = Color.WHITE //setto il colore del pennello
                else
                    paint.color = Color.BLACK
                canvas?.drawRect(casella, paint) //coloro la singola casella
                left_increment = left_increment + l //passo alla prossima casella a dx
            }
            top_increment=top_increment + a  //passo alla prossima casella in basso
        }
    }
}