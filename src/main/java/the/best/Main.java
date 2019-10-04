package the.best;

import static java.lang.Integer.parseInt;

public class Main {

    private static UserInterfaceService userInterfaceService;

    public static void main(String[] args) {
        userInterfaceService = new UserInterfaceServiceImpl();
        userInterfaceService.run();
    }


}
