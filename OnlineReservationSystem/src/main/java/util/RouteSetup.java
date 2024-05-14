package util;

import spark.route.HttpMethod;

import static spark.Spark.*;

public class RouteSetup {
    public RouteSetup(){}
    public void routeSetup(HttpMethod method, String path , spark.Route route) {
        switch (method) {
            case get:
                get(path, route);
                break;
            case post:
                post(path,route);
                break;
            case put:
                put(path,route);
                break;
            case delete:
                delete(path,route);
                break;
            default:
                throw new IllegalArgumentException("Unsupported HTTP method: " + method);
        }
    }
}
