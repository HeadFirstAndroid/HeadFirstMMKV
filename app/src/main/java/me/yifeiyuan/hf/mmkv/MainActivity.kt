package me.yifeiyuan.hf.mmkv

import android.os.Bundle
import android.widget.Toast
import me.yifeiyuan.adh.showcase.AdhShowcaseActivity
import me.yifeiyuan.adh.showcase.AdhShowcaseItem

class MainActivity : AdhShowcaseActivity() {

    override fun provideShowcaseItems(): List<AdhShowcaseItem> {

        return mutableListOf(

            createShowcaseItem("测试初始化默认") {
                Toast.makeText(this@MainActivity, "测试初始化默认", Toast.LENGTH_SHORT).show()
            },
            createShowcaseItem("测试存入") {
                Toast.makeText(this@MainActivity, "测试存入", Toast.LENGTH_SHORT).show()
            }
        )
    }
}