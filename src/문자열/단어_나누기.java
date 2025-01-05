package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 단어_나누기 {
    public static void solution (String word) {
        List<String> list = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i < word.length()-1; i++) {
            for (int j = i+1; j < word.length(); j++) {
                String first = sb.append(word.substring(0,i)).reverse().toString();
                sb.delete(0, sb.length());
                String second = sb.append(word.substring(i,j)).reverse().toString();
                sb.delete(0, sb.length());
                String third = sb.append(word.substring(j,word.length())).reverse().toString();
                sb.delete(0, sb.length());
                list.add(first + second + third);
            }
        }
        Collections.sort(list);
        System.out.println(list.get(0));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();

        solution(word);
    }
}
