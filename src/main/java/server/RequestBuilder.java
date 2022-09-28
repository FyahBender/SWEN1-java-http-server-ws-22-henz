package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RequestBuilder {

    public static  Request build(BufferedReader inputstream) throws IOException {

        StringBuilder builder = new StringBuilder();

        String inputLine;
        // read until we reach an empty line
        while ((inputLine = inputstream.readLine()) != null && !inputLine.equals("")) {
            builder.append(inputLine).append(System.lineSeparator());
        }

        String methodPathProtocolAndHeaders = builder.toString();

        int contentLength = getContentLength(methodPathProtocolAndHeaders);
        char[] content = new char[contentLength];
        int read = inputstream.read(content, 0, content.length);

        String requestBody = new String(content);

        Request request = new Request();
        request.setContent(methodPathProtocolAndHeaders);
        request.setMethod("");
        request.setPath("");
        request.setContentType("");
        request.setContentLength(contentLength);

        return request;


    }

    private static int getContentLength(String methodPathProtocolAndHeaders) {
        Pattern r = Pattern.compile("^Content-Length:\\s(.+)", Pattern.MULTILINE);
        Matcher m = r.matcher(methodPathProtocolAndHeaders);

        if (!m.find()) {
            return 0;
        }

        return Integer.parseInt(m.group(1));
    }
}
