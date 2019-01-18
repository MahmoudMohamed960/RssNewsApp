package com.example.mahmoudmohamed.rssnews.help;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Helper_Class {
    Context context;
   public static List list;
    public Helper_Class(Context context) {
        this.context=context;
        list=new ArrayList();
    }

    //make textview link
    public void textViewLink(TextView view,String link) {
        SpannableStringBuilder spanTxt = new SpannableStringBuilder(
                "See More");
        spanTxt.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {

            }
        }, spanTxt.length() - "See More".length(), spanTxt.length(), 0);
        spanTxt.setSpan(new ForegroundColorSpan(Color.BLUE), 8, spanTxt.length(), 0);
        view.setMovementMethod(LinkMovementMethod.getInstance());
        view.setText(spanTxt, TextView.BufferType.SPANNABLE);
    }
   //get all proviers

    public List getList() {
        return list;
    }


}
