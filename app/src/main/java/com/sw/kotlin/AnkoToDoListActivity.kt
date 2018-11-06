package com.sw.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.sw.kotlin.tips.R
import org.jetbrains.anko.alert
import org.jetbrains.anko.button
import org.jetbrains.anko.dip
import org.jetbrains.anko.editText
import org.jetbrains.anko.hintResource
import org.jetbrains.anko.noButton
import org.jetbrains.anko.padding
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.textResource
import org.jetbrains.anko.toast
import org.jetbrains.anko.verticalLayout
import org.jetbrains.anko.yesButton

/**
 * Created by dingjinwen01 on 2018/9/6.
 */
class AnkoToDoListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verticalLayout {
            padding = dip(30)
            var title = editText {
                id = R.id.todo_title
                hintResource = R.string.title_hint
            }

            var desc = editText {
                id = R.id.todo_desc
                hintResource = R.string.description_hint
            }

            var btn = button {
                id = R.id.todo_add
                textResource = R.string.add_todo
                onClick {
                    alert("删除通知") {
                        yesButton { toast("确定") }
                        noButton { toast("删除") }
                    }.show()

//                    startActivity(intentFor<KotlinTip2Activity>().singleTop())
                }
            }
        }

    }
}
