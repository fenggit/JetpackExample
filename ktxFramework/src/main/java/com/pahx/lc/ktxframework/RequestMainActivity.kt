package com.pahx.lc.ktxframework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.pahx.lc.ktxframework.bean.BaseRes
import com.pahx.lc.ktxframework.bean.HomeResInfo
import com.pahx.lc.ktxframework.databinding.ActivityRequestMainBinding
import com.pahx.lc.ktxframework.lib.RequestManager
import com.pahx.lc.ktxframework.request.HomeAPI
import com.pahx.lc.ktxframework.request.HomeViewModel
import kotlinx.coroutines.*
import retrofit2.Call
import java.lang.Exception
import kotlin.concurrent.thread

class RequestMainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRequestMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRequestMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(HomeViewModel::class.java)

        viewModel.homeData.observe(this, object : Observer<BaseRes<HomeResInfo>> {
            override fun onChanged(info: BaseRes<HomeResInfo>?) {
                binding.textView.text = "curPage:" + info?.data?.curPage
            }
        })

        // 解析格式错误：Sending signal. PID: 28076 SIG: 9
        binding.button.setOnClickListener {
            //  com.google.gson.JsonSyntaxException: java.lang.IllegalStateException: Expected BEGIN_OBJECT but was NUMBER at line 1 column 21 path $.data.curPage
//            thread {
//                val call: Call<BaseRes<HomeResInfo>> =
//                    RequestManager.instance.instanceRetrofit(HomeAPI::class.java).requestHomeV2(0)
//                val execute = call.execute()
//                val body = execute.body()
//            }


                viewModel.requestHome(0)

//            GlobalScope.launch {
//                val data = request()
//            }

//            lifecycleScope.launch {
//
//            }

//            viewModelScope.launch{
//
//            }
        }


    }


    suspend fun request(): String {
        withContext(Dispatchers.IO) {
            delay(1000)
            Log.e("hefeng", "time1")
        }
        Log.e("hefeng", "time2")
        withContext(Dispatchers.IO) {
            delay(200)
            Log.e("hefeng", "time3")
        }
        Log.e("hefeng", "time4")
        // 请求数据成功
        return "success"
    }
}