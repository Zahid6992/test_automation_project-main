package com.gmail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.util.LinkedHashMap;
import java.util.Map;


import org.apache.commons.codec.binary.Base64;
import org.json.JSONObject;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.StringUtils;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.ListMessagesResponse;
import com.google.api.services.gmail.model.Message;

public class GmailApi {

    private static final String APPLICATION_NAME = "Gmail API Java Quickstart";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String user = "me";
    static Gmail service = null;
    private static File filePath = new File(System.getProperty("user.dir") + "/credentials.json");

    public static void main(String[] args) throws IOException, GeneralSecurityException {

        getGmailService();

        getMailBody("deichmann", "DSD");

    }

    public static String getMailBody(String searchString, String shop) throws IOException {

        // Access Gmail inbox

        Gmail.Users.Messages.List request = service.users().messages().list(user).setQ(searchString);

        ListMessagesResponse messagesResponse = request.execute();
        request.setPageToken(messagesResponse.getNextPageToken());

        // Get ID of the email you are looking for
        String messageId = messagesResponse.getMessages().get(0).getId();

        Message message = service.users().messages().get(user, messageId).execute();

        // Print email body

        String emailBody = StringUtils
                .newStringUtf8(Base64.decodeBase64(message.getPayload().getParts().get(0).getBody().getData()));
        String searchPass = null;
        String password =  null;
        switch (shop)
        {
            case "DSD":
            case "DOS":
                searchPass = "Neues Passwort";
                password = emailBody.substring(emailBody.indexOf(searchPass) + 16, emailBody.indexOf(searchPass) + 25);
                break;
            case "DHU":
                searchPass = "Új jelszó";
                password = emailBody.substring(emailBody.indexOf(searchPass) + 11, emailBody.indexOf(searchPass) + 20);
                break;
            case "VHS":
                searchPass = "Nieuw wachtwoord";
                password = emailBody.substring(emailBody.indexOf(searchPass) + 18, emailBody.indexOf(searchPass) + 27);
                break;
            case "VBE":
                searchPass = "Nieuw wachtwoord";
                password = emailBody.substring(emailBody.indexOf(searchPass) + 18, emailBody.indexOf(searchPass) + 29);
                break;
            case "DUK":
                searchPass = "reset";
                password = emailBody.substring(emailBody.indexOf(searchPass) + 7, emailBody.indexOf(searchPass) + 16);
                break;
            default:
                searchPass = "New password";
                password = emailBody.substring(emailBody.indexOf(searchPass) + 14, emailBody.indexOf(searchPass) + 23);
                break;

        }


        //service.users().messages().delete(user, messageId).execute();

        System.out.println(password);

        return password;



    }

    public static Gmail getGmailService() throws IOException, GeneralSecurityException {

        InputStream in = new FileInputStream(filePath); // Read credentials.json
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Credential builder

        Credential authorize = new GoogleCredential.Builder().setTransport(GoogleNetHttpTransport.newTrustedTransport())
                .setJsonFactory(JSON_FACTORY)
                .setClientSecrets(clientSecrets.getDetails().getClientId().toString(),
                        clientSecrets.getDetails().getClientSecret().toString())
                .build().setAccessToken(getAccessToken()).setRefreshToken(
                        "YOUR_REFRESH_TOKEN");//Replace this

        // Create Gmail service
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        service = new Gmail.Builder(HTTP_TRANSPORT, JSON_FACTORY, authorize)
                .setApplicationName(GmailApi.APPLICATION_NAME).build();

        return service;
    }

    private static String getAccessToken() {

        try {
            Map<String, Object> params = new LinkedHashMap<>();
            params.put("grant_type", "refresh_token");
            params.put("client_id", "1062411885341-rjipddu3it1kbqn23klp06cfem93bpkm.apps.googleusercontent.com"); //Replace this
            params.put("client_secret", "5v4bh52kvWIMa_OgagF8-blV"); //Replace this
            params.put("refresh_token",
                    "1//09sVmHZs7mHIjCgYIARAAGAkSNwF-L9IrAPVPVbt5UZxGydtQPNGsGVGRD_eP3iICJK_uITv4Ghhh8VAmG-O1mYq8FIN6wequqwk"); //Replace this

            StringBuilder postData = new StringBuilder();
            for (Map.Entry<String, Object> param : params.entrySet()) {
                if (postData.length() != 0) {
                    postData.append('&');
                }
                postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postData.append('=');
                postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }
            byte[] postDataBytes = postData.toString().getBytes("UTF-8");

            URL url = new URL("https://accounts.google.com/o/oauth2/token");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setDoOutput(true);
            con.setUseCaches(false);
            con.setRequestMethod("POST");
            con.getOutputStream().write(postDataBytes);

            BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuffer buffer = new StringBuffer();
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                buffer.append(line);
            }

            JSONObject json = new JSONObject(buffer.toString());
            String accessToken = json.getString("access_token");
            return accessToken;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }




}
