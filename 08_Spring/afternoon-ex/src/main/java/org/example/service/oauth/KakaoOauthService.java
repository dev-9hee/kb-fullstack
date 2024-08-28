package org.example.service.oauth;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class KakaoOauthService {
    private String REST_API_KEY = "df54dc30e8f798244f495a54d2f3c0e2";
    private String REDIRECT_URI = "http://localhost:8080/kakao/login";

    public String getAccessToken(String authorize_code) {
        String access_Token = "";
        String refresh_Token = "";
        String reqURL = "https://kauth.kakao.com/oauth/token";

        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            StringBuilder sb = new StringBuilder();
            sb.append("grant_type=authorization_code");
            sb.append("&client_id=").append(REST_API_KEY);
            sb.append("&redirect_uri=").append(REDIRECT_URI);
            sb.append("&code=").append(authorize_code);
            bw.write(sb.toString());
            bw.flush();

            System.out.println("ACCESS TOKEN 요청 URL : " + sb);

            int responseCode = conn.getResponseCode();
            System.out.println("ACCESS TOKEN 응답 코드 : " + responseCode);

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            StringBuilder result = new StringBuilder();

            while ((line = br.readLine()) != null) {
                result.append(line);
            }
            System.out.println("카카오 응답 body 의 내용 : " + result);

            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result.toString());

            JsonObject jsonObject = element.getAsJsonObject();
            if (jsonObject.has("access_token") && jsonObject.has("refresh_token")) {
                access_Token = jsonObject.get("access_token").getAsString();
                refresh_Token = jsonObject.get("refresh_token").getAsString();

                System.out.println("access_token : " + access_Token);
                System.out.println("refresh_token : " + refresh_Token);
            } else {
                System.out.println("토큰 정보가 없습니다.");
            }

            br.close();
            bw.close();
        } catch (IOException e) {
            System.out.println("네트워크 오류 발생: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("예상치 못한 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }

        return access_Token;
    }

    public JsonObject getUserInfo(String access_Token) {
        String reqURL = "https://kapi.kakao.com/v2/user/me";
        JsonObject userInfo = new JsonObject();

        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "Bearer " + access_Token);

            int responseCode = conn.getResponseCode();
            System.out.println("유저 정보 요청 응답 코드 : " + responseCode);

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            StringBuilder result = new StringBuilder();
            while ((line = br.readLine()) != null) {
                result.append(line);
            }
            System.out.println("유저 정보 요청 응답 Body 의 내용 : " + result);

            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result.toString());
            JsonObject response = element.getAsJsonObject();

            // ID 추출
            if (response.has("id")) {
                long id = response.get("id").getAsLong();
                System.out.println("카카오 ID : " + id);
                userInfo.addProperty("id", id);
            }

            // 닉네임 추출
            JsonObject properties = response.getAsJsonObject("properties");
            if (properties != null && properties.has("nickname")) {
                String nickname = properties.get("nickname").getAsString();
                System.out.println("카카오 닉네임 : " + nickname);
                userInfo.addProperty("nickname", nickname);
            }

            br.close(); // 자원 닫기
        } catch (IOException e) {
            System.out.println("네트워크 오류 발생: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("예상치 못한 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }

        return userInfo;  // 오류 발생 시에도 수집된 정보 반환
    }
}
