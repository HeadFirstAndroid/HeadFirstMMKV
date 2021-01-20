package me.yifeiyuan.hf.mmkv

import android.widget.Toast
import com.tencent.mmkv.MMKV
import me.yifeiyuan.adh.showcase.AdhShowcaseActivity
import me.yifeiyuan.adh.showcase.AdhShowcaseItem

class MainActivity : AdhShowcaseActivity() {


    private val mmkv = MMKV.defaultMMKV()

    override fun provideShowcaseItems(): List<AdhShowcaseItem> {

        return mutableListOf(

                createShowcaseItem("存入数据") {

                    mmkv?.let {
                        with(mmkv) {
                            encode("bool", true)
                            encode("int", 666)
                            encode("string", "这是个 String 类型的值")
                        }
                    }

                    Toast.makeText(this@MainActivity, "存入数据完成", Toast.LENGTH_SHORT).show()
                },

                createShowcaseItem("获取 Boolean") {
                    mmkv?.let {
                        val value = it.decodeBool("bool")
                        Toast.makeText(this@MainActivity, "取得 $value", Toast.LENGTH_SHORT).show()
                    }
                },

                createShowcaseItem("获取 Int") {
                    mmkv?.let {
                        val value = it.decodeInt("int")
                        Toast.makeText(this@MainActivity, "取得 $value", Toast.LENGTH_SHORT).show()
                    }
                },

                createShowcaseItem("获取 String") {
                    mmkv?.let {
                        val value = it.decodeString("string") //默认 null
                        Toast.makeText(this@MainActivity, "取得 $value", Toast.LENGTH_SHORT).show()
                    }
                },

                createShowcaseItem("测试 clearAll") {
                    mmkv?.clearAll()
                    Toast.makeText(this@MainActivity, "clearAll", Toast.LENGTH_SHORT).show()
                },

                createShowcaseItem("单独区分，创建独立的实例") {
                    val kv2 = MMKV.mmkvWithID("bizId")
                    kv2?.encode("kv2", "kv22222")
                },

                createShowcaseItem("多进程支持") {
                    val kv3 = MMKV.mmkvWithID("multiProcess", MMKV.MULTI_PROCESS_MODE)
                    kv3?.encode("kv3", "multiProcess value")
                },
        )
    }
}