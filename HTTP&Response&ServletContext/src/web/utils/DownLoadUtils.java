package web.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class DownLoadUtils {
    public static String getFileName(String agent, String filename) throws UnsupportedEncodingException {
        if (agent.contains("MSIE")){
            filename = URLEncoder.encode(filename,"utf-8");
            filename = filename.replace("+"," ");
        }else{
            filename = URLEncoder.encode(filename,"utf-8");
        }
        return filename;
    }
}
