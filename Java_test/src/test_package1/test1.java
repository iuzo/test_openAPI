package test_package1;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
public class test1 {
    public static void main(String[] args) throws IOException {
    	
    	Scanner menu = new Scanner(System.in);
    	Scanner datenum = new Scanner(System.in);
    	Scanner daynum = new Scanner(System.in);
    	
    	System.out.println("1.초단기실황, 2.초단기예보, 3.동네예보, 4.예보버전");
    	String input = menu.next();

    	System.out.println("날짜를 입력해 주세요 ex)20201129");
    	int inputdatenum = datenum.nextInt();
    	System.out.println("시간을 입력해주세요 ex)0600");
    	int inputdaynum = daynum.nextInt();
    	
    	StringBuilder urlBuilder = null;
    	switch(input)
    	{
    	case "1":
    		
    		urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/VilageFcstInfoService/getUltraSrtNcst"); /*URL*/
    		urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=H1%2BKVL4VVRqLerRMBwOFwiFjimeJLM%2BoeR8CXL4lKXN0Hq8%2Btr7j0crO25qe%2BMP%2BiTejjZsZkcovfc6bcmlePQ%3D%3D"); /*Service Key*/
            urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
            urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("200", "UTF-8")); /*한 페이지 결과 수*/
            urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*요청자료형식(XML/JSON)Default: XML*/
            urlBuilder.append("&" + URLEncoder.encode("base_date","UTF-8") + "=" + URLEncoder.encode(Integer.toString(inputdatenum), "UTF-8")); /*15년 12월 1일 발표*/
            urlBuilder.append("&" + URLEncoder.encode("base_time","UTF-8") + "=" + URLEncoder.encode(Integer.toString(inputdaynum), "UTF-8")); /*06시 발표(정시단위)*/
            urlBuilder.append("&" + URLEncoder.encode("nx","UTF-8") + "=" + URLEncoder.encode("62", "UTF-8")); /*예보지점의 X 좌표값*/
            urlBuilder.append("&" + URLEncoder.encode("ny","UTF-8") + "=" + URLEncoder.encode("126", "UTF-8")); /*예보지점 Y 좌표*/
            
    		break;
    	case "2":
    		
    		urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/VilageFcstInfoService/getUltraSrtFcst"); /*URL*/
            urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=H1%2BKVL4VVRqLerRMBwOFwiFjimeJLM%2BoeR8CXL4lKXN0Hq8%2Btr7j0crO25qe%2BMP%2BiTejjZsZkcovfc6bcmlePQ%3D%3D"); /*Service Key*/
            urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
            urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("200", "UTF-8")); /*한 페이지 결과 수*/
            urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*요청자료형식(XML/JSON)Default: XML*/
            urlBuilder.append("&" + URLEncoder.encode("base_date","UTF-8") + "=" + URLEncoder.encode(Integer.toString(inputdatenum), "UTF-8")); /*15년 12월 1일 발표*/
            urlBuilder.append("&" + URLEncoder.encode("base_time","UTF-8") + "=" + URLEncoder.encode(Integer.toString(inputdaynum), "UTF-8")); /*06시30분 발표(30분 단위)- 매시각 45분 이후 호출*/
            urlBuilder.append("&" + URLEncoder.encode("nx","UTF-8") + "=" + URLEncoder.encode("62", "UTF-8")); /*예보지점 X 좌표값*/
            urlBuilder.append("&" + URLEncoder.encode("ny","UTF-8") + "=" + URLEncoder.encode("126", "UTF-8")); /*예보지점 Y 좌표값*/
    		break;
    	case "3":
    		
    		urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/VilageFcstInfoService/getVilageFcst"); /*URL*/
    		urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=H1%2BKVL4VVRqLerRMBwOFwiFjimeJLM%2BoeR8CXL4lKXN0Hq8%2Btr7j0crO25qe%2BMP%2BiTejjZsZkcovfc6bcmlePQ%3D%3D"); /*Service Key*/
            urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
            urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("200", "UTF-8")); /*한 페이지 결과 수*/
            urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*요청자료형식(XML/JSON)Default: XML*/
            urlBuilder.append("&" + URLEncoder.encode("base_date","UTF-8") + "=" + URLEncoder.encode(Integer.toString(inputdatenum), "UTF-8")); /*15년 12월 1일발표*/
            urlBuilder.append("&" + URLEncoder.encode("base_time","UTF-8") + "=" + URLEncoder.encode(Integer.toString(inputdaynum), "UTF-8")); /*05시 발표*/
            urlBuilder.append("&" + URLEncoder.encode("nx","UTF-8") + "=" + URLEncoder.encode("62", "UTF-8")); /*예보지점 X 좌표값*/
            urlBuilder.append("&" + URLEncoder.encode("ny","UTF-8") + "=" + URLEncoder.encode("126", "UTF-8")); /*예보지점의 Y 좌표값*/
    		break;
    	case "4":
    		
    		urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/VilageFcstInfoService/getFcstVersion"); /*URL*/
            urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=H1%2BKVL4VVRqLerRMBwOFwiFjimeJLM%2BoeR8CXL4lKXN0Hq8%2Btr7j0crO25qe%2BMP%2BiTejjZsZkcovfc6bcmlePQ%3D%3D"); /*Service Key*/
            urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
            urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("200", "UTF-8")); /*한 페이지 결과 수*/
            urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*요청자료형식(XML/JSON)Default: XML*/
            urlBuilder.append("&" + URLEncoder.encode("ftype","UTF-8") + "=" + URLEncoder.encode("ODAM", "UTF-8")); /*파일구분-ODAM: 동네예보실황, -VSRT: 동네예보초단기, -SHRT: 동네예보단기*/
            urlBuilder.append("&" + URLEncoder.encode("basedatetime","UTF-8") + "=" + URLEncoder.encode(Integer.toString(inputdatenum)+Integer.toString(inputdaynum), "UTF-8")); /*각각의 base_time 로 검색 참고자료 참조*/
    		break;
    			
    	}
    	
        
        URL url = new URL(urlBuilder.toString());
        
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
    }
}