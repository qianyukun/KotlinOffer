package questions

import java.lang.StringBuilder

fun replaceBlankInString(source: String): String {
    if (source.isNullOrEmpty())
        return "";
    var sb = StringBuilder();
    for (i in 0 until source.length-1){
        sb.append(if(source.get(i).equals(' ')) "%2D" else source.get(i))
    }
    return sb.toString()
}