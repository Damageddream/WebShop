    package com.webshop.shop.app;

    import com.webshop.shop.app.controllers.ShopController;

    /**
     * The main entry point for the web shop application. This class is
     * responsible for displaying the application name,  initializing the primary
     * {@code ShopController}, and managing its lifecycle.
     *
     * @author Marcin
     * @version 1.0
     */
    public class ShopApp {
        private static final String APP_NAME = "Webshop v 1.0";

        /**
         * The starting point of the web shop application. It prints the application's
         * name, creates a {@code ShopController} object to handle the main application
         * flow, and initiates the controller's shutdown process when the application ends.
         *
         * @param args Command-line arguments (unused in this example)
         */
        public static void main(String[] args) {
            System.out.println(APP_NAME);
            ShopController shopControl = new ShopController();
            shopControl.mainLoop();
            shopControl.close();
        }
    }
