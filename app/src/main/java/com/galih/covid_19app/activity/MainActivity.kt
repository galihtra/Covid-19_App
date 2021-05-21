package com.galih.covid_19app.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.galih.covid_19app.adapter.ProvinceAdapter
import com.galih.covid_19app.api.RetrofitClient
import com.galih.covid_19app.databinding.ActivityMainBinding
import com.galih.covid_19app.model.IndonesiaResponse
import com.galih.covid_19app.model.ProvinceResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupView()
        showIndonesia()
        showProvince()
    }

    private fun setupView() {
        supportActionBar!!.hide()
    }

    private fun showIndonesia() {
        RetrofitClient.instance.getIndonesia()
            .enqueue(object : Callback<ArrayList<IndonesiaResponse>> {
                override fun onResponse(
                    call: Call<ArrayList<IndonesiaResponse>>,
                    response: Response<ArrayList<IndonesiaResponse>>
                ) {
                    val indonesia = response.body()?.get(0)
                    val positive = indonesia?.positif
                    val hospitalized = indonesia?.dirawat
                    val recover = indonesia?.sembuh
                    val death = indonesia?.meninggal

                    binding.tvPositif.text = positive
                    binding.tvHospitalized.text = hospitalized
                    binding.tvRecovery.text = recover
                    binding.tvDead.text = death
                }

                override fun onFailure(call: Call<ArrayList<IndonesiaResponse>>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
                }

            })
    }

    private fun showProvince() {
        RetrofitClient.instance.getProvince().enqueue(object :
            Callback<ArrayList<ProvinceResponse>> {
            override fun onResponse(
                call: Call<ArrayList<ProvinceResponse>>,
                response: Response<ArrayList<ProvinceResponse>>
            ) {
                val list = response.body()
                val adapter = list?.let { ProvinceAdapter(it) }
                binding.recyclerView.adapter = adapter
            }

            override fun onFailure(call: Call<ArrayList<ProvinceResponse>>, t: Throwable) {
                Toast.makeText(applicationContext, "${t.message}", Toast.LENGTH_SHORT).show()
            }

        })
    }


}