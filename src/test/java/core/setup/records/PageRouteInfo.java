package core.setup.records;

import java.util.regex.Pattern;

public record PageRouteInfo(String route, Pattern regexPattern) {
}
