package mx.edu.ittepic.tpdm_u4_u5_practica1

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.widget.Toast

class OyenteProximidad (p:MainActivity): SensorEventListener {
    var puntero = p
    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

    override fun onSensorChanged(event: SensorEvent?) {
        puntero.distancia = event!!.values[0]
        if (event!!.values[0]==0f)
        Toast.makeText(puntero,"distancia = "+event!!.values[0],Toast.LENGTH_SHORT).show()

    }

}