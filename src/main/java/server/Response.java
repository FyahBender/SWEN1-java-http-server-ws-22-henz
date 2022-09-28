package server;

public class Response {

    private int status;

    private String message;

    private String contentType;

    private String Content;

    public int getStatus()
    {
        return status;
    }

    public void setContent (String Input) {this.Content = Input;}


    public void setContentType(String contentType){ this.contentType = contentType; }

    public void setStatus(int status)
    {
        this.status = status;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public String toString ()
    {
        return "HTTP/1.1 " + this.status + " " + this.message + "\n" +
                "Content-Type: " + this.contentType + "\n" +
                "Content-Length: " + this.Content.length() + "\n" +
                "\n" +
                this.Content;
    }

}
