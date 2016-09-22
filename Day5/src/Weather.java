import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;
import jdk.nashorn.api.scripting.URLReader;

import java.io.*;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by tranh on 12-Sep-16.
 */
public class Weather {
    public static void main(String[] args) throws IOException {
       int a[]=new int[100];
        int k=0;

        for (int i=0;i<a.length;i++) {
            a[i]=i;
        }
        a[50]=1000;

        Arrays.sort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }
}
