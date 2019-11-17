package mx.edu.ittepic.tpdm_u4_u5_practica1


import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity(){

    var sensorManager: SensorManager ?= null
    var oyenteProximidad : OyenteProximidad ?= null
    var oyenteAcelerometro : OyenteAcelerometro ?= null
    var oyenteShake : OyenteShake ?= null

    var x = 0f

    var countShake = 0

    var distancia = 0f

    //var lienzo:Lienzo = Lienzo(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(Lienzo(this))

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        /*val deviceSensors: List<Sensor> = sensorManager!!.getSensorList(Sensor.TYPE_ALL)

        Toast.makeText(this,"Total sensors: "+deviceSensors.size,Toast.LENGTH_SHORT).show()

        deviceSensors.forEach{
            Toast.makeText(this,"Sensor name: "+it,Toast.LENGTH_LONG).show()
        }*/


        oyenteProximidad = OyenteProximidad(this)
        oyenteAcelerometro = OyenteAcelerometro(this)
        oyenteShake = OyenteShake(this)

        sensorManager?.registerListener(oyenteProximidad,sensorManager?.getDefaultSensor(Sensor.TYPE_PROXIMITY),
            SensorManager.SENSOR_DELAY_UI)

        sensorManager?.registerListener(oyenteAcelerometro,sensorManager?.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
            SensorManager.SENSOR_DELAY_NORMAL)

        sensorManager?.registerListener(oyenteShake,sensorManager?.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
            SensorManager.SENSOR_DELAY_GAME)



    }

}
