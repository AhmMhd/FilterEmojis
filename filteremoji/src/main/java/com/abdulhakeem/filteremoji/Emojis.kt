package com.abdulhakeem.filteremoji

import android.util.Log

object Emojis
{

    private fun escapeJavaString(st: String): String {
        val builder = StringBuilder()
        try {
            for (i in 0 until st.length) {
                val c = st[i]
                if (!Character.isLetterOrDigit(c) && !Character.isSpaceChar(c) && !Character.isWhitespace(c)) {
                    var unicode = c.toString()
                    val code = c.toInt()
                    if (!(code >= 0 && code <= 255)) {
                        unicode = "\\\\u" + Integer.toHexString(c.toInt())
                    }
                    builder.append(unicode)
                } else {
                    builder.append(c)
                }
            }
            Log.i("Unicode Block", builder.toString())
        } catch (e: Exception) {
            // TODO Auto-generated catch block
            e.printStackTrace()
        }

        return builder.toString()
    }

    fun containsEmojis(str:String) : Boolean
    {
        var containsEmoji =false
        val token  = str.split("","")
        for (t in token)
        {
            if (escapeJavaString(t).contains("\\\\u"))
                containsEmoji = true
        }

        return containsEmoji
    }

    private fun convertEmoji(content: String): String {
        var content = content
        content = content.replace("\\\\u+".toRegex(), "0x")
        val keyword = "0x"

        var index = content.indexOf(keyword)
        var spaceIndex: Int

        while (index >= 0) {
            spaceIndex = content.indexOf(" ", index)

            if (spaceIndex > index) {
                val emoji = content.substring(index, spaceIndex)
                //content = content.replace(emoji.toRegex(), getEmoticon(Integer.decode(emoji)))
            }
            index = content.indexOf(keyword, index + keyword.length)
        }

        return content
    }
}