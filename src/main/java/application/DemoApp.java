package application;

import server.Application;
import server.Request;
import server.Response;

public class DemoApp implements Application {

    @Override
    public Response handle(Request request)
    {
        Response response = new Response();

        //sample Response
        response.setStatus(200);
        response.setMessage("OK");
        response.setContentType("text/plain");
        response.setContent(request.getContent()); // we passed the input request as content

        return response;
    }




}
