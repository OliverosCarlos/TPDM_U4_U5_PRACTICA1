package mx.edu.ittepic.tpdm_u4_u5_practica1

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import java.util.ArrayList


class Lienzo(p:MainActivity): View(p) {

    var puntero = p

    var icono1 = Imagen(this, 50f, 250f, R.drawable.icono5)
    var icono2 = Imagen(this, 200f, 250f, R.drawable.icono1)
    var icono3 = Imagen(this, 350f, 250f, R.drawable.icono2)
    var icono4 = Imagen(this, 500f, 250f, R.drawable.icono3)
    var icono5 = Imagen(this, 650f, 250f, R.drawable.icono4)

    var icono1_2 = Imagen(this, 50f, 250f, R.drawable.bn_icono5)
    var icono2_2 = Imagen(this, 188f, 250f, R.drawable.bn_icono1)
    var icono3_2 = Imagen(this, 326f, 250f, R.drawable.bn_icono2)
    var icono4_2 = Imagen(this, 454f, 250f, R.drawable.bn_icono3)
    var icono5_2 = Imagen(this, 592f, 250f, R.drawable.bn_icono4)

    var icono1_3 = Imagen(this, 50f, 250f, R.drawable.vicono5)
    var icono2_3 = Imagen(this, 188f, 250f, R.drawable.vicono1)
    var icono3_3 = Imagen(this, 326f, 250f, R.drawable.vicono2)
    var icono4_3 = Imagen(this, 454f, 250f, R.drawable.vicono3)
    var icono5_3 = Imagen(this, 592f, 250f, R.drawable.vicono4)

    var icono1_4 = Imagen(this, 50f, 250f, R.drawable.iconfinder1)
    var icono2_4 = Imagen(this, 188f, 250f, R.drawable.iconfinder2)
    var icono3_4 = Imagen(this, 326f, 250f, R.drawable.iconfinder3)
    var icono4_4 = Imagen(this, 454f, 250f, R.drawable.iconfinder4)
    var icono5_4 = Imagen(this, 592f, 250f, R.drawable.iconfinder5)

    var arrayImg = arrayListOf<Imagen>(icono1,icono2,icono3,icono4,icono5)
    var arrayImg2 = arrayListOf<Imagen>(icono1_2,icono2_2,icono3_2,icono4_2,icono5_2)
    var arrayImg3 = arrayListOf<Imagen>(icono1_3,icono2_3,icono3_3,icono4_3,icono5_3)
    var arrayImg4 = arrayListOf<Imagen>(icono1_4,icono2_4,icono3_4,icono4_4,icono5_4)
    var picono: Imagen ?= null

    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        var p = Paint()

        if(puntero.distancia == 0f){
            Toast.makeText(puntero,"hide",Toast.LENGTH_SHORT).show()
            c.restore()
        }
        else{
            when (puntero.countShake) {
                0 -> {
                    drawImgs(arrayImg, c)
                    moverImagenes(arrayImg, puntero.x)
                }
                1 -> {
                    drawImgs(arrayImg2, c)
                    moverImagenes(arrayImg2, puntero.x)
                }
                2 -> {
                    drawImgs(arrayImg3, c)
                    moverImagenes(arrayImg3, puntero.x)
                }
                3 -> {
                    drawImgs(arrayImg4, c)
                    moverImagenes(arrayImg4, puntero.x)
                }
            }


        }


    }

    override fun onTouchEvent(e: MotionEvent): Boolean {
        when(e.action){

            MotionEvent.ACTION_DOWN -> {
                if(icono1.estaEnArea(e.getX(),e.getY())||
                    icono1_2.estaEnArea(e.getX(),e.getY())||
                    icono1_3.estaEnArea(e.getX(),e.getY())||
                    icono1_4.estaEnArea(e.getX(),e.getY())
                ){
                    Toast.makeText(puntero,"Tocaste icono Facebook", Toast.LENGTH_SHORT)
                        .show()
                    picono = icono1

                }
                if(icono2.estaEnArea(e.getX(),e.getY())||
                    icono2_2.estaEnArea(e.getX(),e.getY())||
                    icono2_3.estaEnArea(e.getX(),e.getY())||
                    icono2_4.estaEnArea(e.getX(),e.getY())
                ){
                    Toast.makeText(puntero,"Tocaste icono Instagram", Toast.LENGTH_SHORT)
                        .show()
                    picono = icono2
                }
                if(icono3.estaEnArea(e.getX(),e.getY())||
                    icono3_2.estaEnArea(e.getX(),e.getY())||
                    icono3_3.estaEnArea(e.getX(),e.getY())||
                    icono3_4.estaEnArea(e.getX(),e.getY())
                ){
                    Toast.makeText(puntero,"Tocaste icono Twitter", Toast.LENGTH_SHORT)
                        .show()
                    picono = icono3
                }
                if(icono4.estaEnArea(e.getX(),e.getY())||
                    icono4_2.estaEnArea(e.getX(),e.getY())||
                    icono4_3.estaEnArea(e.getX(),e.getY())||
                    icono4_4.estaEnArea(e.getX(),e.getY())
                ){
                    Toast.makeText(puntero,"Tocaste icono Whatsapp", Toast.LENGTH_SHORT)
                        .show()
                    picono = icono4
                }
                if(icono5.estaEnArea(e.getX(),e.getY())||
                    icono5_2.estaEnArea(e.getX(),e.getY())||
                    icono5_3.estaEnArea(e.getX(),e.getY())||
                    icono5_4.estaEnArea(e.getX(),e.getY())
                ){
                    Toast.makeText(puntero,"Tocaste icono youtube", Toast.LENGTH_SHORT)
                        .show()
                    picono = icono5
                }
            }
            MotionEvent.ACTION_MOVE -> {

            }
            MotionEvent.ACTION_UP -> {
                picono = null
            }

        }
        return true
    }

    fun moverImagenes(arrayImagenes: ArrayList<Imagen>,x:Float){
        arrayImagenes.forEach {
            it.mover(x)
        }
        invalidate()
    }

    fun hideImages(c:Canvas){
        c.restore()
        invalidate()
    }

    fun drawImgs(arrayImagenes: ArrayList<Imagen>,c:Canvas) {
        arrayImagenes.forEach {
            it.pintar(c)

        }
    }
}