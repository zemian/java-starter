package zemian.myspark;

import static spark.Spark.*;

public class Hello {
    public static void main(String[] args) {
        get("/hello", (req, res) -> "Hello World");
    }
}
