package com.sw.kotlin

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sw.kotlin.tips.R
import org.jetbrains.anko.button
import org.jetbrains.anko.dip
import org.jetbrains.anko.editText
import org.jetbrains.anko.hintResource
import org.jetbrains.anko.padding
import org.jetbrains.anko.support.v4.UI
import org.jetbrains.anko.textResource
import org.jetbrains.anko.verticalLayout


/**
 * Created by dingjinwen01 on 2018/9/6.
 */
class AnkoEditFragment: Fragment() {

//    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        return UI{
//            verticalLayout {
//                padding=dip(30)
//                var title=editText{
//                    id= R.id.todo_title
//                    hintResource=R.string.title_hint
//                }
//
//                var desc=editText {
//                    id= R.id.todo_desc
//                    hintResource=R.string.description_hint
//                }
//
//                var btn=button {
//                    id=R.id.todo_add
//                    textResource=R.string.add_todo
//                    setOnClickListener {
//                       Log.e("djw","点击---")
//                    }
//                }
//            }
//        }.view
//    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }
}